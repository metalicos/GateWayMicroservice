package ua.com.cyberdone.APIGateway.exception;

public class AccessDeniedException extends Exception {
    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }
}
