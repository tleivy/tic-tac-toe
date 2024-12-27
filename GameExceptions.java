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

    public static class CellAlreadyUsed extends Exception {
        public CellAlreadyUsed(String message) {
            super(message);
        }
    }
}
