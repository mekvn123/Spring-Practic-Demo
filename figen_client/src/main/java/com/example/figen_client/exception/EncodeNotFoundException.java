package com.example.figen_client.exception;

public class EncodeNotFoundException extends RuntimeException {
    public EncodeNotFoundException() {
        super("Unknown Encode!");
    }

    public EncodeNotFoundException(String errorInfo) {
        super(errorInfo);
    }
}
