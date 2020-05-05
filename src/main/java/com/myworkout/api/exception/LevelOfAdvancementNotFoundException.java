package com.myworkout.api.exception;

public class LevelOfAdvancementNotFoundException extends RuntimeException {

    public LevelOfAdvancementNotFoundException() {
    }

    public LevelOfAdvancementNotFoundException(String message) {
        super(message);
    }
}
