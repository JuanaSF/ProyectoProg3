package ar.com.ucema.reservation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(InvalidFieldsException.class)
    public ResponseEntity<ErrorMessage> handleInvalidFieldsException(InvalidFieldsException ex) {
        ErrorMessage result = new ErrorMessage(ex.getStatus(), ex.getError(), ex.getMessage(), ex.getDetails());

        logger.error("InvalidFieldsException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(result, ex.getStatus());
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorMessage> handleServiceException(ServiceException ex) {
        ErrorMessage result = new ErrorMessage(ex.getStatus(), ex.getError(), ex.getMessage());

        logger.error("ServiceException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(result, ex.getStatus());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorMessage> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorMessage result = new ErrorMessage(HttpStatus.UNAUTHORIZED, "Bad credentials Error",
                "The provided credentials are invalid");

        logger.error("BadCredentialsException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage result = new ErrorMessage(ex.getStatus(), ex.getError(), ex.getMessage());

        logger.error("ResourceNotFoundException: " + ex.getMessage(), ex);
        return new ResponseEntity<>(result, ex.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorMessage result = new ErrorMessage(HttpStatus.BAD_REQUEST,
                "JSON parse error", "The provided JSON is invalid or cannot be read correctly");
        logger.error("Unknown Error: " + ex.getMessage(), ex);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAllException(Exception ex) {
        ErrorMessage result = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal Server Error","Unknown error processing the request");
        logger.error("Unknown Error: " + ex.getMessage(), ex);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
