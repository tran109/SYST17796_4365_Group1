/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package gofish;

import java.util.ArrayList;

//Aggregating class --> This class is made up of a Dealer, DeckOfCards, and Players
public abstract class Go_Fish {

    /*For our application we established an few type relationships but the core 
    relationship we estabished is an aggregation relationship between classes for 
    a few class design purposes. Each of our aggregated objects can exist on its own without
    aggregating class exisiting itself. We designed the "GoFish" class so that each of our aggregated objects make up the propertys 
    of a "GoFish" type object and are needed as a whole to create the aggregating object.
    All of the classes we have defined, interact with one another in
    some way which trigger the responsive behaviour of the aggregating class,
    and the aggregated classes, this also gave us an understanding that our overall
    project design would heavily depend on an aggregation model to define our class
    relationships. By implementing the  OOP concept of loose coupling our classes dont depend on other classes to behave the way they 
    are suppose to, they promote single responsiblity and can intermingle with other classes without dependencies.
    
    
    With our game we noticed we needed a secondary actor which would help complete
    the primary actor(s) path and declare the winner of the "GoFish" game  between 
    the players. We thought about delegating the responsilbity to the "Go_Fish" 
    class but by delegating the responsibilty to the "Dealer" class it makes sense from a  
    design perspective to assign this task to the "Dealer" class since in our card 
    game we will already be assigning dealer the responsibilty of checking if the 
    "DeckOfCards" is empty, and if the "DeckOfCards" is empty then the winner is declared.
  
     */
    private final String gameName;//the title of the game
    ArrayList<Player> players;//Aggregated class -> the Go-Fish game needs players to work, so the players are part of the game. Players can exist in other games so its an aggregation
    Dealer dealer; //Aggregated class --> the Go-Fish game needs a dealer for it work, so the dealer in part of the game even though it could be an association. remember that aggregation is a form of association.
    DeckOfCards deckOfCards; //Aggregated class --> the Go-Fish game needs a deck of cards but the deck of cards can exist without the game Go-Fish existing

    public Go_Fish() {
        this.gameName = "Go Fish";
        //Aggregated classes/objects
        players = new ArrayList<Player>();
        dealer = new Dealer();
        deckOfCards = new DeckOfCards();

    }

    public String getGameName() {
        return gameName;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
