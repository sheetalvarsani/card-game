public class Player {
    private String name;
    private boolean isWinner;

    public Player(String name) {
        this.name = name;
        this.isWinner = false;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }
}
