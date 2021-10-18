package ua.com.cyberdone.APIGateway.exception;

public class InternalException extends RuntimeException {

    public InternalException(Exception e) {
        super(e);
    }
}
