public class UserMove {
    private char row;
    private int col;
    private char sign;

    public UserMove(char row, int col, char sign) {
        this.row = row;
        this.col = col;
        this.sign = sign;
    }

    public char getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public char getSign() {
        return this.sign;
    }
}
