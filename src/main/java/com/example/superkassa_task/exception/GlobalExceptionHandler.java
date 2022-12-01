package com.example.superkassa_task.exception;

import com.example.superkassa_task.entity.EntityIncorrectData;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityIncorrectData> entityNotFound(EntityNotFoundException exception) {

        EntityIncorrectData entityIncorrectData = new EntityIncorrectData(exception.getMessage());
        return new ResponseEntity<>(entityIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<EntityIncorrectData> notValidData(ConstraintViolationException exception) {
        EntityIncorrectData entityIncorrectData = new EntityIncorrectData(exception.getMessage());
        return new ResponseEntity<>(entityIncorrectData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectRequestDataException.class)
    public ResponseEntity<EntityIncorrectData> incorrectRequestData(IncorrectRequestDataException exception) {

        EntityIncorrectData entityIncorrectData = new EntityIncorrectData(exception.getMessage());
        return new ResponseEntity<>(entityIncorrectData, HttpStatus.valueOf(418));
    }
}
