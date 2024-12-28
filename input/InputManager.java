package input;
import java.util.Scanner;

import utils.GameExceptions;
import utils.Strings;
import utils.Outputs;


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

    public String readPlayerName(int playerNum) throws GameExceptions.EmptyNameException {
        String order = (playerNum == 1) ? "first" : "second";
        System.out.print("Enter " + order + " player name: ");
        String name =  InputManager.getInstance().getScanner().nextLine();
        if (name.length() < 1) {
            throw new GameExceptions.EmptyNameException(Strings.YouMustEnterName);
        }
        return name;
    }

    public UserMove readMoveLine(String playerName, char sign) throws GameExceptions.IllegalMoveException {
        System.out.print(playerName + ", you are " + sign + ". Enter your move: ");
        String input = InputManager.getInstance().getScanner().nextLine();
        System.out.println();
        
        input = input.trim();
        if (input.length() != 2) {
            throw new GameExceptions.IllegalMoveException(Strings.invalidMoveFormat);
        }
        
        char row = Character.toUpperCase(input.charAt(0));
        int col = Character.getNumericValue(input.charAt(1));
        
        return new UserMove(row, col, sign);
    }

    public boolean readContinueGame() throws GameExceptions.ContinueGameException {
        System.out.print("Would you like to play another round? [y/n]: ");
        String input = InputManager.getInstance().getScanner().nextLine().toLowerCase().trim();
        Outputs.printSpaceLine();        
        if (input.equals("y")) return true;
        if (input.equals("n")) return false;
        throw new GameExceptions.ContinueGameException(Strings.invalidContinueGameInput);
     }
 }