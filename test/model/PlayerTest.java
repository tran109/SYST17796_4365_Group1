package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Si Tran
 * @author Inho Choi
 * @author Sugi Oh
 * @author Nathan Morrone
 */
public class PlayerTest {

    public PlayerTest() {
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

    /*This JUnit test is to test that a player is removing 1 card
    from the deck of cards, as it is stated in the rules of go fish
    to remove a single card each time a player "Go-Fishes". In this method
    the player is initalized with 7 cards which has a size length of 7,
    so the expecetd size lenth result of the players card hand should be 8 after
    the player removes a card from the deck of cards
     */
    @Test
    public void testGoFishGood() {
        System.out.println("goFish");
        DeckOfCards deckOfcards = new DeckOfCards();
        Dealer dealer = Dealer.getInstance();
        Player instance = new Player("John", dealer.distributeCards(deckOfcards));
        instance.goFish(deckOfcards);
        int expResult = 8;
        int result = instance.getCurrentCards().size(); // should be 8

        assertEquals(expResult, result);
    }

    /*This JUnit test is to test that a player is removing 1 card
    from the deck of cards but the deck of cards is empty.If the deck is empty 
    a card should not be removed. Since the deck is empty,  the expected
    result will be false" */
    @Test
    public void testGoFishGoodBad() {
        System.out.println("goFish");
        //deck of cards is initalized with 52 cards once the object is created
        DeckOfCards deckOfcards = new DeckOfCards();
        deckOfcards.getCards().clear();
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.goFish(deckOfcards);
        assertEquals(expResult, result);
    }

    /*This JUnit test is to test if the player can go fish from the deck of cards
    when the deck of cards has one card left.In the testing method the deck of 
    cards contains 1 card and should return true" */
    @Test
    public void testGoFishGoodBoundary() {
        System.out.println("goFish");
        //deck of cards is initalized with 52 cards once the object is created
        Dealer dealer = Dealer.getInstance();
        DeckOfCards deckOfcards = new DeckOfCards();
        Player instance = new Player("Nathan",
                dealer.distributeCards(deckOfcards));

        deckOfcards.getCards().clear();
        deckOfcards.getCards().add(new Card(Suit.CLUBS, Rank.JACK));
        boolean expResult = true;
        boolean result = instance.goFish(deckOfcards);
        assertEquals(expResult, result);
    }

    /*This JUnit test is used to check if the player has any cards left
    over, in the main method, if the asking player recieves cards from the 
    opposing player then the the opposing playr will check if they have any cards
    left. In this test method the player is given 7 cards by the dealer, hence
    the player will still have cards left, so the expected result should be
    true*/
    @Test
    public void testHasCardsLeftOverGood() {
        System.out.println("hasCardsLeftOver");
        Dealer dealer = Dealer.getInstance();
        DeckOfCards deckOfCards = new DeckOfCards();
        Player instance = new Player("John", dealer.distributeCards(deckOfCards));
        boolean expResult = true;
        boolean result = instance.hasCardsLeftOver();
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if the player has any cards left in
    their current hand, in this method the player does not contain any cards
    left in their hand, so the expected result is false*/
    @Test
    public void testHasCardsLeftOverBad() {
        System.out.println("hasCardsLeftOver");
        Dealer dealer = Dealer.getInstance();
        DeckOfCards deckOfCards = new DeckOfCards();
        Player instance = new Player("John", dealer.distributeCards(deckOfCards));
        instance.getCurrentCards().clear();
        boolean expResult = false;
        boolean result = instance.hasCardsLeftOver();
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if a player has any cards left in 
    their current hand. In this method the player contains only one card left,
    so the expecetd result is true.*/
    @Test
    public void testHasCardsLeftOverBoundary() {
        System.out.println("hasCardsLeftOver");
        Dealer dealer = Dealer.getInstance();
        DeckOfCards deckOfCards = new DeckOfCards();
        Player instance = new Player("John", dealer.distributeCards(deckOfCards));
        instance.getCurrentCards().clear();
        instance.getCurrentCards().add(new Card(Suit.CLUBS, Rank.JACK));
        boolean expResult = true;
        boolean result = instance.hasCardsLeftOver();
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if the player contains
    a specific card based on a rank. In this testing method the expected result
    is true because there are multiple cards in the players card hand with the 
    same rank */
    @Test
    public void testHasCardsInCurrentHandGood() {
        System.out.println("hasCardsInCurrentHand");
        Rank rank = Rank.ACE;
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(Rank.ACE));
        list.add(new Card(Rank.ACE));
        list.add(new Card(Rank.ACE));
        Player instance = new Player("Nathan", list);
        boolean expResult = true;
        boolean result = instance.hasCardsInCurrentHand(rank);
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if the player contains
    a specific card based on a rank but the "rank" passed as an argument
    does not math any current cards with the corresponsing rank in the players
    card hand.*/
    @Test
    public void testHasCardsInCurrentHandBad() {
        System.out.println("hasCardsInCurrentHand");
        Rank rank = Rank.JACK;
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(Rank.ACE));
        Player instance = new Player("Nathan", list);
        boolean expResult = false;
        boolean result = instance.hasCardsInCurrentHand(rank);
        assertEquals(expResult, result);

    }

    /*This JUnit test method is used to check if the player contains
    1 specific card based on a rank, the expecetd result is true*/
    @Test
    public void testHasCardsInCurrentHandBoundary() {
        System.out.println("hasCardsInCurrentHand");
        Rank rank = Rank.JACK;
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(Rank.ACE));
        Player instance = new Player("Nathan", list);
        boolean expResult = false;
        boolean result = instance.hasCardsInCurrentHand(rank);
        assertEquals(expResult, result);

    }
}
