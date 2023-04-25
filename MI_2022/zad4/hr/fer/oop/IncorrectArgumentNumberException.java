package hr.fer.oop;

public class IncorrectArgumentNumberException extends ParseReadingException {
    public IncorrectArgumentNumberException() {
    }

    public IncorrectArgumentNumberException(Throwable cause) {
        super(cause);
    }

    public IncorrectArgumentNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
