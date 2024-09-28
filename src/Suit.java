public enum Suit {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}