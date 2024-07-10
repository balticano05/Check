package ru.clevertec.check.utils.validation;

import ru.clevertec.check.utils.exception.InvalidFormatLineInDiscountFileException;

public final class FormatValidatorLineDiscountFile {

    public static void isValidFormat(String line) throws InvalidFormatLineInDiscountFileException {
        String regex = "^\\d{1,7};\\d{4};(?:[1-9]|[1-9][0-9]|100)$";
        if (!line.matches(regex)) {
            throw new InvalidFormatLineInDiscountFileException("ERROR: Invalid format in discount file line.");
        }
    }
}