/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package model;

import java.util.ArrayList;

//Aggregated class
public class Player {

    //player associates with the dealer and other players
    private ArrayList<Card> currentCards;
    private String name; //the unique name for this player
    private int id; //the unique number for each player
    private double score; // the score for each player 

    public Player() {
    }

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
        if (deckOfcards.size() <= cardsLeftInDeck) {
            for (int i = 0; i < deckOfcards.size(); i++) {
                this.currentCards.add(deckOfcards.getCards().remove(i));
            }
        } else {

         
                //Each player will ADD 4 cards  after the go fish to their CURRENT currentCards so we are manipulating the current card hand of the player and adding cards to it
                    this.currentCards.add(deckOfcards.getCards().remove(0)); 
                    this.currentCards.add(deckOfcards.getCards().remove(1));
                    this.currentCards.add(deckOfcards.getCards().remove(2));
                    this.currentCards.add(deckOfcards.getCards().remove(3));
                
            
        }
    }


    public boolean hasCardsInCurrentHand(Rank rank) {
        boolean value = false;
        for (int i = 0; i < currentCards.size(); i++) {
            if (currentCards.get(i).getRank().equals(rank)) {
                value = true;
                break;
            } else {
                value = false;
            }
        }
        return value;
    }

    @Override
    public String toString() {

        String output = String.format("Player Name: %s%n", getName());
        for (Card x : currentCards) {
            output += x.toString();

        }
        return output;
    }
}
