/*
 * [Class name]
 * Author: [the name of the person who created the class. It might be different from yours]
 * Date: [date]
 *
 * Description
 * [Description about the class]
 */
package gofish;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nathan
 */

//Aggregated class
public class Dealer {

    //association --> not a direct association but the dealer will shuffle the deck of cards then distrubte cards to palyers

    //This class is delegated the responsiblity of delcaring the game winner of "GoFish"

    public Dealer() {
    }

    public ArrayList<Card> distributeCards(DeckOfCards deckOfCards) {
        shuffle(deckOfCards);

        ArrayList<Card> temp = new ArrayList<Card>();

        //Each player is allowed 7 cards to start off with
        for (int i = 0; i < 7; i++) {
            temp.add(deckOfCards.getCards().remove(i)); //.remove, removes a card one by one from the "deckOfCards"
        }

        return temp;

    }

    //Shuffles the deck of cards in random order, this method takes an ArrayList of "Card" type objects
    public void shuffle(DeckOfCards deckOfCards) {
        Collections.shuffle(deckOfCards.getCards());

    }
    
    //Count the deck after each time a player takes cards from the deck of cards.
    public boolean isDeckEmpty(DeckOfCards deckOfCards){
        if(deckOfCards.size() == 0){
            return true;
        } else {
            return false;
        }
        
    }
    public void declareWinner(){
        
    }
    

        
}
