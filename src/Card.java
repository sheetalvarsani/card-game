public class Card {
    private final Suit suit;
    private final Symbol symbol;
    private final Value value;

    public Card(Suit suit, Symbol symbol, Value value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String toString() {
        return symbol + " " + suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Value getValue() {
        return value;
    }

}