package ru.clevertec.check.entity;

import ru.clevertec.check.entity.abstr.DiscountCard;

import java.util.List;

public class Order {
    private static List<OrderItem> items;
    private DiscountCard discountCard;
    private DebitCard debitCard;

    public Order() {
    }

    public Order(List<OrderItem> items, DiscountCard discountCard, DebitCard debitCard) {
        this.items = items;
        this.discountCard = discountCard;
        this.debitCard = debitCard;
    }
    public static List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    public DiscountCard getDiscountCard() {
        return discountCard;
    }
    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }
    public DebitCard getDebitCard() {
        return debitCard;
    }
    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }
}
