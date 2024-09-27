public class Main {
    public static void main(String[] args) {

        Snap game = new Snap("Snap");

        game.shuffleDeck();

        game.playSnap();
    }
}
