package hr.fer.oop;

public abstract class ParseReadingException extends Exception {
    public ParseReadingException() {
    }

    public ParseReadingException(Throwable cause) {
        super(cause);
    }

    public ParseReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
