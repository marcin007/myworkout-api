package com.myworkout.api.exception;

public class SessionExerciseNotFoundException extends RuntimeException{
    public SessionExerciseNotFoundException() {
    }

    public SessionExerciseNotFoundException(String message) {
        super(message);
    }
}
