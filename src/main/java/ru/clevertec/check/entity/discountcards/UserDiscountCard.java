package ru.clevertec.check.entity.discountcards;

import ru.clevertec.check.entity.abstr.DiscountCard;

public class UserDiscountCard extends DiscountCard {
    public UserDiscountCard(int id, String cardNumber, int discountAmount) {
        super(0, cardNumber, 2);
    }
    public UserDiscountCard(String cardNumber) {
        super(0, cardNumber, 2);
    }
}
