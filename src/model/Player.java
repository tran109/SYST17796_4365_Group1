/*
 * [Player]
 *
 * Description:
 * thsi class models a player of the game go_fish
 */
package model;

import java.util.ArrayList;

/**
 * 
 * @author Sugi Oh
 * @author Si Tran
 * @author Inho Choi
 * @author Nathan Morrone
 */
 //Player associates with the dealer , other players, and the deck of cards
public class Player {

  
    private ArrayList<Card> currentCards;
    private String name;
    private int id; 
    private double score; 

    //No-arg cosntructor
    public Player() {
    }

    //Constructor with arguments
    public Player(String name, ArrayList<Card> currentCards) {
        this.name = name;
        this.currentCards = currentCards;
    }

 
    //This method will return the id of the player
    public int getId() {
        return id;
    }

    //This method will set the id of the player
    public void setId(int id) {
        this.id = id;
    }

    //This method will return the name of the player
    public String getName() {
        return name;
    }

    //This method will set the name of the player
    public void setName(String name) {
        this.name = name;
    }

    //This method will return the score of the player
    public double getScore() {
        return score;
    }

    //This method will set the score of the player
    public void setScore(double score) {
        this.score = score;
    }

    //This method will return the current cards the player contains
    public ArrayList<Card> getCurrentCards() {
        return currentCards;
    }

    //This method will set the current cards the player contains
    public void setCurrentCards(ArrayList<Card> cardsFromDealer) {
        this.currentCards = cardsFromDealer;
    }

  
    /*This method is used to retrieve the opposing players cards if the cards
    match the same rank requested by the asking player*/
    public void getOpposingPlayerCards(Player player1, Player player2,
            Rank rank, ArrayList<Card> list) {
        for (int i = 0; i < player2.getCurrentCards().size(); i++) {
            if (player2.getCurrentCards().get(i).getRank().equals(rank)) {

                list.add(player2.getCurrentCards().get(i));
                player1.getCurrentCards().add(new Card(rank));

            }

        }

    }

    /*This method is used to check if the opposing player has cards left over 
    after the asking player has or has not recieved cards from the opposing
    player*/
    public boolean hasCardsLeftOver() {

        return !(currentCards.isEmpty());

    }

  
    /*This method is used to check if the current player has cards in their
    hand based on a rank*/
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


    //This method is used when the player must "go fish"
    public boolean goFish(DeckOfCards deckOfcards) {

        boolean value = false;
        if (!deckOfcards.getCards().isEmpty()) {

            this.currentCards.add(deckOfcards.getCards().remove(0));

            value = true;
        }
        return value;

    }

    /*This method returns a srtrign representation of the players name 
    and the current cards within their hand based on a rank*/
    @Override
    public String toString() {

        int num = 1;
        String output = String.format("Player Name: %s%n%nCurrent "
                + "Card Ranks:%n", getName());
        for (Card x : currentCards) {
            output += String.format("%d. %s%n", num, x.getRank().name());
            num++;

        }
        return output;
    }
}
