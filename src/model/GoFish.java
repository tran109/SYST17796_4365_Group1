/*
 * [GoFish]
 *
 * Description:
 * This class is an aggregating class that is made up of aggregated objects
 * , that include a list of players, a dealer, and a deck of cards. This class
 * models a game of go fish
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Inho Choi
 * @author Sugi Oh
 * @author Nathan Morrone
 * @author Si Tran
 */
/*Aggregating class --> This class is made up of a Dealer, DeckOfCards, 
and Players*/
public class GoFish {

    private String gameName;//the title of the game
    private ArrayList<Player> players;//Aggregated class 
    private Dealer dealer; //Aggregated class 
    private DeckOfCards deckOfCards; //Aggregated class 

    public GoFish() {
        this.gameName = "Go Fish";
        //Aggregated classes/objects
        players = new ArrayList<Player>();
        dealer = Dealer.getInstance();
        deckOfCards = new DeckOfCards();

    }

    //This method is used ot return the game name
    public String getGameName() {
        return gameName;
    }

    //This method is used to set the game name
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    //This method is used to return the players within the game
    public ArrayList<Player> getPlayers() {
        return players;
    }

    //This method is used to set the players within the game
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    //This method is used to return the dealer within the game
    public Dealer getDealer() {
        return dealer;
    }

    //This method is used to set the dealer within the game
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    //This method is used to return the deck of cards within the game
    public DeckOfCards getDeckOfCards() {
        return deckOfCards;
    }

    //This method is used to set the deck of cards within the game
    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

}
