package ru.clevertec.check.factory;

import ru.clevertec.check.entity.Item;
import ru.clevertec.check.entity.OrderItem;

public class OrderItemFactory {
    public static OrderItem build(Item item,int quantity) {
        return new OrderItem(item,quantity);
    }
}
