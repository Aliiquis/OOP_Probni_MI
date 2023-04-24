package hr.fer.oop;

public class ArgumentParseException extends Exception {
    public ArgumentParseException(Throwable cause) {
        super("Exception occured!", cause);
    }

    public ArgumentParseException(String message) {
        super(message);
    }
}
