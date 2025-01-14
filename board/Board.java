package board;

import java.util.HashMap;

import utils.Strings;
import utils.GameExceptions;

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
    private char winner;

    public Board() {
        nullifyGame();
    }

    public char[][] getMatrix() {
        return this.matrix;
    }

    public char getWinner() {
        return this.winner;
    }

    public void resetBoard() {
        nullifyGame();
    }

    public void processUserMove(char row, int col, char sign)
            throws GameExceptions.IllegalMoveException, GameExceptions.IllegalSignException,
            GameExceptions.CellAlreadyUsedException, GameExceptions.GarbageValueInCellException {
        int rowValue = (int) row - asciiOfA;
        int colValue = col - 1;
        if (validateUserInputInBounds(row, col, sign) && validateCellIsEmpty(rowValue, colValue, sign)) {
            this.matrix[rowValue][colValue] = sign;
        }
    }

    /**
     * This method checks if there's a triple of same sign in the board.
     * As a side effect it updates the winner, if there is one.
     * 
     * @return true if there's a winner, false otherwise.
     */
    public boolean checkIfSomeoneWon() {
        return isRowWinner() || isColWinner() || isDiagonalWinner();
    }

    public boolean checkIfDraw() {
        if (checkIfSomeoneWon()) return false;
        else {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (this.matrix[i][j] == ' ') return false;
                }
            }
        }
        return true;
    }

    private void nullifyGame() {
        this.matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[i][j] = ' ';
            }
        }
        this.winner = ' ';
    }

    private boolean validateUserInputInBounds(char row, int col, char sign)
            throws GameExceptions.IllegalMoveException, GameExceptions.IllegalSignException {
        if (row < 'A' || row > 'C') {
            throw new GameExceptions.IllegalMoveException(Strings.rowOutOfBounds);
        } else if (col < 1 || col > 3) {
            throw new GameExceptions.IllegalMoveException(Strings.colOutOfBounds);
        } else if (sign != 'X' && sign != 'O') {
            throw new GameExceptions.IllegalSignException(Strings.illegalSign);
        }
        return true;
    }

    private boolean validateCellIsEmpty(int row, int col, char sign)
            throws GameExceptions.CellAlreadyUsedException, GameExceptions.GarbageValueInCellException {
        if (this.matrix[row][col] == sign) {
            throw new GameExceptions.CellAlreadyUsedException(Strings.userCellAlreadyVisted);
        } else if (this.matrix[row][col] == opponentSign.get(sign)) {
            throw new GameExceptions.CellAlreadyUsedException(Strings.opponentCellAlreadyVisted);
        } else if (this.matrix[row][col] != ' ') {
            throw new GameExceptions.GarbageValueInCellException(Strings.garbageValueInCell);
        }
        return true;
    }

    private boolean isRowWinner() {
        for (int i = 0; i < this.size; i++) {
            if (this.matrix[i][0] == this.matrix[i][1] && this.matrix[i][0] == this.matrix[i][2]
                    && this.matrix[i][0] != ' ') {
                this.winner = this.matrix[i][0];
                return true;
            }
        }
        return false;
    }

    private boolean isColWinner() {
        for (int j = 0; j < this.size; j++) {
            if (this.matrix[0][j] == this.matrix[1][j] && this.matrix[0][j] == this.matrix[2][j]
                    && this.matrix[0][j] != ' ') {
                this.winner = this.matrix[0][j];
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWinner() {
        return isMainDiagonalWinner() || isOtherDiagonalWinner();
    }

    private boolean isMainDiagonalWinner() {
        if (this.matrix[0][0] == this.matrix[1][1] && this.matrix[0][0] == this.matrix[2][2]
                && this.matrix[0][0] != ' ') {
            this.winner = this.matrix[0][0];
            return true;
        }
        return false;
    }

    private boolean isOtherDiagonalWinner() {
        if (this.matrix[2][0] == this.matrix[1][1] && this.matrix[2][0] == this.matrix[2][0]
                && this.matrix[2][0] != ' ') {
            this.winner = this.matrix[0][0];
            return true;
        }
        return false;
    }
}
