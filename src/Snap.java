import java.util.Scanner;

public class Snap extends CardGame{
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Card previousCard;

    public Snap(String name, String player1Name, String player2Name) {
        super(name);
        this.previousCard = null;
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.currentPlayer = player1;
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

            System.out.println(currentPlayer.getName() + ": " + currentCard);

            if (previousCard != null && currentCard.getSymbol().equals(previousCard.getSymbol())) {
                System.out.println("\nSNAP!\n\nGAME OVER: " + currentPlayer.getName() + " WINS!");
                currentPlayer.setIsWinner(true);
                break;
            }

            previousCard = currentCard;

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
        scanner.close();
    }
}
