package com.myworkout.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BodyPartNotFoundException.class)
    public ResponseEntity<ApiError> handleBodyPartNotFoundException(BodyPartNotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new ApiError("BodyPart Not Found", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

}
