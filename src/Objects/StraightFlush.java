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
public class StraightFlush extends Movement{
    
    public StraightFlush(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int max=0, pos=0, flag=0;
        ArrayList<Integer> positions = new ArrayList();
        ArrayList<Integer> types = new ArrayList();
        for (int i = 0; i < players.size(); i++) {
            if(i==0){
                max = players.get(0).getCards().get(4).getNumber();
                pos = i;
                positions.add(i);
                types.add(players.get(i).getCards().get(4).getType());
            }else{
                if(max<=players.get(i).getCards().get(4).getNumber()){
                    if(max==players.get(i).getCards().get(4).getNumber()){
                        positions.add(i);
                        types.add(players.get(i).getCards().get(4).getType());
                        flag=1;
                    }else{
                        max=players.get(i).getCards().get(4).getNumber();
                        pos = i;
                        positions.clear();
                        types.clear();
                        positions.add(i);
                        types.add(players.get(i).getCards().get(4).getType());
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        for (int i = 0; i < positions.size() && i < types.size(); i++) {
            if(i==0){
                max = types.get(i);
                pos = positions.get(i);
            }else{
                if(max<types.get(i)){
                    max = types.get(i);
                    pos = positions.get(i);
                }
            }
        }
        return players.get(pos);
    }

    @Override
    public boolean isValid(Player player) {
        if(!this.isSameSuit(player.getCards()))
            return false;
        for (int i = 0; i < 17; i++) {
            if(this.isNumber(i%13, player.getCards()) && this.isNumber((i+1)%13, player.getCards()) &&
           this.isNumber((i+2)%13, player.getCards()) && this.isNumber((i+3)%13, player.getCards()) &&
           this.isNumber((i+4)%13, player.getCards()))
                return true;
        }
        return false;
    }
    
    
}
