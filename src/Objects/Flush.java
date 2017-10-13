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
public class Flush extends Movement{

    public Flush(String name, int id){
        super(name,id);
    }
    
    @Override
    public Player compare(ArrayList<Player> players) {
        int max=0, total=0, pos=0, flag=0;
        for (int x = 4; x >= 0; x--){
            max=0;total=0;pos=0;flag=0;
            for (int i = 0; i < players.size(); i++) {
                if(i==0){
                    max = players.get(i).getCards().get(x).getNumber();
                    pos = i;
                }else{
                    if(max<=players.get(i).getCards().get(x).getNumber()){
                        if(max==players.get(i).getCards().get(x).getNumber())
                            flag = 1;
                        else{
                            max = players.get(i).getCards().get(x).getNumber();
                            pos = i;
                            flag = 0;
                        }
                    }
                }
            }
            if(flag==0)
                return players.get(pos);
        }
        pos = 0;
        max = 0;
        for (int i = 0; i < players.size(); i++) {
            total = 0;
            for (int j = 0; j < players.get(i).getCards().size(); j++) {
                total += (players.get(i).getCards().get(j).getValue()*players.get(i).getCards().get(j).getType());
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
        if(!this.isSameSuit(player.getCards()))
            return false;
        return true;
    }
    
    
    
}
