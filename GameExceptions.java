public class GameExceptions {
    public class IllegalMoveException extends Exception {
        public IllegalMoveException(String message) {
            super(message);
        }
    }

    public class IllegalSignException extends Exception {
        public IllegalSignException(String message) {
            super(message);
        }
    }
}
