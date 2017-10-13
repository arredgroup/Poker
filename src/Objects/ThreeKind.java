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
public class ThreeKind extends Movement{
    
    public ThreeKind(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int max=0,pos=0,total=0,flag=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            if(i==0){
                max = three.get(0).getNumber();
                pos = i;
            }else{
                if(max<=three.get(0).getNumber()){
                    if(max==three.get(0).getNumber()){
                        flag=1;
                    }else{
                        max = three.get(0).getNumber();
                        pos = i;
                        flag=0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        max=0;pos=0;total=0;flag=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            ArrayList<Card> other = this.getCardsNot(players.get(i).getCards(), three);
            if(i==0){
                max = other.get(0).getNumber();
                pos = i;
            }else{
                if(max<=other.get(0).getNumber()){
                    if(max==other.get(0).getNumber()){
                        flag=1;
                    }else{
                        max = other.get(0).getNumber();
                        pos = i;
                        flag=0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        max=0;pos=0;total=0;flag=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> three = this.getCards(3, players.get(i).getCards());
            ArrayList<Card> other = this.getCardsNot(players.get(i).getCards(), three);
            if(i==0){
                max = other.get(1).getNumber();
                pos = i;
            }else{
                if(max<=other.get(1).getNumber()){
                    if(max==other.get(1).getNumber()){
                        flag=1;
                    }else{
                        max = other.get(1).getNumber();
                        pos = i;
                        flag=0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        max=0;pos=0;total=0;flag=0;
        for (int i = 0; i < players.size(); i++) {
            total = 0;
            for (int j = 0; j < players.get(i).getCards().size(); j++) {
                total += players.get(i).getCards().get(j).getValue()*players.get(i).getCards().get(j).getType();
            }
            if(i==0){
                max = total;
                pos = i;
            }else{
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
        if(!this.haveSame(3, player.getCards()))
            return false;
        return true;
    }
    
}
