import java.util.LinkedList;

import board.BoardPresenter;
import board.CLIBoardPresenter;
import input.InputManager;
import utils.GameExceptions;
import utils.Outputs;

public class TicTacToe {
    private LinkedList<SingleGame> pastGames;
    private String p1Name;
    private String p2Name;
    private int p1Wins;
    private int p2Wins;
    private InputManager inputManager;
    private SingleGame currGame;
    private BoardPresenter boardPresenter;

    public TicTacToe() {
        this.inputManager = InputManager.getInstance();
        this.boardPresenter = new CLIBoardPresenter();
        this.pastGames = new LinkedList<SingleGame>();

        Outputs.printSpaceLine();
        boolean validInput = false;
        while (!validInput) {
            try {
                this.p1Name = inputManager.readPlayerName(1);
                this.p2Name = inputManager.readPlayerName(2);
            } catch (GameExceptions.EmptyNameException e) {
                System.out.println("Error: " + e.getMessage());
            }
            validInput = true;
        }
        Outputs.printSpaceLine();

        this.p1Wins = 0;
        this.p2Wins = 0;
    }

    public void start() {
        boolean stopGame = false;
        while (!stopGame) {
            this.currGame = new SingleGame(p1Name, p2Name);
            this.boardPresenter.drawBoard(this.currGame.getBoard().getMatrix());

            while (!currGame.hasSomeoneWon() && !currGame.isDraw()) {
                currGame.processUserMove();
                this.boardPresenter.drawBoard(this.currGame.getBoard().getMatrix());
            }
            Outputs.printSpaceLine();
            if (currGame.hasSomeoneWon()) {
                try {
                    String winnerName = currGame.getWinner().getName();
                    System.out.println("*** Congratulations, " + winnerName + "! You won!");
                    if (winnerName == p1Name)
                        p1Wins++;
                    else
                        p2Wins++;
                } catch (GameExceptions.NoWinnerYet e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else System.out.println("*** This game is a draw.");
            Outputs.printSpaceLine();

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
        System.out.println(p1Name + " won " + getP1Wins() + " games.");
        System.out.println(p2Name + " won " + getP2Wins() + " games.");
        if (getP1Wins() == getP2Wins()) System.out.println("This match is a draw! Score is " + getP1Wins() + " - " + getP1Wins() + "\n");
        else {
            String matchWinner = p1Name;
            if (getP1Wins() < getP2Wins()) matchWinner = p2Name;
            System.out.println("The winner of this match is: " + matchWinner);
            System.out.println("\nThanks for playing!\n");
        }
    }

    public int getP1Wins() {
        return this.p1Wins;
    }

    public int getP2Wins() {
        return this.p2Wins;
    }

    public static void main(String[] args) {
        TicTacToe match = new TicTacToe();
        match.start();
    }
}
