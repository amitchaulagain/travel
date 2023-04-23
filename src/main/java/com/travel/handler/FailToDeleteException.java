package com.travel.handler;

public class FailToDeleteException extends RuntimeException {
    public FailToDeleteException(String message) {
        super(message);
    }
}
