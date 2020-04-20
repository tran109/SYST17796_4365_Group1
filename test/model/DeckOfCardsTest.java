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
public class DeckOfCardsTest {
    
    public DeckOfCardsTest() {
    }


    @Test
    public void testSize() {
        System.out.println("size");
        DeckOfCards instance = new DeckOfCards();
        int expResult = 7;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    
}
