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
public class Player {
    
    private String name;
    private ArrayList<Card> cards;
    
    public Player(String name){
        this.name = name;
        this.cards = new ArrayList();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public void setCards(ArrayList<Card> cards){
        this.cards=cards;
    }
    
    public void addCard(Card card){
        this.cards.add(card);
    }
    
    public void printCards(){
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("\t"+ cards.get(i).toString());
        }
    }

 
}
