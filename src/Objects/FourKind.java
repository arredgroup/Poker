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
public class FourKind extends Movement{
    
    public FourKind(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int max = 0, pos = 0, flag=0;
        for (int i = 0; i < players.size(); i++) {
            if(i==0){
                max = players.get(i).getCards().get(0).getNumber();
                pos = 0;
            }else{
                if(max<=players.get(i).getCards().get(0).getNumber()){
                    if(max==players.get(i).getCards().get(0).getNumber()){
                        flag=1;
                    }else{
                        max = players.get(i).getCards().get(0).getNumber();
                        pos = i;
                        flag=0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
       
        pos=0;max=0;flag=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> same = this.getCards(4, players.get(i).getCards());
            ArrayList<Card> other_cards = this.getCardsNot(players.get(i).getCards(), same);
            Card alone = other_cards.get(0);
            if(i==0){
                max = alone.getNumber();
                pos = 0;
            }
            else{
                if(max<=alone.getNumber()){
                    if(max==alone.getNumber()){
                        flag=1;
                    }else{
                        max = alone.getNumber();
                        pos = i;
                    }
                }
            }  
        }
        if(flag==0)
            return players.get(pos);
        
        pos=0;max=0;
        int total;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> same = this.getCards(4, players.get(i).getCards());
            total = 0;
            for (int j = 0; j < same.size(); j++) {
                total += same.get(i).getValue()*same.get(i).getType();
            }
            if(i==0){
                max = total;
                pos = 0;
            }
            else{
                if(max<total){
                    max = total;
                    pos = i;
                } 
            }
        }
        return players.get(pos);
    }

    @Override
    public boolean isValid(Player player) {
        if(!this.haveSame(4, player.getCards()))
            return false;
        return true;
    }
    
    
}
