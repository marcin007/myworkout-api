package com.myworkout.api.exception;


public class ExercisePhotoNotFoundException extends RuntimeException {

    public ExercisePhotoNotFoundException() {
    }

    public ExercisePhotoNotFoundException(String message) {
        super(message);
    }
}
