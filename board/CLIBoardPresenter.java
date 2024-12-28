package board;

/**
 * The CLIBoardPresenter outputs the board to the terminal.
 * This is a 3x3 board.
 */
public class CLIBoardPresenter implements BoardPresenter {
    @Override
    public void drawBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length + 6; i++) {
            for (int j = 0; j < board.length + 6; j++) {
                if (isRowNumCoordinate(i, j)) {
                    System.out.print(getRowNumberFromIndex(i));
                } else if (isColNumCoordinate(i, j)) {
                    System.out.print(getColNumberFromIndex(j));
                } else if (isSpaceBufferRow(i)) {
                    if (isLastCol(j, board.length)) {
                        System.out.print(" \n");
                    } else {
                        System.out.print(" ");
                    }
                } else if (isSpaceBufferColumn(j)) {
                    System.out.print(" ");
                } else if (isHorizontalWallCol(i, j)) {
                    if (isLastCol(j, board.length)) {
                        System.out.print("-\n");
                    } else {
                        System.out.print("-");
                    }
                } else if (isVerticalWallCol(i, j)) {
                    if (isLastCol(j, board.length)) {
                        System.out.print("|\n");
                    } else {
                        System.out.print("|");
                    }
                } else if (isBoardCell(i, j)) {
                    int[] indicesToPrint = getMatrixCellIndices(i, j);
                    System.out.print(board[indicesToPrint[0]][indicesToPrint[1]]);
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    private boolean isRowNumCoordinate(int i, int j) {
        return j == 0 && i > 2 && i % 2 == 1;
    }

    private boolean isColNumCoordinate(int i, int j) {
        return i == 0 && j > 2 && j % 2 == 1;
    }

    private boolean isSpaceBufferRow(int i) {
        return i == 1;
    }

    private boolean isSpaceBufferColumn(int j) {
        return j == 1;
    }

    private boolean isHorizontalWallCol(int i, int j) {
        return i > 0 && i % 2 == 0 && j > 0;
    }

    private boolean isLastCol(int j, int boardSize) {
        return j == boardSize + 5;
    }

    private boolean isVerticalWallCol(int i, int j) {
        return i % 2 == 1 && j % 2 == 0;
    }

    private boolean isBoardCell(int i, int j) {
        return (i == 3 || i == 5 || i == 7) && (j == 3 || j == 5 || j == 7);
    }

    /**
     * This method converts the virtual board coordiantes to real matrix coordinates
     * 
     * @param row
     * @param col
     * @return An array of 2 elements - row in cell 0 and column in cell 1
     */
    private int[] getMatrixCellIndices(int row, int col) {
        int rowToPrint = 0;
        int colToPrint = 0;
        switch (row) {
            case 3:
                rowToPrint = 0;
                break;

            case 5:
                rowToPrint = 1;
                break;

            case 7:
                rowToPrint = 2;
                break;
        }
        switch (col) {
            case 3:
                colToPrint = 0;
                break;

            case 5:
                colToPrint = 1;
                break;

            case 7:
                colToPrint = 2;
                break;
        }
        int[] printIndices = new int[2];
        printIndices[0] = rowToPrint;
        printIndices[1] = colToPrint;
        return printIndices;
    }

    private char getRowNumberFromIndex(int i) {
        char res = ' ';
        switch (i) {
            case 3:
                res = 'A';
                break;
            case 5:
                res = 'B';
                break;
            case 7:
                res = 'C';
                break;
            default:
                break;
        }
        return res;
    }

    private char getColNumberFromIndex(int j) {
        char res = ' ';
        switch (j) {
            case 3:
                res = '1';
                break;
            case 5:
                res = '2';
                break;
            case 7:
                res = '3';
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        board[0][0] = 'X';
        board[1][1] = 'O';

        CLIBoardPresenter presenter = new CLIBoardPresenter();
        presenter.drawBoard(board);
    }
}
