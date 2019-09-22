package org.yausername.npsync.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class NewPipeException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final HttpStatus status;

    public NewPipeException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public NewPipeException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }
}