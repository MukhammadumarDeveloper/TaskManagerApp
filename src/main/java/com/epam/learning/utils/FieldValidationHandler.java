package com.epam.learning.utils;

import lombok.experimental.UtilityClass;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@UtilityClass
public class FieldValidationHandler {

    //    Main purpose of this utility is returning meaningfull error messages to the frontend
    public static String validateFields(BindingResult result){
        if (result.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            for (FieldError fieldError: result.getFieldErrors()){
                errorMessages.append(fieldError.getField())
                        .append(": ")
                        .append(fieldError.getDefaultMessage())
                        .append(";\n");
            }
            return errorMessages.toString();
        }
        return null;
    }

}
