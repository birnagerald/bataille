package bataille;

import java.util.*;

/**
 * Player
 */
public class Player {

    // Variables

    private ArrayList<Card> deck;
    private int points;

    // Constructor

    Player() {
        this.deck = new ArrayList<Card>();
        this.points = 0;
    }

    Player(ArrayList<Card> deck, int points) {
        this.deck = deck;
        this.points = points;
    }

    // Getters

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public int getPoints() {
        return this.points;
    }

    /**
     * Add a card to a deck
     * @param card
     */
    public void addCard(Card card) {
        this.deck.add(card);
    }

    /**
     * Pick a card during a round
     * @return Card | null
     */
    public Card pickACard() {
        if (this.deck.size() > 0){
            Card card = this.deck.get(deck.size() - 1);
            this.deck.remove(deck.size() - 1);
            return card;
        }else{
            System.out.println("No more cards.");
            return null;
        }
    }

    /**
     * Actions if the player won the round
     * @param card1
     * @param card2
     */
    public void winRound(Card card1, Card card2) {
        this.deck.add(0, card1);
        this.deck.add(0, card2);
        this.points += 2;
    }

    /**
     * Create players deck
     * @param mainDeck
     * @param player1
     * @param player2
     */
    public static void createPlayersDeck(ArrayList<Card> mainDeck, Player player1, Player player2) {
    	
    	for (Card i : mainDeck) {
    		if ((mainDeck.indexOf(i) % 2) == 0) {
    			player1.addCard(i);
    		}else {
    			player2.addCard(i);
    		}
    	}
    	
    }

   /**
    * Playing the game
    * @param player1
    * @param player2
    * @return drawRoundCount
    */
    public static int play(Player player1, Player player2) {
        // Number of draw
        int drawRoundCount = 0;

        while (true) {

            // Stop playing if one of the two players has no more cards
            if (player1.getDeck().size() == 0 || player2.getDeck().size() == 0){
               return drawRoundCount;
            }

            // Each player pick a card
            Card player1Card = player1.pickACard();
            Card player2Card = player2.pickACard();
            
            // We can uncomment those to see each rounds
            //System.out.println("1 : " + player1Card.getColor() + " " + player1Card.getValue());
            //System.out.println("2 : " + player2Card.getColor() + " " + player2Card.getValue());
            //System.out.println("=================");
            
            // We compare both cards
            int cardCompare = player1Card.RoundWinner(player2Card);

            // Give points to the winner of the round
            // We can uncomment those to check if the code works correctly
            if (cardCompare == 1) {
                player1.winRound(player1Card, player2Card);
               // System.out.println("Player 1 won the round");
            }else if (cardCompare == 0) {
                player2.winRound(player1Card, player2Card);
                //System.out.println("Player 2 won the round");
            }else{
                // If the duel is even we put back both cards under their deck
                player1.getDeck().add(0, player1Card);
                player2.getDeck().add(0, player2Card);
                // System.out.println("Draw!");
                drawRoundCount++;
            }

            // There is a chance that the same "draw combo" got picked everytime
            // there will be an infinite loop to avoid that let's just implement a point system     
            if (player1.getPoints() > 1000 || player2.getPoints() > 1000){
                return drawRoundCount;
            }
        }
    }

    /**
     * Display game result
     * @param player1
     * @param player2
     * @param numberOfDraw
     */
    public static void gameResult(Player player1, Player player2, int numberOfDraw) {
        // Display number of cards within each decks
        System.out.println("Deck 1 : " + player1.getDeck().size() + " cards");
        System.out.println("Deck 2 : " + player2.getDeck().size() + " cards");

        // Display points
        System.out.println("Player 1 : " + player1.getPoints() + " points");
        System.out.println("Player 2 : " + player2.getPoints() + " points");
        System.out.println("Number of draw : " + numberOfDraw);

        // Display winner
        String winner;
        if (player1.getPoints() > player2.getPoints()) {
            winner = "player1";
        }else if (player1.getPoints() == player2.getPoints()) {
            winner = " draw !";
        }else{
            winner = "player2";
        }
        System.out.println("Winner is : " + winner);
    }
}