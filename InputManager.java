import java.util.Scanner;

public class InputManager {
    private static InputManager instance;
    private final Scanner scanner = new Scanner(System.in);
    
    private InputManager() {}
    
    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }
    
    public Scanner getScanner() {
        return scanner;
    }

    public String readPlayerName(int playerNum) {
        String order = (playerNum == 1) ? "first" : "second";
        System.out.println("Enter " + order + " player name:");
        return InputManager.getInstance().getScanner().nextLine();  // TODO: maybe some input validation?
    }

    public UserMove readMoveLine(String playerName, char sign) {
        System.out.println("Move format is row,col");
        System.out.println(playerName + ", enter your move:");
        String input = InputManager.getInstance().getScanner().nextLine();
        String[] parts = input.split(",");
        
        char row = Character.toUpperCase(parts[0].trim().charAt(0));
        int col = Integer.parseInt(parts[1].trim());
        
        return new UserMove(row, col, sign);
    }

    public boolean readContinueGame() throws GameExceptions.ContinueGameException{
        System.out.println("Would you like to play another round? [y/n]:");
        String input = InputManager.getInstance().getScanner().nextLine().toLowerCase().trim();
        
        if (input.equals("y")) return true;
        if (input.equals("n")) return false;
        throw new GameExceptions.ContinueGameException(Strings.invalidContinueGameInput);
     }
 }