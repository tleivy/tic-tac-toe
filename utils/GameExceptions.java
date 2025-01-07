package utils;

public class GameExceptions {
    public static class IllegalMoveException extends Exception {
        public IllegalMoveException(String message) {
            super(message);
        }
    }

    public static class IllegalSignException extends Exception {
        public IllegalSignException(String message) {
            super(message);
        }
    }

    public static class CellAlreadyUsedException extends Exception {
        public CellAlreadyUsedException(String message) {
            super(message);
        }
    }

    public static class GarbageValueInCellException extends Exception {
        public GarbageValueInCellException(String message) {
            super(message);
        }
    }

    public static class NoWinnerYetException extends Exception {
        public NoWinnerYetException(String message) {
            super(message);
        }
    }

    public static class ContinueGameException extends Exception {
        public ContinueGameException(String message) {
            super(message);
        }
    }

    public static class EmptyNameException extends Exception {
        public EmptyNameException(String message) {
            super(message);
        }
    }
}
