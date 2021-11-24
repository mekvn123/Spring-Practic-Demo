package com.example.main_application_demo.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String msg) {
        super(msg);
    }
}
