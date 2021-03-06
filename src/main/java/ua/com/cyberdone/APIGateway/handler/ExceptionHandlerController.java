package ua.com.cyberdone.APIGateway.handler;


import feign.FeignException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import ua.com.cyberdone.APIGateway.exception.AlreadyExistException;
import ua.com.cyberdone.APIGateway.exception.AuthenticationException;
import ua.com.cyberdone.APIGateway.exception.InternalException;
import ua.com.cyberdone.APIGateway.exception.NotFoundException;
import ua.com.cyberdone.APIGateway.model.RestError;

import java.nio.file.AccessDeniedException;
import java.security.SignatureException;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ExceptionHandlerController {

    public static final String BAD_REQUEST_MSG = "The request does not follow the correct syntax";
    public static final String INTERNAL_SERVER_ERROR_MSG = "There was an error processing the request.";
    public static final String NOT_FOUND_MSG = "Resource not found";
    public static final String ACCESS_DENIED_MSG = "Access denied";
    public static final String NO_CONTENT_MSG = "The resource is null or empty";
    public static final String METHOD_NOT_ALLOWED_MSG = "Operation with resource not allowed";
    public static final String UNAUTHORIZED_MSG = "You are unauthorized.";

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<RestError> noHandlerFoundException(NoHandlerFoundException exception) {
        log.error("NoHandlerFoundException: ", exception);
        log.error(HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .title(NOT_FOUND_MSG)
                .detail("Resource not found for " + exception.getRequestURL())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<RestError> noHandlerFoundException(NullPointerException exception) {
        log.error("NullPointerException: ", exception);
        log.error(HttpStatus.NO_CONTENT.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.NO_CONTENT.getReasonPhrase())
                .title(NO_CONTENT_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<RestError> noHandlerFoundException(AccessDeniedException exception) {
        log.error("AccessDeniedException: ", exception);
        log.error(HttpStatus.FORBIDDEN.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.FORBIDDEN.getReasonPhrase())
                .title(ACCESS_DENIED_MSG)
                .detail("You have no permission to access the resource " + exception.getMessage())
                .build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<RestError> noHandlerFoundException(AuthenticationException exception) {
        log.error("AuthenticationException: ", exception);
        log.error(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .title(UNAUTHORIZED_MSG)
                .detail("Authentication failed: " + exception.getMessage())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<RestError> noHandlerFoundException(ExpiredJwtException exception) {
        log.error("ExpiredJwtException: ", exception);
        log.error(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .title(UNAUTHORIZED_MSG)
                .detail("JWT token is expired: " + exception.getMessage())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<RestError> noHandlerFoundException(SignatureException exception) {
        log.error("SignatureException: ", exception);
        log.error(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .title(UNAUTHORIZED_MSG)
                .detail("Bad JWT Signature: " + exception.getMessage())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<RestError> noHandlerFoundException(MalformedJwtException exception) {
        log.error("MalformedJwtException: ", exception);
        log.error(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .title(UNAUTHORIZED_MSG)
                .detail("Malformed Jwt: " + exception.getMessage())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<RestError> noHandlerFoundException(UnsupportedJwtException exception) {
        log.error("UnsupportedJwtException: ", exception);
        log.error(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .title(UNAUTHORIZED_MSG)
                .detail("Unsupported Jwt: " + exception.getMessage())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestError> noHandlerFoundException(NotFoundException exception) {
        log.error("NotFoundException: ", exception);
        log.error(HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .title(NOT_FOUND_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<RestError> noHandlerFoundException(AlreadyExistException exception) {
        log.error("AlreadyExistException: ", exception);
        log.error(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())
                .title(METHOD_NOT_ALLOWED_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<RestError> validationException(ValidationException exception) {
        log.error("ValidationException: ", exception);
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .title(BAD_REQUEST_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<RestError> httpClientErrorException(HttpClientErrorException exception) {
        log.error("HttpClientErrorException: ", exception);
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .title(BAD_REQUEST_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestError> httpClientErrorException(MethodArgumentNotValidException exception) {
        log.error("MethodArgumentNotValidException: ", exception);
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .title(BAD_REQUEST_MSG)
                .detail(String.format("Invalid parameters '%s'. %s",
                        exception.getBindingResult().getFieldErrors().stream()
                                .map(e -> "'" + e.getField() + "'->'" + e.getRejectedValue() + "'")
                                .collect(Collectors.toSet()), exception.getMessage()))
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<RestError> httpClientErrorException(MethodArgumentTypeMismatchException exception) {
        log.error("MethodArgumentTypeMismatchException: ", exception);
        log.error(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .title(BAD_REQUEST_MSG)
                .detail(String.format("Invalid url parameter '%s' has been sent. %s", exception.getName(),
                        exception.getMessage()))
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<RestError> httpClientErrorException(InternalException exception) {
        log.error("InternalException: ", exception);
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .title(INTERNAL_SERVER_ERROR_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestError> httpClientErrorException(Exception exception) {
        log.error("Exception: ", exception);
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .title(INTERNAL_SERVER_ERROR_MSG)
                .detail(exception.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<RestError> httpClientErrorException(FeignException exception) {
        log.error("FeignException: ", exception);
        log.error(HttpStatus.valueOf(exception.status()).getReasonPhrase());
        return new ResponseEntity<>(RestError.builder()
                .error(String.valueOf(exception.status()))
                .title(HttpStatus.valueOf(exception.status()).getReasonPhrase())
                .detail(exception.getMessage())
                .build(), HttpStatus.valueOf(exception.status()));
    }
}
