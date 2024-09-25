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
    }
}