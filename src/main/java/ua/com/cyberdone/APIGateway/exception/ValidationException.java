package ua.com.cyberdone.APIGateway.exception;

public class ValidationException extends Exception {
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}
