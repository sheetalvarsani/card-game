import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private final ArrayList<Card> deckOfCards; // populated when game is constructed
    private final String name; // Name of card game - also defined in constructor

    // Constructor
    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        getDeck(); // lists cards in deck
    }

    private void getDeck() {
        for (String suit : Card.getSuits()) { // get suits through the getter
            for (int i = 0; i < Card.getSymbols().length; i++) { // get symbols through the getter
                deckOfCards.add(new Card(suit, Card.getSymbols()[i], Card.getValues()[i])); // Add card to deck
            }
        }
    }

    // Display the deck of cards
    public void displayDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    // Get name of the card game
    public String getName() {
        return name;
    }

    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            System.out.println("No cards left in the deck!");
            return null; // Return null if the deck is empty
        }
        return deckOfCards.removeFirst(); // Remove and return the top card
    }

    public void sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(Card::getValue));
    }
}