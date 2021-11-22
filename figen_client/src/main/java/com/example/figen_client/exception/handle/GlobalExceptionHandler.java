package com.example.figen_client.exception.handle;

import com.example.figen_client.exception.EncodeNotFoundException;
import com.example.figen_client.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EncodeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(EncodeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(400, "Bad Request", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
