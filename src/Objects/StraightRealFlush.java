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
public class StraightRealFlush extends Movement{

    
    public StraightRealFlush(String name, int id){
        super(name,id);
    }
    
    @Override
    public Player compare(ArrayList<Player> players) {
        int max=0, pos=0;
        for (int i = 0; i < players.size(); i++) {
            if(i==0){
                max = players.get(0).getCards().get(0).getType();
                pos = 0;
            }else{
                if(players.get(i).getCards().get(0).getType()>max){
                    max = players.get(i).getCards().get(0).getType();
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
        if(this.isNumber(0,player.getCards()) && this.isNumber(12,player.getCards()) &&
           this.isNumber(11,player.getCards()) && this.isNumber(10,player.getCards()) &&
           this.isNumber(9,player.getCards()))
            return true;
        return false;
    }
    
}
