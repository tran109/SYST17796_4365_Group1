/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Su
 */
public class PlayerTest {
    
    public PlayerTest() {
    }


    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Player instance = new Player();
        double expResult = 0.0;
        double result = instance.getScore();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetScore() {
        System.out.println("setScore");
        double score = 0.0;
        Player instance = new Player();
        instance.setScore(score);
    }

    @Test
    public void testGetCurrentCards() {
        System.out.println("getCurrentCards");
        Player instance = new Player();
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCurrentCards();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCurrentCards() {
        System.out.println("setCurrentCards");
        ArrayList<Card> cardsFromDealer = null;
        Player instance = new Player();
        instance.setCurrentCards(cardsFromDealer);
    }

    @Test
    public void testGoFish() {
        System.out.println("goFish");
        DeckOfCards deckOfcards = null;
        Player instance = new Player();
        instance.goFish(deckOfcards);
    }

    @Test
    public void testHasCardsInCurrentHand() {
        System.out.println("hasCardsInCurrentHand");
        Rank rank = null;
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.hasCardsInCurrentHand(rank);
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
