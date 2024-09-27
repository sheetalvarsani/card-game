public class Card {
    private final String suit;
    private final String symbol;
    private final int value;

    private static final String[] SUITS = {"\u2665", "\u2666", "\u2663", "\u2660"};
    private static final String[] SYMBOLS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        public Card(String suit, String symbol, int value) {
            this.suit = suit;
            this.symbol = symbol;
            this.value = value;
        }

    public String toString() {
        return symbol + " " + suit;
    }

    public static String[] getSuits() {
        return SUITS;
    }

    public String getSuit() {
        return suit;
    }

    public static String[] getSymbols() {
        return SYMBOLS;
    }

    public static int[] getValues() {
        return VALUES;
    }

    public int getValue() {
        return value;
    }


}
