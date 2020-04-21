/*
 * [DeckOfCards]
 *
 * Description:
 * This class models a standard deck of cards, that can range from 0 
 * to any sized deck. In the porgram case the deck will contain 52 cards
 */
package model;

import model.Card;
import java.util.ArrayList;

/**
 * @author Si Tran
 * @author Nathan Morrone
 * @author Sugi Oh
 * @author Inho Choi
 */
//Aggregated class --> This class is part of Go-Fish
public class DeckOfCards {

    
    /* Having an arrayList of "Card" obejcts doesnt limit the size of
    the card deck and can be manipulated to the needs of the program through 
    the pre defiend user friendly methods used on arrayList type references.
    This will make the code more extensible*/
  
    private ArrayList<Card> cards = new ArrayList<Card>();

    //This no-arg constructor will initalize the deck of cards with 52 cards
    public DeckOfCards() {
        
        
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                this.cards.add(new Card(suit, rank));
            }
        }
        
    }

    //This method will return the cards within the deck of cards
    public ArrayList<Card> getCards() {
        return cards;
    }


    //This method will set the cards within the deck of cards
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
  
    //This method will return number amount of cards within the deck of cards
    public int size() {
        return cards.size();
    }
    
}
