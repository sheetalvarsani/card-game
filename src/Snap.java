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

            System.out.println("\nLet's play SNAP! \n\nPress Enter to deal a card. \nPlayer 1 goes first:");

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

            System.out.println("\nChoose what to do next:");
            System.out.println("1. Play Again");
            System.out.println("2. Back to Main Menu"); // change to choose another game when additional game added
            System.out.println("3. EXIT");
            System.out.print("\nEnter your choice: ");

            while (true) {
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    playAgain = true;
                    break;
                } else if (choice.equals("2")) {
                    playAgain = false;
                    System.out.println("\nThanks for playing SNAP!");
                    break;
                } else if (choice.equals("3")) {
                    playAgain = false;
                    System.out.println("\nThanks for playing SNAP! BYE!");
                    System.exit(0);
                } else {
                    System.out.println("\nPlease enter '1' to PLAY AGAIN, '2' to go BACK TO MAIN MENU or '3' to EXIT:");
                }
            }
        }
    }
}
