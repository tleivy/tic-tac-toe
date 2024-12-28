public class Player {
    private String name;
    private char sign;
    private int score;

    public Player(String name, char sign) {
        this.name = name;
        this.sign = sign;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
    
    public char getSign() {
        return this.sign;
    }

    public void incScore() {
        this.score++;
    }

    public void nullifyScore() {
        this.score = 0;
    }
}
