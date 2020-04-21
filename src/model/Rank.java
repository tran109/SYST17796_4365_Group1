/*
 * [Rank]
 *
 * Description:
 * This enum class models the rank of a single card within a standard card deck
 * of 52 cards
 */
package model;

/**
 *
 * @author Si Tran
 * @author Nathan Morrone
 */
public enum Rank {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(8),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int cardNumber;

    //Private constructor for the enum constants
    private Rank(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    //This method will return the card number as an integer
    public int getCardNumber() {
        return cardNumber;
    }

}
