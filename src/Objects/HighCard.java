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
public class HighCard extends Movement{
    
    public HighCard(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int pos=0,max=0,flag=0,total=0;
        for(int x = 4; x >= 0; x--){
            total = 0;
            flag = 0;
            for (int i = 0; i < players.size(); i++) {
                if(i==0){
                    pos = i;
                    max = players.get(i).getCards().get(x).getNumber();
                }else{
                    if(max<=players.get(i).getCards().get(x).getNumber()){
                        if(max==players.get(i).getCards().get(x).getNumber())
                            flag=1;
                        else{
                            pos = i;
                            max = players.get(i).getCards().get(x).getNumber();
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
        return true;
    }
    
    
}
