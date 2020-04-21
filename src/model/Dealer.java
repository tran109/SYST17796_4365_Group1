/*
 * [Dealer]
 *
 * Description:
 * This class models a dealer of the game go_fish 
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Sugi Oh
 * @author Inho Choi
 * @author Nathan Morrone
 * @author Si Tran
 *
 *
 */
//Aggregated class
public class Dealer {

    private static Dealer dealer = null;

    //Simpleton pattern reference return method
    public static Dealer getInstance() {
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

    //This method is used to distrubte cards to the players of the game
    public ArrayList<Card> distributeCards(DeckOfCards deckOfCards) {

        ArrayList<Card> temp = new ArrayList<Card>();

        temp.addAll(deckOfCards.getCards().subList(0, 7));
        deckOfCards.getCards().removeAll(temp);

        return temp;

    }

    //This method will count the deck after each player has a turn.
    public boolean isDeckEmpty(DeckOfCards deckOfCards) {
        if (deckOfCards.getCards().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    //This method shuffles the deck of cards in random order
    public void shuffle(DeckOfCards deckOfCards) {
        Collections.shuffle(deckOfCards.getCards());

    }

    /*This method will return the winner based on which player has 
    the highest number of SETS, a single set is 4 cards that share the 
    same rank*/
    public String declareWinner(Player player1, Player player2) {

        int player1pile = getCardPiles(player1);
        int player2pile = getCardPiles(player2);

        if (player1pile == player2pile) {
            return "NO WINNER DRAW\n";

        } else if (player1pile > player2pile) {
            return player1.getName();
        } else {
            return player2.getName();
        }
    }

    /*This is a helper method for the "declareWinner()" method*/
    private int getCardPiles(Player player) {
        int rankOne = 0;
        int rankTwo = 0;
        int rankThree = 0;
        int rankFour = 0;
        int rankFive = 0;
        int rankSix = 0;
        int rankSeven = 0;
        int rankEight = 0;
        int rankNine = 0;
        int rankTen = 0;
        int rankJack = 0;
        int rankQueen = 0;
        int rankKing = 0;

        /*this variable "numOfSets" will represent the number of sets
        (4 cards with the same rank is a set)*/
        int numOfSets = 0;
        for (Card currentCard : player.getCurrentCards()) {

            switch (currentCard.getRank().name()) {

                case "ONE":
                    ++rankOne;
                    break;
                case "TWO":
                    ++rankTwo;
                    break;
                case "THREE":
                    ++rankThree;
                    break;
                case "FOUR":
                    ++rankFour;
                    break;
                case "FIVE":
                    ++rankFive;
                    break;
                case "SIX":
                    ++rankSix;
                    break;
                case "SEVEN":
                    ++rankSeven;
                    break;
                case "EIGHT":
                    ++rankEight;
                    break;
                case "NINE":
                    ++rankNine;
                    break;
                case "TEN":
                    ++rankTen;
                    break;
                case "JACK":
                    ++rankJack;
                    break;
                case "QUEEN":
                    ++rankQueen;
                    break;
                case "KING":
                    ++rankKing;
                    break;

            }
        }

        if (rankOne == 4) {
            numOfSets++;
        } else if (rankTwo == 4) {
            numOfSets++;
        } else if (rankThree == 4) {
            numOfSets++;
        } else if (rankFour == 4) {
            numOfSets++;
        } else if (rankFive == 4) {
            numOfSets++;
        } else if (rankSix == 4) {
            numOfSets++;
        } else if (rankSeven == 4) {
            numOfSets++;
        } else if (rankEight == 4) {
            numOfSets++;
        } else if (rankNine == 4) {
            numOfSets++;
        } else if (rankTen == 4) {
            numOfSets++;
        } else if (rankJack == 4) {
            numOfSets++;
        } else if (rankQueen == 4) {
            numOfSets++;
        } else if (rankKing == 4) {
            numOfSets++;
        }

        return numOfSets;

    }

}
