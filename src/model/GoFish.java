/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package model;

import model.DeckOfCards;
import model.Dealer;
import java.util.ArrayList;

//Aggregating class --> This class is made up of a Dealer, DeckOfCards, and Players
public class GoFish {

    private final String gameName;//the title of the game
    private ArrayList<Player> players;//Aggregated class -> the Go-Fish game needs players to work, so the players are part of the game. Players can exist in other games so its an aggregation
    private Dealer dealer; //Aggregated class --> the Go-Fish game needs a dealer for it work, so the dealer in part of the game even though it could be an association. remember that aggregation is a form of association.
    private DeckOfCards deckOfCards; //Aggregated class --> the Go-Fish game needs a deck of cards but the deck of cards can exist without the game Go-Fish existing

    public GoFish() {
        this.gameName = "Go Fish";
        //Aggregated classes/objects
        players = new ArrayList<Player>();
        dealer = new Dealer();
        deckOfCards = new DeckOfCards();

    }

    public String getGameName() {
        return gameName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public DeckOfCards getDeckOfCards() {
        return deckOfCards;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public int getNumberOfPlayers() {
        return this.getPlayers().size();
    }

    //Print out each object and its propertys and delcare the winner using the dealer class
    public String toString() {
        return String.format("");
    }

 
}
