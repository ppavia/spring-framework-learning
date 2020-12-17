package ppa.spring.exception;

import org.springframework.http.HttpStatus;

public class ResponseException extends RuntimeException {
    private static final long serialVersionUID = -2140908949234313677L;
    private final HttpStatus httpCodeStatus;

    public ResponseException(String message, HttpStatus httpCodeStatus) {
        super(message);
        this.httpCodeStatus = httpCodeStatus;
    }

    public HttpStatus getHttpCodeStatus() {
        return httpCodeStatus;
    }
}