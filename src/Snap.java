import java.util.Scanner;

public class Snap extends CardGame{

    private Card previousCard;

    public Snap(String name) {
        super(name);
        this.previousCard = null;
    }



    public void playSnap() {
        System.out.println("Let's play Snap! \nPress Enter to deal a card.");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            scanner.nextLine();

            Card currentCard = dealCard();

            if(currentCard == null) {
                System.out.println("\nGAME OVER: Nobody wins!");
                break;
            }

            System.out.println(currentCard);

            if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                System.out.println("\nSNAP!\n\nGAME OVER: PLAYER WINS!");
                break;
            }
            previousCard = currentCard;
        }
        scanner.close();
    }
}
