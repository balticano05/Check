package ru.clevertec.check.utils.validation;

import ru.clevertec.check.utils.exception.InvalidFormatLinesInFileException;

public final class FormatValidatorLineProduct {
    public static void isValidFormat(String format) throws InvalidFormatLinesInFileException {
        String regex = "\\d{1,7};[^;]+;\\d{1,}\\.\\d{1,2};\\d+;(true|false)";
        if(!format.matches(regex)) {
            throw new InvalidFormatLinesInFileException ("WRONG FORMAT LINES IN FILE.");
        }
    }
}
