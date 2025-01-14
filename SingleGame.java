import board.Board;
import input.InputManager;
import input.UserMove;
import utils.GameExceptions;
import utils.Outputs;
import utils.Strings;

public class SingleGame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player turn;
    private GameState gameState;
    private InputManager inputManager;

    public SingleGame(String player1Name, String player2Name) {
        this.gameState = GameState.SETUP;
        this.board = new Board();
        this.inputManager = InputManager.getInstance();

        char p1Sign;
        char p2Sign;
        if (Math.random() < 0.5) {
            p1Sign = 'O';
            p2Sign = 'X';
        } else {
            p2Sign = 'O';
            p1Sign = 'X';
        }
        this.player1 = new Player(player1Name, p1Sign);
        this.player2 = new Player(player2Name, p2Sign);
        System.out.println(player1Name + " got assigned with: " + p1Sign);
        System.out.println(player2Name + " got assigned with: " + p2Sign);

        this.turn = (Math.random() < 0.5) ? player1 : player2;
        System.out.println("Hey " + this.turn.getName() + "! You start. Remember, you are " + this.turn.getSign() + ".");
        System.out.println("\nAccepted move formats: a1, A1.");
    
        this.gameState = GameState.ACTIVE;
    }
    
    public Board getBoard() {
        return this.board;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public void processUserMove() {
        boolean validMove = false;
        while (!validMove) {
            try {
                UserMove userMove = inputManager.readMoveLine(turn.getName(), turn.getSign());
                this.board.processUserMove(userMove.getRow(), userMove.getCol(), userMove.getSign());
                validMove = true;
            } catch (GameExceptions.IllegalMoveException | GameExceptions.IllegalSignException
                    | GameExceptions.CellAlreadyUsedException | GameExceptions.GarbageValueInCellException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println(Strings.enterYouMoveAgain);
                Outputs.printSpaceLine();
            }
        }
        this.turn = (this.turn == player1) ? player2 : player1;
    }

    public boolean isWinner() {
        return this.board.checkIfSomeoneWon();
    }

    public boolean isDraw() {
        return this.board.checkIfDraw();
    }

    public Player getWinner() throws GameExceptions.NoWinnerYetException {
        if (!board.checkIfSomeoneWon()) {
            throw new GameExceptions.NoWinnerYetException("");  // TODO: add exception string
        }
        this.gameState = GameState.FINISHED;
        char winnerSign = board.getWinner();
        Player winner = (this.player1.getSign() == winnerSign) ? player1 : player2;
        return winner;
    }
}
