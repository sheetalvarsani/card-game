package enums;

public enum Suit {
    HEARTS("\u2665"),
    DIAMONDS("\u2666"),
    CLUBS("\u2663"),
    SPADES("\u2660");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}