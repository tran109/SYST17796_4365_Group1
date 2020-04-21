/*
 * [Go_FishApplication]
 *
 * Description:
 * This class contains the client code, and is where the application will
 * be executed. 
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Card;
import model.Dealer;
import model.DeckOfCards;
import model.Player;
import model.Rank;

/**
 *
 * @author Nathan Morrone
 * @author Inho Choi
 * @author Sugi Oh
 * @author Si Tran
 */
public class GoFish_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Dealer dealer = Dealer.getInstance();
        DeckOfCards deckOfCards = new DeckOfCards();

        System.out.printf("WELCOME TO GO FISH%n%n");

        dealer.shuffle(deckOfCards);//1.SHUFFLE CARDS

        System.out.printf("%nRULES OF \"GO FISH\"%n--------------------%n"
                + "1. Each player has been dealt 7 cards at random....%n"
                + "2. Player 1 wil start, followed by player 2%n"
                + "3. Each players turn will be STATED at the top of a header"
                + "(\"PLAYER 1's TURN\")%n"
                + "4. Players will ask opposing players for cards based on a rank"
                + "%n%n"
                + "IMPORTANT NOTE: Prompts will be available specifying when "
                + "to type in a rank of the opposing players card hand%n%n"
                + "5. An opposing player must give up any number of cards to the "
                + "asking player based%n on a rank%n"
                + "6. If player 1 asks player 2 for their cards, but "
                + "player 2 does "
                + "not have any card%n matches, then player 1 must \"go fish\""
                + "and will take a single card from the%n pile of cards%n"
                + "7. If the deck is empty the dealer will declare a "
                + "winner based on the player%n with highest amount of remaining "
                + "amount of cards based on rank, but if one player%n runs out "
                + "of cards the opposing player"
                + " will win the game%n%n");

        Player player1 = new Player(getInput(input, "Enter player 1's name: "),
                dealer.distributeCards(deckOfCards));

        Player player2 = new Player(getInput(input, "Enter player 2's name: "),
                dealer.distributeCards(deckOfCards));

        int num = 1;
        while (!deckOfCards.getCards().isEmpty()) {

            System.out.println("-----------------------ROUND " + num + "--------"
                    + "--------------------");

            System.out.printf("PLAYER 1's TURN%n---------------%n");
            System.out.println(player1.toString());
            System.out.printf("\nRank types: ace,two,three,four,five,six,"
                    + "seven,eight,nine,ten,jack,queen,king\n");

            String userInput = getInput(input, "Enter a rank: ");

            while (!userInput.toUpperCase().matches("ACE|TWO|THREE|FOUR"
                    + "|FIVE|SIX|SEVEN|EIGHT|NINE|TEN|JACK|QUEEN|KING")) {

                System.out.println("INVALID RANK, please try again...");
                userInput = getInput(input, "Enter a rank: ");
            }

            Rank rank = Rank.valueOf(userInput);

            //Check if the opposing player has any cards based on a rank
            if (player2.hasCardsInCurrentHand(rank)) {
                System.out.printf("%nTHERES A MATCH, player"
                        + " 1 recieves cards%n");

                ArrayList<Card> list1 = new ArrayList<Card>();

                player1.getOpposingPlayerCards(player1, player2, rank, list1);

                player2.getCurrentCards().removeAll(list1);

            } else {
                System.out.printf("%nPLAYER 1 GO FISH%n");
                player1.goFish(deckOfCards);//5. GO FISH PLAYER(A or B)
            }

            /*If player 1 takes cards from player 2 we want to check if player 2
            still has any cards left. If player 2 doesnt have any cards left 
            player 1 wins*/
            if (!player2.hasCardsLeftOver()) {
                toStringWinner(player1);
                break;
            }

            System.out.printf("-------------------------------%n");
            System.out.printf("PLAYER 2's TURN %n---------------%n");
            System.out.println(player2.toString());
            System.out.printf("%nRank types: ace,two,three,four,five,six,"
                    + "seven,eight,nine,ten,jack,queen,king%n");

            String userInput2 = getInput(input, "Enter a rank: ");

            while (!userInput2.toUpperCase().matches("ACE|TWO|THREE|FOUR"
                    + "|FIVE|SIX|SEVEN|EIGHT|NINE|TEN|JACK|QUEEN|KING")) {

                System.out.println("INVALID RANK, please try again...");
                userInput2 = getInput(input, "Enter a rank: ");
            }

            Rank rank2 = Rank.valueOf(userInput2);

            //Check if the opposing player has any cards based on a rank
            if (player1.hasCardsInCurrentHand(rank2)) {
                System.out.printf("%nTHERES A MATCH, player 2 recieves cards");

                ArrayList<Card> list2 = new ArrayList<Card>();

                player2.getOpposingPlayerCards(player2, player1, rank2, list2);

                player1.getCurrentCards().removeAll(list2);

            } else {
                System.out.printf("%nPLAYER 2 GO FISH%n");
                player2.goFish(deckOfCards);
            }

            if (dealer.isDeckEmpty(deckOfCards)) {

                System.out.printf("%n------------------------------END OF GAME--"
                        + "---------------------------------------%n"
                        + "The deck of cards is empty.....%n%n"
                        + "Winner:  %s", dealer.declareWinner(player1, player2));
                break;

                /*If player 2 takes cards from player 1 we want to check if 
                player 2 still has any cards left. If player 1 doesnt have any 
                cards left player 2 wins*/
            } else if (!player1.hasCardsLeftOver()) {
                toStringWinner(player2);
                break;
            } else {

                System.out.println();
                System.out.println();
                ++num;
            }
        }
    }

    //helper method to return user input from the command line
    private static String getInput(Scanner input, String prompt) {

        System.out.print(prompt);
        String value = input.nextLine().toUpperCase().trim();
        return value;

    }

    //helper method to display a winner to the console
    private static void toStringWinner(Player player) {
        System.out.printf("%n------------------------------END OF GAME----------"
                + "------------------------------%n"
                + "Player has ran out of cards.....%n%n"
                + "Winner:  %s%n", player.getName());

    }

}
