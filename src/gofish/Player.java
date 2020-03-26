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
    private int id; //the unique number for each player
    private double score; // the score for each player 

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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
        //Defined two serperate variables because the variable names are key in geards to describing but the theri values represent. I didnt add them as properties in the class because it doesnt make sense
        int goFishCardLimit = 4;
        int cardsLeftInDeck = 4; //When the deck has 4 cards left to make sure the user doesnt take more than needed from the deck or else we will get an Array Index out of boudns
        //If the deck of cards has less than 4 cards left remove the remainder cards and add to current card hand
        if (deckOfcards.size() < cardsLeftInDeck) {
            for (int i = 0; i < deckOfcards.size(); i++) {
                this.currentCards.add(deckOfcards.getCards().remove(i));
            }
        } else {
            //Each player will ADD 4 cards  after the go fish to their CURRENT currentCards so we are manipulating the current card hand of the player and adding cards to it
            for (int i = 0; i < goFishCardLimit; i++) {
                this.currentCards.add(deckOfcards.getCards().remove(i)); //.remove, removes object references and assigns them to the arraylist reference temp

            }
        }
    }

    //Player checks if he still has cards after he gives away cards away to opposing player, if player doesnt have cards left, the dealer will declare the opposing player the winner
    public boolean hasCardsLeftOver() {
        if (currentCards.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    //Helper method, may make it private idk yet. may use this method ot determine an aternate path if the player doesnt have the card
    public boolean hasCardsInCurrentHand(Card card) {
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
            if (hasCardsInCurrentHand(card)) {
                temp.add(currentCards.remove(i));

            }
        }

        return temp;
    }

    //Method for recieving cards
    public void getOtherPlayersCards(ArrayList<Card> cards) {
        for (int i = 0; i < currentCards.size(); i++) {
            currentCards.add(cards.get(i));
        }
    }

    @Override
    public String toString() {
        return String.format("");
    }
}
