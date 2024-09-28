import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            displayMenu();
            String choice = scanner.nextLine();
            gameRunning = handleChoice(choice);
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nWelcome to Card Game! Choose a GAME below:\n");
        System.out.println("1. Play: SNAP");
        System.out.println("2. Play: HIGHER LOWER");
        System.out.println("3. EXIT");
        System.out.print("\nEnter your choice: ");
    }

    private static boolean handleChoice(String choice) {
        return switch (choice) {
            case "1" -> {
                new Snap("Snap", "Player 1", "Player 2").playSnap();
                yield true;
            }
            case "2" -> {
                new HigherLower("Higher Lower").playHigherLower();
                yield true;
            }
            case "3" -> {
                System.out.println("\nThanks for playing! Goodbye!");
                yield false;
            }
            default -> {
                System.out.println("Please enter '1', '2', or '3'");
                yield true;
            }
        };
    }
}
