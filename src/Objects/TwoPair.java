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
public class TwoPair extends Movement{
    
    public TwoPair(String name, int id){
        super(name,id);
    }

    @Override
    public Player compare(ArrayList<Player> players) {
        int max=0,pos=0,flag=0,total=0;
        for(int x = 2; x >= 0; x-=2){
            max=0;pos=0;flag=0;total=0;
            for (int i = 0; i < players.size(); i++) {
                ArrayList<Card> others = this.getTwoPairSame(players.get(i).getCards());
                if(i==0){
                    max = others.get(x).getNumber();
                    pos = i;
                }else{
                    if(max<=others.get(x).getNumber()){
                        if(max==others.get(x).getNumber())
                            flag = 1;
                        else{
                            max = others.get(x).getNumber();
                            pos = i;
                            flag = 0;
                        }
                    }
                }
            }
            if(flag==0)
                return players.get(pos);
        }
        max=0;pos=0;flag=0;total=0;
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> two_pairs = this.getTwoPairSame(players.get(i).getCards());
            ArrayList<Card> alone = this.getCardsNot(players.get(i).getCards(), two_pairs);
            if(i==0){
                max = alone.get(0).getNumber();
                pos = i;
            }else{
                if(max<=alone.get(0).getNumber()){
                    if(max==alone.get(0).getNumber())
                        flag = 1;
                    else{
                        max = alone.get(0).getNumber();
                        pos = i;
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        max=0;pos=0;flag=0;total=0;
        for (int i = 0; i < players.size(); i++) {
            total = 0;
            for(int x = 0; x < players.get(i).getCards().size(); x++){
                total = players.get(i).getCards().get(x).getValue()*players.get(i).getCards().get(x).getType();
            }
            if(i==0){
                max = total;
                pos = i;
            }else{
                if(max<=total){
                    if(max==total)
                        flag = 1;
                    else{
                        max = total;
                        pos = i;
                        flag = 0;
                    }
                }
            }
        }
        if(flag==0)
            return players.get(pos);
        
        return null;
    }

    @Override
    public boolean isValid(Player player) {
        if(!this.haveTwoPairSame(player.getCards()))
            return false;
        return true;
    }
    
    private boolean haveTwoPairSame(ArrayList<Card> cards){
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            if(this.getNumberSame(cards.get(i).getNumber(), cards)==2)
                count++;
        }
        if(count==4)
            return true;
        return false;
    }
    
    private ArrayList<Card> getTwoPairSame(ArrayList<Card> cards){
        ArrayList<Card> two_pairs = new ArrayList();
        for (int i = 0; i < cards.size(); i++) {
            if(this.getNumberSame(cards.get(i).getNumber(), cards)==2)
                two_pairs.add(cards.get(i));
        }
        return two_pairs;
    }
    
}
