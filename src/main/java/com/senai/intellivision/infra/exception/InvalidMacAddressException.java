package com.senai.intellivision.infra.exception;

public class InvalidMacAddressException extends RuntimeException{
    public InvalidMacAddressException(String message) {
        super(message);
    }

    public InvalidMacAddressException() {
        super("Invalid Mac Address");
    }
}
