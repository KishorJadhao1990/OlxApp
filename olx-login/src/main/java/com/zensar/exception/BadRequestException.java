package com.zensar.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String messageCode) {
        super(messageCode);
    }
}
