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
public class GoFish_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Dealer dealer = new Dealer();
        DeckOfCards deckOfCards = new DeckOfCards();
        ArrayList<Player> playerList = new ArrayList<Player>();

        System.out.printf("WELCOME TO GO FISH%n%n");

        //shuffle and distrube cards
        dealer.shuffle(deckOfCards);
        playerList.add(new Player(getInput(input, "Enter player 1's name: "),
                dealer.distributeCards(deckOfCards)));

        //shuffle and distribute cards
        dealer.shuffle(deckOfCards);
        playerList.add(new Player(getInput(input, "Enter player 2's name: "),
                dealer.distributeCards(deckOfCards)));

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
            System.out.println(playerList.get(0).toString());
            Rank rank = Rank.valueOf(getInput(input, "Card Rank: ").toUpperCase());


            Player player1 = playerList.get(0);
            Player player2 = playerList.get(1);


            ArrayList<Card> player1Cards = player1.getCurrentCards();
            ArrayList<Card> player2Cards = player2.getCurrentCards();


            if (player1.hasCardsInCurrentHand(rank)) {


                //loop through player 2's cards and remove the cards that match and place them in player 1's carx hand
                for (int i = 0; i < player1Cards.size(); i++) {
                    if (player1Cards.get(i).getRank() ==  rank) {
                        System.out.printf("THERES A MATCH, player 2 recieves cards%n");

                        player2Cards.add(player1Cards.get(i));
                        player1Cards.remove(i);

                        System.out.println(player2.toString());
                        System.out.println(player1.toString());

                    }
                }

            } else {
                System.out.printf("PLAYER 1 GO FISH%n%n");
                player2.goFish(deckOfCards);
                System.out.println(player1.toString());
                System.out.println(player2.toString());
            }

            
            
            
            
            //Player 2
            System.out.printf("Player 2%n--------%n");
            System.out.println(playerList.get(1).toString());
            rank = Rank.valueOf(getInput(input, "Card Rank: "));


            if (playerList.get(0).hasCardsInCurrentHand(rank)) {
                System.out.printf("THERES A MATCH, player 2 recieves cards%n");

                for (int i = 0; i < playerList.get(0).getCurrentCards().size(); i++) {
                    if (playerList.get(0).getCurrentCards().get(i).getRank().equals(rank)) {

                        playerList.get(1).getCurrentCards().add(playerList.get(0).getCurrentCards().remove(i));
                    }

                }

            } else {
                System.out.printf("PLAYER 2 GO FISH%n");
                playerList.get(1).goFish(deckOfCards);
            }

            
            
            
            
            if (deckOfCards.getCards().isEmpty()) {

                dealer.declareWinner(playerList);
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
//            for (int i = 0; i < playerList.get(1).getCurrentCards().size(); i++) {
//                if (playerList.get(0).hasCardsInCurrentHand(new Card(suit, rank))) {
//                    playerList.get(0).getCurrentCards().remove(i);
//                    playerList.get(1).getCurrentCards().add(new Card(suit, rank));
//                }
//            }
