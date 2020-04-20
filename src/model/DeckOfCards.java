/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package model;

import model.Card;
import java.util.ArrayList;


//Aggregated class --> This class is part of Go-Fish
public class DeckOfCards {

    
    /* Having an arrayList of "Card" obejcts doesnt limit the size of the card deck
    and can be manipulated to the needs of the program through the pre defiend user 
    friendly methods used on arrayList type references. */
   
    ArrayList<Card> cards = new ArrayList<Card>();


   
    public DeckOfCards() {
        
        
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                this.cards.add(new Card(suit, rank));
            }
        }
        
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
  
    public int size() {
        return cards.size();
    }
    
    
    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();
        
        for(Card x : cards.getCards()){
            System.out.println(x);
        }
    }

}
