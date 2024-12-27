public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void incScore() {
        this.score++;
    }

    public void nullifyScore() {
        this.score = 0;
    }
}
