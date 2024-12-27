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
        System.out.println("Player 1 - " + player1Name + " got assigned with:" + p1Sign);
        System.out.println("Player 2 - " + player2Name + " got assigned with:" + p2Sign);

        if (Math.random() < 0.5) {
            turn = player1;
            System.out.println("Hey " + player1Name + "! You start. Remember, you are " + player1.getSign());
        } else {
            turn = player2;
            System.out.println("Hey " + player2Name + "! You start. Remember, you are " + player2.getSign());
        }
        
        this.gameState = GameState.ACTIVE;
    }

    public void processUserMove() {
        UserMove userMove = inputManager.readLine(turn.getName(), turn.getSign());
        // TODO: continue process logic
        // Validate it, etc
    }
}
