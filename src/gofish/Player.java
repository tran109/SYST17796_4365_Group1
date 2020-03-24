/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package gofish;

import java.util.ArrayList;

//Aggregated class
public abstract class Player {

    //player associates with the dealer and other players
    private ArrayList<Card> currentCards = new ArrayList<Card>();
    private String name; //the unique name for this player

    public Player(String name, ArrayList<Card> currentCards) {
        this.name = name;
        this.currentCards = currentCards;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCurrentCards() {
        return currentCards;
    }


    //SETTERS
    //This method receieves cards from the dealers method "distribute crad"
    public void setCurrentCards(ArrayList<Card> cardsFromDealer) {
        this.currentCards = cardsFromDealer;
    }

    //OTHER
    //The player interacts witht eh "DeckOfCards" and removes 4 cards from the curretn obejct, and the palyer adds the cards to their currentCards
    public void goFish(DeckOfCards deckOfcards) {
        //If the deck of cards has less than 4 cards left remove the remainder cards and add to current card hand
        if (deckOfcards.size() < 4) {
            for (int i = 0; i < deckOfcards.size(); i++) {
                this.currentCards.add(deckOfcards.getCards().remove(i));
            }
        } else {
            //Each player will ADD 4 cards to their CURRENT currentCards so we are manipulating the current card hand of the player and adding cards to it
            for (int i = 0; i < 4; i++) {
                this.currentCards.add(deckOfcards.getCards().remove(i)); //.remove, removes object references and assigns them to the arraylist reference temp

            }
        }
    }

    public boolean checkForCardsInHand(Card card) {
        boolean value = false;
        for (int i = 0; i < currentCards.size(); i++) {
            if (currentCards.get(i).equals(card)) {
                value = true;
                break;
            } else {
                value = false;
            }
        }
        return false;
    }

    public ArrayList<Card> giveCardsTooOtherPlayer(Card card) {
        ArrayList<Card> temp = new ArrayList<Card>();
        for (int i = 0; i < currentCards.size(); i++) {
            if (checkForCardsInHand(card)) {
                temp.add(currentCards.remove(i));

            }
        }
        return temp;
    }
        
    //Method for recieving cards
    public void recieveOtherPlayersCards(ArrayList<Card> cards){
        for(int i = 0; i < currentCards.size(); i++){
            currentCards.add(cards.get(i));     
        }
        
    }
}
