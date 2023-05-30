package ar.com.ucema.reservation.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorMessage {

    private int statusCode;
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private List<String> details;

    public ErrorMessage() { timestamp = LocalDateTime.now(); }

    public ErrorMessage(HttpStatus status, String error, String message, List<String> details) {
        this();
        this.statusCode = status.value();
        this.error = error;
        this.message = message;
        this.details = details;
    }

    public ErrorMessage(HttpStatus status, String error, String message) {
        this();
        this.statusCode = status.value();
        this.error = error;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
