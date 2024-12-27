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

    public UserMove readLine(String playerName, char sign) {
        System.out.println("Move format is row,col");
        System.out.println(playerName + ", enter your move:");
        String input = InputManager.getInstance().getScanner().nextLine();
        String[] parts = input.split(",");
        
        char row = parts[0].trim().charAt(0);
        int col = Integer.parseInt(parts[1].trim());
        
        return new UserMove(row, col, sign);
    }
 }