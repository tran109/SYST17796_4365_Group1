/*
* Name:  [your name here]
* Assignment:  [assignment name]
* Program: [your program name here]
* Date:  [assignment due date here]
    
* Description:
* [program description in your own words]
 */
package gofish;

import java.util.ArrayList;
import java.util.Scanner;
import model.Card;
import model.Dealer;
import model.DeckOfCards;
import model.GoFish;
import model.Player;
import model.Rank;
import model.Suit;

/**
 *
 * @author nathan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Dealer dealer = new Dealer();
        DeckOfCards deckOfCards = new DeckOfCards();

        System.out.printf("WELCOME TO GO FISH%n%n");

        //shuffle and distrube cards
        dealer.shuffle(deckOfCards);
        Player player1 = new Player(getInput(input, "Enter player 1's name: "),
                dealer.distributeCards(deckOfCards));


        Player player2 = new Player(getInput(input, "Enter player 2's name: "),
                dealer.distributeCards(deckOfCards));

        System.out.printf("%nRULES OF GO FISH%n--------------------%n"
                + "1. Each player has been dealt 7 cards at random....%n"
                + "2. Player 1 wil start, followed by player 2%n"
                + "3. Each players turn will be STATED at the top of a header%n"
                + "4. Players will ask opposing players for cards based on a rank"
                + " and suit combination%n%n"
                + "IMPORTANT NOTE: Prompts will be available specifying when "
                + "to type in a rank or suit%n%n"
                + "5. An opposing player must give up any number of cards to the "
                + "asking player based%n on a rank a suit%n"
                + "6. If player 1 asks player 2 for their cards, but player 2 does "
                + "not have any card%n matches, then player 1 must \"Go Fish\"%n"
                + "7. If the deck is empty the dealer will declare a "
                + "winner based on the player%n with highest amount of remaining "
                + "card matches, if one player runs out of cards the%n opposing player"
                + " will win the game%n%n");

        int num = 1;
        while (deckOfCards.size() != 0) {

            System.out.println("-----------------------ROUND " + num + "----------------------------");
            //Player 1 
            System.out.printf("Player 1%n--------%n");
            System.out.println(player1.toString());
            Rank rank = Rank.valueOf(getInput(input, "Card Rank: ").toUpperCase());
            Suit suit = Suit.valueOf(getInput(input, "Suit: ").toUpperCase());

            if (player2.hasCardsInCurrentHand(rank)) {
                System.out.printf("THERES A MATCH, player 1 recieves cards%n");

                
                
                
                //loop through player 2's cards and remove the cards that match and place them in player 1's carx hand
                for (int i = 0; i < player2.getCurrentCards().size(); i++) {
                    if (player2.getCurrentCards().get(i).getRank().equals(rank)) {

                       
                        player1.getCurrentCards().add(player2.getCurrentCards().remove(i));
                    }
                       
                }

            } else {
                System.out.printf("PLAYER 1 GO FISH%n%n");
                player1.goFish(deckOfCards);
            }

            
            
            
            //Player 2
            System.out.printf("Player 2%n--------%n");
            System.out.println(player2.toString());
            Rank rank2 = Rank.valueOf(getInput(input, "Card Rank: "));
            Suit suit2 = Suit.valueOf(getInput(input, "Card Suit: ").toUpperCase());

            if (player1.hasCardsInCurrentHand(rank2)) {
                System.out.printf("THERES A MATCH, player 2 recieves cards%n");

                for (int i = 0; i < player1.getCurrentCards().size(); i++) {
                    if (player1.getCurrentCards().get(i).getRank().equals(rank2)) {

                    
                        player2.getCurrentCards().add(player1.getCurrentCards().remove(i));
                    }
                    
            

                }

            } else {
                System.out.printf("PLAYER 2 GO FISH%n");
                player2.goFish(deckOfCards);
            }

            
            
            
            
            
            
            
            if (deckOfCards.getCards().isEmpty()) {

                System.out.println("Deck of cards is empty");
                break;

            } else {
                System.out.println();
                System.out.println();
                ++num;
            }

        }
    }

    private static String getInput(Scanner input, String prompt) {

        System.out.print(prompt);
        String value = input.nextLine().toUpperCase().trim();
        return value;

    }

}
