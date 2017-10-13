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
public class Straight extends Movement{
    
    public Straight(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int pos=0, max=0, flag=0, total = 0;
        for (int i = 0; i < players.size(); i++) {
            if(this.isAceMax(players.get(i))){
                flag+=1;
                pos = i;
            }
        }
        if(flag==1)
            return players.get(pos);
        if(flag>1){
            for (int i = 0; i < players.size(); i++) {
                total = 0; flag = 0;
                if(this.isAceMax(players.get(i))){
                    for (int j = 0; j < players.get(i).getCards().size(); j++) {
                        if(players.get(i).getCards().get(j).getNumber()==0)
                            total += (14*players.get(i).getCards().get(j).getType());
                        else
                            total += (players.get(i).getCards().get(j).getValue()*players.get(i).getCards().get(j).getType());
                    }
                    if(flag==0){
                        max = total;
                        flag+=1;
                        pos = i;
                    }else{
                        if(max<total){
                            max = total;
                            pos = i;
                        }
                    }
                }
            }
            return players.get(pos);
        }
        
        total=0;max=0;pos=0;
        for (int i = 0; i < players.size(); i++) {
            total = (players.get(i).getCards().get(4).getValue()*players.get(i).getCards().get(4).getType());
            if(i==0){
                max = total;
                pos = i;
            }else{
                if(max < total){
                    max = total;
                    pos = i;
                }
            }
        }
        return players.get(pos);
    }

    @Override
    public boolean isValid(Player player) {
        for (int i = 0; i < 17; i++) {
            if(this.isNumber(i, player.getCards()) && this.isNumber((i+1)%13, player.getCards()) &&
           this.isNumber((i+2)%13, player.getCards()) && this.isNumber((i+3)%13, player.getCards()) &&
           this.isNumber((i+4)%13, player.getCards()))
                return true;
        }
        return false;
    }
    
    private boolean isAceMax(Player player){
        if(this.isNumber(0,player.getCards()) && this.isNumber(12,player.getCards()) &&
           this.isNumber(11,player.getCards()) && this.isNumber(10,player.getCards()) &&
           this.isNumber(9,player.getCards()))
            return true;
        return false;
    }
    
}
