/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package gofish;

import java.util.ArrayList;


//Aggregated class --> This class is part of Go-Fish
//Asscoation with the Card, the "DeckOfCards" depends on the card class. The DeckOfCards has a 1:any reltionship between the Card class.
public class DeckOfCards {

    
    /*With the card class being exetsnible because of its enum properties, it
    allows the deck of cards to have a card count based on how many "Suit" enums and "Rank" enums
    are defined in the enum classes. Having an arrayList of "Card" 
    obejcts doesnt limit the size of the card deck and can be manipulated to the 
    needs of the program through the pre defiend user friendly 
    methods used on arrayList type references. */
   
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

    //This method is extra we do not need it, this makes the class more cohesive.
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
  
    public int size() {
        return cards.size();
    }

}
