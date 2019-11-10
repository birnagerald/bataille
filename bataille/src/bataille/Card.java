package bataille;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Card
 */
public class Card {

    // Variables

    private String color;
    private String value;
    public static ArrayList<String> colors = new ArrayList<String>(Arrays.asList(new String[]{"clubs","diamond","hearts","spades"}));
    public static ArrayList<String> values = new ArrayList<String>(Arrays.asList(new String[]{"two","tree","four","five","six","seven","eight","nine","ten","valet","queen","king","as"}));

     // Constructor

     Card() {
        this.color = "";
        this.value = "";
    }

    Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    // Getters 

    public String getCard() {
        return value + " of " + color;
    }

    public String getValue() {
        return this.value;
    }

    public String getColor() {
        return this.color;
    }

 
    /**
     * Define the winner of a round
     * @param opponentCard
     * @return
     */
    public int RoundWinner(Card opponentCard) {
        int value1 = values.indexOf(this.value);
        int value2 = values.indexOf(opponentCard.getValue());
        if (value1 > value2){
            return 1;
        }else{
            if (value1 == value2){
                return 2;
            }else{
                return 0;
            }
        }
    }

    /**
     * Create main deck of the game
     * @return ArrayList<Card>
     */
    public static ArrayList<Card> createMainDeck() {
        ArrayList<Card> mainDeck = new ArrayList<Card>();
        for (String i : Card.colors){
            for (String j : Card.values){
                mainDeck.add(new Card(i, j));
            }
        }
        return mainDeck;
    }

}