package com.example.main_application_demo.exception.handler;

import com.example.main_application_demo.exception.ErrorResponse;
import com.example.main_application_demo.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ErrorResponse> handle(UserNotExistException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder().status(400).error("Bad Request").message(ex.getMessage()).build());
    }
}
