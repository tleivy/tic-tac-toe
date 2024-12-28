import java.util.LinkedList;

public class TicTacToe {
    private LinkedList<SingleGame> pastGames;
    private String p1Name;
    private String p2Name;
    private int p1Wins;
    private int p2Wins;
    private InputManager inputManager;
    private SingleGame currGame;

    public TicTacToe() {
        this.inputManager = InputManager.getInstance();
        this.pastGames = new LinkedList<SingleGame>();
        this.p1Name = inputManager.readPlayerName(1);
        this.p2Name = inputManager.readPlayerName(2);
        this.p1Wins = 0;
        this.p2Wins = 0;

        boolean stopGame = false;
        while (!stopGame) {
            this.currGame = new SingleGame(p1Name, p2Name);
            
            while (!currGame.hasSomeoneWon()) {
                currGame.processUserMove();
            }

            printSpaceLine();
            try {
                System.out.println("*** Congratulations, " + currGame.getWinner().getName() + "! You won!");
            } catch (GameExceptions.NoWinnerYet e) {
                System.out.println("Error: " + e.getMessage());
            }
            printSpaceLine();

            this.pastGames.addLast(this.currGame);

            boolean validInput = false;
            while (!validInput) {
                try {
                    stopGame = !inputManager.readContinueGame();
                    validInput = true;
                } catch (GameExceptions.ContinueGameException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    private void printSpaceLine() { // TODO: move to utils
        System.out.println();
    }

    // TODO: handle wins counter logic

    public static void main(String[] args) {
        TicTacToe match = new TicTacToe();
    }
}
