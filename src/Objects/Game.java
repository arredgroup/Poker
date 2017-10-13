/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author carredon
 */
public class Game {
    
    private ArrayList<Player> players;
    private ArrayList<Card> cards;
    private ArrayList<Movement> movements;
    //private int joker; // 0->NO, 1->RED, 2->BLACK, 3->ALL
    
    public Game(){
        this.players = new ArrayList();
        this.cards = new ArrayList();
        this.movements = new ArrayList();
    }
    
    public void initialize(){
        this.fillMovements();
        this.fillCards();
        this.createPlayers();
        this.dealCards();
        this.printGame();
        /*this.setJoker();
        if(this.joker>0){
            System.out.println("Manos Actualizadas");
            this.printGame();
        }*/
        this.play();
    }
    
    private void fillCards(){
        for (int i = 0; i < 13; i++) {
            for (int j = 1; j < 5; j++) {
                cards.add(new Card(j, i));
            }
        }
    }
    /*
    private void setJoker(){
        String n;
        do{
            System.out.println("Desea Utilizar Comodín (S/N): ");
            Scanner in = new Scanner(System.in); 
            n = in.nextLine();
        }while(!n.contains("S") && !n.contains("s")  && !n.contains("N") && !n.contains("n"));
        if((n.contains("S") || n.contains("s") )){
            int n_joker;
            do{
                System.out.println("Ingrese cantidad de Comodines (máx 2): ");
                Scanner in = new Scanner(System.in); 
                n_joker = in.nextInt();
            }while(n_joker<1 || n_joker>2);
            if(n_joker==1){
                int color=0;
                do{
                    System.out.println("En qué Color desea utilizar el comodín (1: Rojo, 2:Negro): ");
                    Scanner in = new Scanner(System.in); 
                    color = in.nextInt();
                }while(color<1 || color>2);
                this.joker=color;
            }else{
                this.joker=3;
            }
        }else{
            this.joker=0;
        }
    }
    */
    private void fillMovements(){
        movements.add(new StraightRealFlush("Straight Real Flush", 0));
        movements.add(new StraightFlush("Straight Flush", 1));
        movements.add(new FourKind("Four of a Kind", 2));
        movements.add(new FullHouse("Full House", 3));
        movements.add(new Flush("Flush", 4));
        movements.add(new Flush("Straight", 5));
        movements.add(new Flush("Three of a kind", 6));
        movements.add(new TwoPair("Two pair", 7));
        movements.add(new OnePair("One pair", 8));
        movements.add(new HighCard("High Card", 9));
    }
    
    private void createPlayers(){
        int n;
        do{
            System.out.println("Ingrese cantidad de Jugadores: ");
            Scanner in = new Scanner(System.in); 
            n = in.nextInt();
        }while(n<1 || n>10);
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el nombre del Jugador #" + (i+1) + ": ");
            Scanner in = new Scanner(System.in); 
            players.add(new Player(in.nextLine()));
        }
    }
    
    private void dealCards(){
        Random r=new Random();
        int total_cards = 52;
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 5; j++) {
                int nCard;
                do{
                 nCard = r.nextInt()%total_cards;
                }while(nCard<0);
                Card deal_card = cards.remove(nCard);
                players.get(i).addCard(deal_card);
                total_cards--;
            }
            Collections.sort(players.get(i).getCards());
        }
    }
    
    private void play(){
        int flag = 0;
        ArrayList<Player> local_players;
        for (int i = 0; i < movements.size(); i++) {
            local_players = new ArrayList();
            for (int j = 0; j < players.size(); j++) {
                if(this.movements.get(i).isValid(players.get(j)))
                    local_players.add(players.get(j));
            }
            if(local_players.size()==1){
                flag = 1;
                System.out.println("El Ganador es: "+ local_players.get(0).getName());
                return;
            }
            if(local_players.size()>1){
                flag = 1;
                Player winner = this.movements.get(i).compare(local_players);
                System.out.println("El Ganador es: "+ winner.getName());
                return;
            }
        }
        if(flag==0){
            System.out.println("No hay Ganadores");
        }
    }
    
    private void printGame(){
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println("Jugador "+ player.getName());
            player.printCards();
        }
    }
    
}
