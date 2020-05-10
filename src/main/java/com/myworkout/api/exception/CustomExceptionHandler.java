package com.myworkout.api.exception;


import com.myworkout.api.entity.ExercisePhoto;
import com.myworkout.api.entity.LevelOfAdvancement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.ResultSet;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new ApiError(e.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExercisePhotoNotFoundException.class)
    public ResponseEntity<ApiError> handleExercisePhotoNotFoundException ( ExercisePhotoNotFoundException e, WebRequest request){
        return new ResponseEntity<>(new ApiError("Exercise photo not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LevelOfAdvancementNotFoundException.class)
    public ResponseEntity<ApiError> handlerLevelOfAdvancementNotFoundException ( LevelOfAdvancementNotFoundException e, WebRequest request){
        return new ResponseEntity<>(new ApiError("Level of advancement not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handlerUserNotFoundException (UserNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("User not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SessionExerciseNotFoundException.class)
    public ResponseEntity<ApiError> handlerSessionExerciseNotFoundException(SessionExerciseNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("Session exercise not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SessionNotFoundException.class)
    public ResponseEntity<ApiError> handlerSessionNotFoundException(SessionNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("Session not found exception.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExerciseNotFoundException.class)
    public ResponseEntity<ApiError> handlerExerciseNotFoundException(ExerciseNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("Exercise not found exception.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiKeyNotFoundException.class)
    public ResponseEntity<ApiError> handlerApiKeyNotFoundException(ApiKeyNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("Api key not found.", HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
    }





}
