package com.epam.learning.utils;

import com.epam.learning.exeption.InvalidValidationException;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@UtilityClass
public class DateTimeUtils {

    public static String convertDateToString(LocalDateTime localDateTime) {
        if (Objects.nonNull(localDateTime)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return localDateTime.format(dateTimeFormatter);
        } else {
            return null;
        }
    }

    public static LocalDateTime convertStringToDate(String string) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(string, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new InvalidValidationException("Date and time should be in the following format: (yyyy-MM-dd HH:mm:ss)");
        }
    }
}
