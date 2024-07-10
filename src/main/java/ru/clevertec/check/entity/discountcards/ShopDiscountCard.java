package ru.clevertec.check.entity.discountcards;

import ru.clevertec.check.entity.abstr.DiscountCard;

public class ShopDiscountCard extends DiscountCard {
    public ShopDiscountCard(int id, String cardNumber, int discountAmount){
        super(id, cardNumber, discountAmount);
    }
}
