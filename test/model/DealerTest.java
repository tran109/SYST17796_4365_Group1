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
public class DealerTest {
    
    public DealerTest() {
    }

    @Test
    public void testDistributeCards() {
        System.out.println("distributeCards");
        DeckOfCards deckOfCards = null;
        Dealer instance = new Dealer();
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.distributeCards(deckOfCards);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsDeckEmpty() {
        System.out.println("isDeckEmpty");
        DeckOfCards deckOfCards = null;
        Dealer instance = new Dealer();
        boolean expResult = false;
        boolean result = instance.isDeckEmpty(deckOfCards);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        DeckOfCards deckOfCards = null;
        Dealer instance = new Dealer();
        instance.shuffle(deckOfCards);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        ArrayList<Player> players = null;
        Dealer instance = new Dealer();
        String expResult = "";
        String result = instance.declareWinner(players);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
