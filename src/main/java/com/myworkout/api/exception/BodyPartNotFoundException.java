package com.myworkout.api.exception;

public class BodyPartNotFoundException extends RuntimeException {

    public BodyPartNotFoundException() {
    }

    public BodyPartNotFoundException(String message) {
        super(message);
    }
}
