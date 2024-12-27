public class BoardPresenter {
    public void drawBoard(char[][] board) {
        for (int i = 0; i < board.length + 4; i++) {
            for (int j = 0; j < board.length + 4; j++) {
                if (isHorizontalWallCol(i)) {
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
                } else {
                    // Not a wall
                    int[] indicesToPrint = getMatrixCellIndices(i, j);
                    System.out.print(board[indicesToPrint[0]][indicesToPrint[1]]);
                }
            }
        }
    }

    private boolean isHorizontalWallCol(int i) {
        return i % 2 == 0;
    }

    private boolean isLastCol(int j, int boardSize) {
        return j == boardSize + 3;
    }

    private boolean isVerticalWallCol(int i, int j) {
        return i % 2 == 1 && j % 2 == 0;
    }

    private int[] getMatrixCellIndices(int i, int j) {
        int rowToPrint = 0;
        int colToPrint = 0;
        switch (i) {
            case 1:
                rowToPrint = 0;
                break;

            case 3:
                rowToPrint = 1;
                break;

            case 5:
                rowToPrint = 2;
                break;
        }
        switch (j) {
            case 1:
                colToPrint = 0;
                break;

            case 3:
                colToPrint = 1;
                break;

            case 5:
                colToPrint = 2;
                break;
        }
        int[] printIndices = new int[2];
        printIndices[0] = rowToPrint;
        printIndices[1] = colToPrint;
        return printIndices;
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
        
        BoardPresenter presenter = new BoardPresenter();
        presenter.drawBoard(board);
    }
}
