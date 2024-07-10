package ru.clevertec.check.utils.validation;

import ru.clevertec.check.utils.exception.InvalidFormatFirstLineProductException;

public final class FormatFirstLineInProductFile {
    public static void isValidFirstLineInFile(String firstLine)throws InvalidFormatFirstLineProductException {
        String regex = "id;description;price;quantity_in_stock;wholesale_product\n";
        if(firstLine.replace(" ","").matches(regex)){
            throw new InvalidFormatFirstLineProductException("ERROR FORMAT FIRST LINE PRODUCT FILE");
        }
    }
}
