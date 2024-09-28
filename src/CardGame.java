import enums.Suit;
import enums.Symbol;
import enums.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public abstract class CardGame {
    private final ArrayList<Card> deckOfCards;
    private final String name;

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        getDeck();
    }

    protected boolean showMenu(Scanner scanner) {
        System.out.println("\nChoose what to do next:");
        System.out.println("1. Play Again");
        System.out.println("2. Choose Another Game");
        System.out.println("3. EXIT");
        System.out.print("\nEnter your choice: ");

        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return true;
                case "2":
                    System.out.println("\nThanks for playing!");
                    return false;
                case "3":
                    System.out.println("\nThanks for playing! BYE!");
                    System.exit(0);
                    return false;
                default:
                    System.out.print("Please enter '1', '2', or '3': ");
            }
        }
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