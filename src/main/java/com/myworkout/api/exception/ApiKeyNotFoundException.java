package com.myworkout.api.exception;

public class ApiKeyNotFoundException extends RuntimeException {
    public ApiKeyNotFoundException() {
    }

    public ApiKeyNotFoundException(String message) {
        super(message);
    }
}
