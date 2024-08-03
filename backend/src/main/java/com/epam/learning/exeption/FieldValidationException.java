package com.epam.learning.exeption;

public class FieldValidationException extends RuntimeException{
    public FieldValidationException(String message) {
        super(message);
    }
}
