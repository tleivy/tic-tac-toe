import java.util.HashMap;

public class Board {
    private final int size = 3;
    private final int asciiOfA = 65;
    private final HashMap<Character, Character> opponentSign = new HashMap<>() {
        {
            put('X', 'O');
            put('O', 'X');
        }
    };
    private char[][] matrix;

    public Board() {
        this.matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[i][j] = ' ';
            }
        }
    }

    public char[][] getMatrix() {
        return this.matrix;
    }

    public void processUserMove(char row, int col, char sign)
            throws GameExceptions.IllegalMoveException, GameExceptions.IllegalSignException,
            GameExceptions.CellAlreadyUsed, GameExceptions.GarbageValueInCell {
        int rowValue = (int) row - asciiOfA;
        int colValue = col - 1;
        if (validateUserInputInBounds(row, col, sign) && validateCellIsEmpty(rowValue, colValue, sign)) {
            this.matrix[rowValue][colValue] = sign;
        }

    }

    private boolean validateUserInputInBounds(char row, int col, char sign)
            throws GameExceptions.IllegalMoveException, GameExceptions.IllegalSignException {
        if (row < 'A' || row > 'C') {
            throw new GameExceptions.IllegalMoveException(Strings.rowOutOfBounds);
        } else if (col < 1 || col > 3) {
            throw new GameExceptions.IllegalMoveException(Strings.colOutOfBounds);
        } else if (sign != 'X' && sign != 'O') {
            throw new GameExceptions.IllegalSignException(Strings.colOutOfBounds);
        }
        return true;
    }

    private boolean validateCellIsEmpty(int row, int col, char sign)
            throws GameExceptions.CellAlreadyUsed, GameExceptions.GarbageValueInCell {
        if (this.matrix[row][col] == sign) {
            throw new GameExceptions.CellAlreadyUsed(Strings.userCellAlreadyVisted);
        } else if (this.matrix[row][col] == opponentSign.get(sign)) {
            throw new GameExceptions.CellAlreadyUsed(Strings.opponentCellAlreadyVisted);
        } else if (this.matrix[row][col] != ' ') {
            throw new GameExceptions.GarbageValueInCell(Strings.garbageValueInCell);
        }
        return true;
    }
}
