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
                    System.out.println("\n" + currentPlayer.getName() + " Type 'SNAP' within 2 seconds to WIN!");

                    Thread timerThread = new Thread(() -> {
                        try {
                            Thread.sleep(2000);
                            System.out.println("\nTIME'S UP!");
                        } catch (InterruptedException e) {
                            System.out.println("\nSNAP DECLARED!");
                        }
                    });

                    timerThread.start();

                    String snapInput = scanner.nextLine().toUpperCase();

                    if (snapInput.equals("SNAP")) {
                        timerThread.interrupt();
                        System.out.println("\nGAME OVER: " + currentPlayer.getName() + " WINS!");
                        currentPlayer.setIsWinner(true);
                        break;
                    } else {
                        try {
                            timerThread.join();
                        } catch (InterruptedException _) {
                        }
                        System.out.println("\nGame continues.");
                        System.out.println("It is " + currentPlayer.getName() + "'s turn.");
                    }
                }

                previousCard = currentCard;
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            playAgain = showMenu(scanner);
        }
    }
}
