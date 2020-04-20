/**
 * Group 1 February 01 2020
 */
package model;

/**
 *
 *
 * @author dancye
 * @author Nathan Morrone
 */

//Asscoation with the DeckOfCards, the "Card" classes services are used by the "DeckOfCards"
public  class Card {

    private Suit suit;
    private Rank rank;
    
    public Card(){
        
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    public boolean equals(Card card){
        return this.rank.name().equals(card.getRank().name());
    }

    @Override
    public String toString(){
        return String.format("Rank: %s\tSuit: %s%n", this.getRank(), this.getSuit());
    }

}
