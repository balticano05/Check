package ru.clevertec.check.utils.csv;

import ru.clevertec.check.factory.DiscountCardFactory;
import ru.clevertec.check.factory.ItemFactory;
import ru.clevertec.check.entity.abstr.DiscountCard;
import ru.clevertec.check.entity.Item;

public final class CSVParser {
    public static Item parseRowToItem(String[] data) {
        int id = Integer.parseInt(data[0]);
        String description = data[1];
        double price = Double.parseDouble(data[2]);
        int quantity = Integer.parseInt(data[3]);
        boolean isWholeItem = Boolean.parseBoolean(data[4]);
        return ItemFactory.build(id, description, price, quantity, isWholeItem);
    }

    public static DiscountCard parseRowToDiscountCard(String[] data){
        int id = Integer.parseInt(data[0]);
        String description = data[1];
        int discountAmount = Integer.parseInt(data[2]);
        return DiscountCardFactory.build(id,description,discountAmount);
    }
}
