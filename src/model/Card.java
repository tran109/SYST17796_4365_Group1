/*
 * [Card]
 *
 * Description:
 * This class models a Card, that has a rank and a suit
 */
package model;

/**
 *
 *
 * @author dancye
 * @modified Si Tran
 * @modified Nathan Morrone
 * @modified Sugi Oh
 * @modified Inho Choi
 */
/*Asscoation with the DeckOfCards, the "Card" classes services
are used by the "DeckOfCards"*/
public class Card {

    private Suit suit;
    private Rank rank;


    //Constructor with arguments
    public Card(Rank rank) {

        this.rank = rank;
    }

    //Constructor with arguments
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //This method is used to return the suit of the card
    public Suit getSuit() {
        return suit;
    }

    //This method is used to set the suit of the card
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    //This method is used to return the rank of the card
    public Rank getRank() {
        return rank;
    }

    //This method is used to set the rank of the card
    public void setRank(Rank rank) {
        this.rank = rank;
    }


    //This method returns a string representation of the card and its rank
    @Override
    public String toString() {
        return String.format("Rank: %s%n", this.getRank());
    }

}
