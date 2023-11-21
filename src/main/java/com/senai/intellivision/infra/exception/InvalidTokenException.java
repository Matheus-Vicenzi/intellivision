package com.senai.intellivision.infra.exception;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException() {
        super("Invalid Token");
    }
}
