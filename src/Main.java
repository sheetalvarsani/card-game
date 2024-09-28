import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("\nWelcome to Card Game! Choose a GAME below:");
            System.out.println("1. Play SNAP");
            System.out.println("2. Play HIGHER LOWER");
            System.out.println("3. EXIT");
            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Snap snapGame = new Snap("Snap", "Player 1", "Player 2");
                    snapGame.playSnap();
                    break;

                case "2":
                    HigherLower higherLowerGame = new HigherLower("Higher Lower");
                    higherLowerGame.playHigherLower();
                    break;

                case "3":
                    System.out.println("\nThanks for playing! Goodbye!");
                    gameRunning = false;
                    break;

                default:
                    System.out.println("Please enter '1' to play SNAP, '2' to play HIGHER LOWER or '3' to EXIT.");
                    break;
            }
        }
        scanner.close();
    }
}
