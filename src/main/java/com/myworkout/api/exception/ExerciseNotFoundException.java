package com.myworkout.api.exception;

public class ExerciseNotFoundException extends RuntimeException{
    public ExerciseNotFoundException() {
    }

    public ExerciseNotFoundException(String message) {
        super(message);
    }
}
