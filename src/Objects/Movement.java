/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author carredon
 */
public abstract class Movement {
    
    private String name;
    private int id;
    
    public Movement(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /*
        Valida si un número está en las cartas
    */
    protected boolean isNumber(int number, ArrayList<Card> cards){
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getNumber()==number)
                return true;
        }
        return false;
    }
    
    /*
        Valida si las cartas del jugador son de un mismo tipo
    */
    protected boolean isSameSuit(ArrayList<Card> cards){
        int type = 0;
        for (int i = 0; i < cards.size(); i++) {
            if(i==0)
                type = cards.get(0).getType();
            else{
                if(cards.get(i).getType()!=type)
                    return false;
            }
        }
        return true;
    }
    
    /*
        Devuelve todas las cartas que tienen el mismo número
    */
    protected ArrayList<Card> getCardsSame(int number, ArrayList<Card> cards){
        ArrayList<Card> same = new ArrayList();
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getNumber()==number)
                same.add(cards.get(i));
        }
        return same;
    }
    
    /*
        Devuelve las cartas cuyos números que se repiten n veces
    */
    protected ArrayList<Card> getCards(int number, ArrayList<Card> cards){
        ArrayList<Card> same = new ArrayList();
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if(cards.get(i).getNumber()==cards.get(j).getNumber()){
                    count++;
                    same.add(cards.get(j));
                }
            }
            if(count==number)
                return same;
            same.clear();
            count=0;
        }
        return same;
    }
    
    protected ArrayList<Card> getCardsNot(ArrayList<Card> cards, ArrayList<Card> exists){
        int flag=0;
        ArrayList<Card> not = new ArrayList();
        for (int i = 0; i < exists.size(); i++) {
            flag = 0;
            for (int j = 0; j < cards.size(); j++) {
                if(exists.get(i).equals(cards.get(j)))
                    flag=1;
            }
            if(flag==0)
                not.add(exists.get(i));
        }
        return not;
    }
    
    /*
        Devuelve la cantidad de veces que un número se repite
    */
    protected int getNumberSame(int number, ArrayList<Card> cards){
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getNumber()==number)
                count++;
        }
        return count;
    }
    
    /*
        Valida si hay n cartas iguales
    */
    protected boolean haveSame(int n, ArrayList<Card> cards){
        for (int i = 0; i < cards.size(); i++) {
            if(this.getNumberSame(cards.get(i).getNumber(), cards)==n)
                return true;
        }
        return false;
    }
    
    /*
        Devuelve el valor máximo de las cartas
    */
    public int highCard(ArrayList<Card> cards){
        int max = 0;
        for (int i = 0; i < cards.size(); i++) {
            if(max<cards.get(i).getNumber()){
                max = cards.get(i).getValue();
            }
        }
        return max;
    }
    
    /*
        Indica que Jugador en este movimiento posee la mejor mano
    */
    public abstract Player compare(ArrayList<Player> players);
    
    /*
        Indica si un Jugador puede tener este movimiento o mano
    */
    public abstract boolean isValid(Player player);
    
}
