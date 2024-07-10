package ru.clevertec.check.utils.validation;

import ru.clevertec.check.utils.exception.InvalidFormatFirstLineDiscountException;
import ru.clevertec.check.utils.exception.InvalidFormatFirstLineProductException;

public final class FormatFirstLineDiscountFile {
    public static void isValidFirstLineDiscount(String firstline) throws InvalidFormatFirstLineDiscountException {
        String regex = "id;number;discountAmount\n";
        if(firstline.replace(" ","").equals(regex)) {
            throw new InvalidFormatFirstLineProductException("ERROR FORMAT FIRST LINE DISCOUNT FILE.");
        }
    }
}
