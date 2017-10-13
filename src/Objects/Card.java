/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author carredon
 */
public class Card implements Comparable<Card>{
    
    private int type;
    private int color;
    private int number;
    
    
    public Card(int type, int number){
        this.type = type;
        this.number = number;
        if(this.type==1 || this.type==4)
            this.color = 0;
        else
            this.color = 1;
    }

    public int getType(){
        return type;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }
    
    public int getValue(){
        return (this.number+1);
    }
    
    @Override
    public String toString(){
        String type_word="";
        switch(this.type){
            case 4: type_word = "Picas"; break;
            case 3: type_word = "Corazones"; break;
            case 2: type_word = "Tréboles"; break;
            case 1: type_word = "Diamantes"; break;
        }
        if(this.number>0 && this.number<10)
            return (this.number+1) + " de " + type_word;
        if(this.number==0)
            return "AS de " + type_word;
        if(this.number==10)
            return "J de " + type_word;
        if(this.number==11)
            return "Q de " + type_word;
        if(this.number==12)
            return "K de " + type_word;
        return "Carta no reconocida";
    }

    @Override
    public int compareTo(Card card) {
        if(this.getValue()<card.getValue())
            return -1;
        if(this.getValue()>card.getValue())
            return 1;
        return 0;
    }
    
    public boolean equals(Card card){
        if(this.type==card.getType() && this.number==card.getNumber())
            return true;
        return false;
    }
    
}
