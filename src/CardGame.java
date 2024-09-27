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

    void getDeck() {
        for (Suit suit : Suit.values()) {
            for (Symbol symbol : Symbol.values()) {
                Value value = Value.valueOf(symbol.name());
                deckOfCards.add(new Card(suit, symbol, value));
            }
        }
    }

//    public void displayDeck() {
//        for (Card card : deckOfCards) {
//            System.out.println(card);
//        }
//    }

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

    public void sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit));
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }
}