public class Board {
    private final int size = 3;
    private final int asciiOfA = 65;
    private char[][] matrix;

    public Board() {
        this.matrix = new char[size][size];
    }

    public char[][] getMatrix() {
        return this.matrix;
    }

    public void processUserMove(char row, int col, char sign)
            throws GameExceptions.IllegalMoveException, GameExceptions.IllegalSignException {
        if (row < 'A' || row > 'C') {
            throw new GameExceptions.IllegalMoveException(Strings.rowOutOfBounds);
        } else if (col < 1 || col > 3) {
            throw new GameExceptions.IllegalMoveException(Strings.colOutOfBounds);
        } else if (sign != 'X' && sign != 'O') {
            throw new GameExceptions.IllegalSignException(Strings.colOutOfBounds);
        }
        int rowValue = (int) row;
        this.matrix[rowValue - asciiOfA][col - 1] = sign;
    }

}
