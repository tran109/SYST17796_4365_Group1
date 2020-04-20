/*
 * [Class name]
 * Author: [the name of the person who created the class. It might be different from yours]
 * Date: [date]
 *
 * Description:
 * [Description about the class]
 */
package model;

/**
 *
 * @author nathan
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

    private Rank(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

}
