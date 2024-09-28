import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private final ArrayList<Card> deckOfCards;
    private final String name;

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        getDeck();
    }

    void getDeck() {
        for (Suit suit : Suit.values()) {
            for (Symbol symbol : Symbol.values()) {
                Value value = Value.valueOf(symbol.name());
                deckOfCards.add(new Card(suit, symbol, value));
            }
        }
    }

    public String getName() {
        return name;
    }

    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            System.out.println("No cards left in the deck!");
            return null;
        }
        return deckOfCards.removeFirst();
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