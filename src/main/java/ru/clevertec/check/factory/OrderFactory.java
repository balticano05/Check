package ru.clevertec.check.factory;

import ru.clevertec.check.entity.DebitCard;
import ru.clevertec.check.entity.abstr.DiscountCard;
import ru.clevertec.check.entity.Order;
import ru.clevertec.check.entity.OrderItem;

import java.util.List;

public class OrderFactory {
    public static Order createOrder(List<OrderItem> items, DiscountCard discountCard, DebitCard debitCard) {
        return new Order(items, discountCard, debitCard);
    }
}
