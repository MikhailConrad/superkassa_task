package com.example.superkassa_task.exception;

public class EntityNotFoundException extends RuntimeException{

    private final static String EXCEPTION_MESSAGE = "Не найдена Entity с таким ID";

    public EntityNotFoundException() {
        super(EXCEPTION_MESSAGE);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
