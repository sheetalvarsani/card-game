public class Main {
    public static void main(String[] args) {

        Snap game = new Snap("Snap", "Player 1", "Player 2");

        game.shuffleDeck();

        game.playSnap();
    }
}
