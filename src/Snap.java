import java.util.Scanner;

public class Snap extends CardGame {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Card previousCard;

    public Snap(String name, String p1Name, String p2Name) {
        super(name);
        this.previousCard = null;
        this.player1 = new Player(p1Name);
        this.player2 = new Player(p2Name);
        this.currentPlayer = player1;
    }

    public void playSnap() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            shuffleDeck();
            previousCard = null;
            currentPlayer = player1;

            System.out.println("Let's play SNAP! \nPress Enter to deal a card.");

            while (true) {
                scanner.nextLine();

                Card currentCard = dealCard();

                if (currentCard == null) {
                    System.out.println("\nGAME OVER: Nobody wins!");
                    break;
                }

                System.out.println(currentPlayer.getName() + ": " + currentCard);

                if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                    System.out.println("\nSNAP!\n\nGAME OVER: " + currentPlayer.getName() + " WINS!");
                    currentPlayer.setIsWinner(true);
                    break;
                }

                previousCard = currentCard;
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            System.out.println("\nEnter '1' to PLAY AGAIN or '2' to EXIT:");

            while (true) {
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    playAgain = true;
                    break;
                } else if (choice.equals("2")) {
                    playAgain = false;
                    System.out.println("Thanks for playing! BYE!");
                    break;
                } else {
                    System.out.println("Please enter '1' to PLAY AGAIN or '2' to EXIT:");
                }
            }
        }
        scanner.close();
    }
}
