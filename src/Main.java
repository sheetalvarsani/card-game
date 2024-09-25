public class Main {
    public static void main(String[] args) {

        CardGame game = new CardGame("Snap");

        System.out.println("Deck of Cards:");
        game.displayDeck();

        // Deal a card
        System.out.println("\nDealing the top card:");
        Card dealtCard = game.dealCard();
        if (dealtCard != null) {
            System.out.println("Dealt card: " + dealtCard);
        }

        // Display the deck after dealing one card
        System.out.println("\nDeck of Cards after dealing one card:");
        game.displayDeck();

        game.sortDeckInNumberOrder();

        // Display the sorted deck
        System.out.println("\nSorted Deck by Number Order:");
        game.displayDeck();

        game.sortDeckIntoSuits();

        // Display the sorted deck
        System.out.println("\nSorted Deck Into Suits:");
        game.displayDeck();

        game.shuffleDeck();

        // Display the sorted deck
        System.out.println("\nShuffled deck:");
        game.displayDeck();
    }
}