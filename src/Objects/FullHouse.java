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
public class FullHouse extends Movement{
    
    public FullHouse(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int pos=0,max=0,flag=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            //ArrayList<Card> two = this.getCards(2, players.get(i).getCards());
            if(i==0){
                pos = 0;
                max = three.get(0).getNumber();
                flag=0;
            }
            else{
                if(max<=three.get(0).getNumber()){
                    if(max==three.get(0).getNumber())
                        flag=1;
                    else{
                        pos = i;
                        max = three.get(0).getNumber();
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        pos=0;max=0;flag=0;
        for (int i = 0; i < players.size(); i++) {
            //ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            ArrayList<Card> two = this.getCards(2, players.get(i).getCards());
            if(i==0){
                pos = 0;
                max = two.get(0).getNumber();
                flag=0;
            }
            else{
                if(max<=two.get(0).getNumber()){
                    if(max==two.get(0).getNumber())
                        flag=1;
                    else{
                        pos = i;
                        max = two.get(0).getNumber();
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        pos=0;max=0;flag=0;
        int total = 0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            total=0;
            for (int j = 0; j < three.size(); j++) {
                total += three.get(j).getValue()*three.get(j).getType();
            }
            //ArrayList<Card> two = this.getCards(2, players.get(i).getCards());
            if(i==0){
                pos = 0;
                max = total;
                flag=0;
            }
            else{
                if(max<=total){
                    if(max==total)
                        flag=1;
                    else{
                        pos = i;
                        max = total;
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        pos=0;max=0;flag=0;
        total = 0;
        for (int i = 0; i < players.size(); i++) {
            //ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            ArrayList<Card> two = this.getCards(2, players.get(i).getCards());
            total=0;
            for (int j = 0; j < two.size(); j++) {
                total += two.get(j).getValue()*two.get(j).getType();
            }
            if(i==0){
                pos = 0;
                max = total;
            }
            else{
                if(max<=total){
                    pos = i;
                    max = total;
                }
            }
        }
        return players.get(pos);   
    }

    @Override
    public boolean isValid(Player player) {
        if(!this.isFullHouse(player.getCards()))
            return false;
        return true;
    }
    
    /*
        Valida si hay un trio y un par
    */
    private boolean isFullHouse(ArrayList<Card> cards){
        int count_two=0, count_three=0, three = 0;
        for (int i = 0; i < cards.size(); i++) {
            if(this.getNumberSame(cards.get(i).getNumber(), cards)==3){
                count_three++;
                three = cards.get(i).getNumber();
            }
            if(this.getNumberSame(cards.get(i).getNumber(), cards)==2){
                count_two++;
            }
        }
        if(count_three==3 && count_two==2)
            return true;
        return false;
    }
    
}
