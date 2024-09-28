import java.util.Scanner;

public class Snap extends CardGame {
    private Player player1;
    private Player player2;
    private Card previousCard;

    public Snap(String name, String p1Name, String p2Name) {
        super(name);
        this.previousCard = null;
        this.player1 = new Player(p1Name);
        this.player2 = new Player(p2Name);
    }

    public void playSnap() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            getDeck();
            shuffleDeck();
            previousCard = null;
            Player currentPlayer = player1;

            System.out.println("\nLet's play SNAP! (Press Q to QUIT)");
            System.out.println("\nPress Enter to deal a card. \nPlayer 1 goes first:");

            while (true) {
                String input = scanner.nextLine().toUpperCase();

                if (input.equals("Q")) {
                    System.out.println("\nOK BYE!");
                    System.exit(0);
                }

                Card currentCard = dealCard();
                if (currentCard == null) {
                    System.out.println("\nGAME OVER: No Winner!");
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

            playAgain = showMenu(scanner);
        }
    }

    private boolean showMenu(Scanner scanner) {
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
                    System.out.println("\nThanks for playing SNAP!");
                    return false;
                case "3":
                    System.out.println("\nThanks for playing SNAP! BYE!");
                    System.exit(0);
                default:
                    System.out.print("Enter a valid choice (1 / 2 / 3): ");
            }
        }
    }
}
