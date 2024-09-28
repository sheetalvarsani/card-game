import java.util.Scanner;

public class HigherLower extends CardGame {
    private Card previousCard;

    public HigherLower(String name) {
        super(name);
        this.previousCard = null;
    }

    public void playHigherLower() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            getDeck();
            shuffleDeck();
            previousCard = dealCard();
            int score = 0;

            System.out.println("\nIn this game, you must guess whether the next card dealt will be HIGHER or LOWER than the previous...");
            System.out.println("\nLet's play Higher Lower! (Press Q to QUIT)");
            System.out.println("\nThe card is: " + previousCard);

            while (true) {
                System.out.print("Enter 'H' for HIGHER, 'L' for LOWER: ");
                String guess = scanner.nextLine().toUpperCase();

                if (guess.equals("Q")) {
                    System.out.println("\nOK BYE!");
                    System.exit(0);
                }

                if (!guess.equals("H") && !guess.equals("L")) {
                    System.out.println("Please enter 'H' for HIGHER, 'L' for LOWER:");
                    continue;
                }

                Card currentCard = dealCard();
                if (currentCard == null) {
                    System.out.println("\nGAME OVER! YOU ARE THE ULTIMATE CHAMPION!");
                    break;
                }

                System.out.println("\nThe card is: " + currentCard);


                if (currentCard.getValue().compareTo(previousCard.getValue()) == 0) {
                    System.out.println("\nDRAW! The card values are the same. Let's continue...");
                    previousCard = currentCard;
                    continue;
                }

                boolean isCorrect = (guess.equals("H") && currentCard.getValue().compareTo(previousCard.getValue()) > 0) ||
                        (guess.equals("L") && currentCard.getValue().compareTo(previousCard.getValue()) < 0);

                if (isCorrect) {
                    System.out.println("\nCORRECT!");
                    previousCard = currentCard;
                    score++;
                } else {
                    System.out.println("\nINCORRECT: GAME OVER!");
                    break;
                }
            }

            System.out.println("YOUR SCORE: " + score);

            playAgain = showMenu(scanner);
        }
    }
}