import java.util.Scanner;

public class Snap extends CardGame{
    public Snap(String name) {
        super(name);
    }

    public void playSnap() {
        System.out.println("Let's play Snap! Press Enter to deal a card.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Wait for user to press enter to deal the next card
            scanner.nextLine();

            Card currentCard = dealCard();

            System.out.println("Dealt card: " + currentCard);
        }
    }
}
