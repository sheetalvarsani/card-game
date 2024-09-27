import java.util.Scanner;

public class Snap extends CardGame{
    public Snap(String name) {
        super(name);
    }

    private final Card previousCard = null;

    public void playSnap() {
        System.out.println("Let's play Snap! \nPress Enter to deal a card.");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            scanner.nextLine();

            Card currentCard = dealCard();

            if(currentCard == null) {
                System.out.println("Game Over!");
                break;
            }

            System.out.println(currentCard);

            if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                System.out.println("SNAP!");
                break;
            }
        }
        scanner.close();
    }
}
