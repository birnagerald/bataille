package bataille;

import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // Create two players
        Player player1 = new Player();
        Player player2 = new Player();

        // Create main deck
        ArrayList<Card> mainDeck = Card.createMainDeck();

        // and shuffle it
        Collections.shuffle(mainDeck);

        // Give cards to player to have two separates decks
        Player.createPlayersDeck(mainDeck, player1, player2);

        // Start playing : for each cards of players deck
        int numberOfDraw = Player.play(player1, player2);

        // Display result
        Player.gameResult(player1, player2, numberOfDraw);
    }
}