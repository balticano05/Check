package ru.clevertec.check.factory;

import ru.clevertec.check.entity.Item;

public class ItemFactory {
    public static Item build(int id, String description, double price, int quantity, boolean isWholesale) {
        return new Item(id, description, price, quantity, isWholesale);
    }

    public static Item build(String[] data) {
        Item item = new Item();
        item.setId(Integer.parseInt(data[0]));
        item.setDescription(data[1]);
        item.setPrice(Double.parseDouble(data[2]));
        item.setQuantity(Integer.parseInt(data[3]));
        item.setWholesale(Boolean.parseBoolean(data[4]));
        return item;
    }
}
