package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Inho Choi
 * @author Nathan Morrone
 * @author Sugi Oh
 * @author Si Tran
 */
public class DealerTest {

    public DealerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("In setUpClass");
    }

    @AfterClass
    public static void tearDownClass() {
          System.out.println("In tearDownClass");
    }

    @Before
    public void setUp() {
         System.out.println("In setUp");
    }

    @After
    public void tearDown() {
        System.out.println("In tearDown");
    }

    /*A JUnit test method to make sure that 7 cards have been distrubted 
    to the player*/
    @Test
    public void testDistributeCardsGood() {
        System.out.println("distributeCards");
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer instance = Dealer.getInstance();
        Player player = new Player("John", instance.distributeCards(deckOfCards));
        boolean expResult = true;
        boolean result = player.getCurrentCards().size() == 7;
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to make sure that the dealer
    doesnt distribute more than 7 cards to the player*/
    @Test
    public void testDistributeCardsBad() {
        System.out.println("distributeCards");
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer instance = Dealer.getInstance();
        Player player = new Player("John", instance.distributeCards(deckOfCards));
        boolean expResult = false;
        boolean result = player.getCurrentCards().size() == 8;
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to make sure that no less than 8 cards
    have been distributed and no more than 6 cards have been distributed to
    the player*/
    @Test
    public void testDistributeCardsBoundary() {
        System.out.println("distributeCards");
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer instance = Dealer.getInstance();
        Player player = new Player("John", instance.distributeCards(deckOfCards));
        boolean expResult = true;
        boolean result = player.getCurrentCards().size() < 8
                && player.getCurrentCards().size() > 6;
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if the deck is empty*/
    @Test
    public void testIsDeckEmptyGood() {
        System.out.println("isDeckEmpty");
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer instance = Dealer.getInstance();
        boolean expResult = true;
        deckOfCards.getCards().clear();
        boolean result = instance.isDeckEmpty(deckOfCards);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /*This JUnit test method is used to check if the deck is not empty*/
    @Test
    public void testIsDeckEmptyBad() {
        System.out.println("isDeckEmpty");
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer instance = Dealer.getInstance();
        boolean expResult = false;
        boolean result = instance.isDeckEmpty(deckOfCards);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /*This JUnit test method is used to check if the deck is near to being empty
    but still contains 1 card within the the deck*/
    @Test
    public void testIsDeckEmptyBoundary() {
        System.out.println("isDeckEmpty");
        DeckOfCards deckOfCards = new DeckOfCards();
        Dealer instance = Dealer.getInstance();
        deckOfCards.getCards().clear();
        deckOfCards.getCards().add(new Card(Rank.JACK));
        boolean expResult = true;
        boolean result = !instance.isDeckEmpty(deckOfCards);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }


    /*This JUnit test method is used to check if the winner is correctly decided
    based on the number of sets in the current card hand of the player. A set
    is made of up 4 cards that share the SAME rank*/
    @Test
    public void testDeclareWinnerGood() {
        System.out.println("declareWinner");
        ArrayList<Card> list1 = new ArrayList<Card>();
        ArrayList<Card> list2 = new ArrayList<Card>();
        list1.add(new Card(Suit.CLUBS, Rank.JACK));
        list1.add(new Card(Suit.DIAMONDS, Rank.JACK));
        list1.add(new Card(Suit.SPADES, Rank.JACK));
        list1.add(new Card(Suit.HEARTS, Rank.JACK));

        list2.add(new Card(Suit.CLUBS, Rank.JACK));
        list2.add(new Card(Suit.DIAMONDS, Rank.KING));
        list2.add(new Card(Suit.SPADES, Rank.QUEEN));
        list2.add(new Card(Suit.HEARTS, Rank.TEN));

        Player player1 = new Player("John", list1);
        Player player2 = new Player("Jane", list2);

        Dealer instance = Dealer.getInstance();
        String expResult = "John";
        String result = instance.declareWinner(player1, player2);
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if the number of cards in a players
    current cardhand makes up a set. In this case player 2 is short 1 card of a 
    having a set*/
    @Test
    public void testDeclareWinnerBad() {
        System.out.println("declareWinner");
        ArrayList<Card> list1 = new ArrayList<Card>();
        ArrayList<Card> list2 = new ArrayList<Card>();
        list1.add(new Card(Suit.CLUBS, Rank.JACK));
        list1.add(new Card(Suit.DIAMONDS, Rank.JACK));
        list1.add(new Card(Suit.SPADES, Rank.JACK));
        list1.add(new Card(Suit.HEARTS, Rank.JACK));

        list2.add(new Card(Suit.CLUBS, Rank.JACK));
        list2.add(new Card(Suit.DIAMONDS, Rank.JACK));
        list2.add(new Card(Suit.SPADES, Rank.JACK));

        Player player1 = new Player("John", list1);
        Player player2 = new Player("Jane", list2);

        Dealer instance = Dealer.getInstance();
        String expResult = "John";
        String result = instance.declareWinner(player1, player2);
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if each player contains the 
    same number of sets. If each player has the same number of sets the game is
    declared a draw*/
    @Test
    public void testDeclareWinnerBoundary() {
        System.out.println("declareWinner");
        ArrayList<Card> list1 = new ArrayList<Card>();
        ArrayList<Card> list2 = new ArrayList<Card>();
        list1.add(new Card(Suit.CLUBS, Rank.JACK));
        list1.add(new Card(Suit.DIAMONDS, Rank.JACK));
        list1.add(new Card(Suit.SPADES, Rank.JACK));
        list1.add(new Card(Suit.HEARTS, Rank.JACK));

        list2.add(new Card(Suit.CLUBS, Rank.JACK));
        list2.add(new Card(Suit.DIAMONDS, Rank.JACK));
        list2.add(new Card(Suit.SPADES, Rank.JACK));
        list2.add(new Card(Suit.HEARTS, Rank.JACK));

        Player player1 = new Player("John", list1);
        Player player2 = new Player("Jane", list2);

        Dealer instance = Dealer.getInstance();
        String expResult = "NO WINNER DRAW";
        String result = instance.declareWinner(player1, player2);
        assertEquals(expResult, result);

    }
}
