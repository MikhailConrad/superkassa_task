package com.example.superkassa_task.exception;

public class IncorrectRequestDataException extends RuntimeException{
    private final static String EXCEPTION_MESSAGE = "Невозможно провести операцию";

    public IncorrectRequestDataException() {
        super(EXCEPTION_MESSAGE);
    }
}
