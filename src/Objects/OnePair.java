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
public class OnePair extends Movement{
    
    public OnePair(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int pos=0,max=0,flag=0,total=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> pair = this.getCards(2, players.get(i).getCards());
            if(i==0){
                pos = i;
                max = pair.get(0).getNumber();
            }else{
                if(max<=pair.get(0).getNumber()){
                    if(max==pair.get(0).getNumber())
                        flag = 1;
                    else{
                        pos = i;
                        max = pair.get(0).getNumber();
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        for (int x = 0; x < 3; x+=1){
            pos=0;max=0;flag=0;total=0;
            for (int i = 0; i < players.size(); i++) {
                ArrayList<Card> pair = this.getCards(2, players.get(i).getCards());
                ArrayList<Card> other = this.getCardsNot(players.get(i).getCards(), pair);
                if(i==0){
                    pos = i;
                    max = other.get(x).getNumber();
                }else{
                    if(max<=other.get(x).getNumber()){
                        if(max==other.get(x).getNumber())
                            flag = 1;
                        else{
                            pos = i;
                            max = other.get(x).getNumber();
                            flag = 0;
                        }
                    }
                }
            }
            if(flag==0)
                return players.get(pos);
        }
        
        pos=0;max=0;flag=0;total=0;
        for (int i = 0; i < players.size(); i++) {
            total = 0;
            for (int j = 0; j < players.get(i).getCards().size(); j++) {
                total += players.get(i).getCards().get(j).getValue()*players.get(i).getCards().get(j).getType();
            }
            if(i==0){
                pos = i;
                max = total;
            }else{
                if(max<total){
                    pos = i;
                    max = total;
                }
            }
        }
        return players.get(pos);
    }

    @Override
    public boolean isValid(Player player) {
        if(!this.haveSame(2, player.getCards()))
            return false;
        return true;
    }
    
    
}
