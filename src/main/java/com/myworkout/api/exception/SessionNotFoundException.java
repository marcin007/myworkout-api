package com.myworkout.api.exception;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException() {
    }

    public SessionNotFoundException(String message) {
        super(message);
    }
}
