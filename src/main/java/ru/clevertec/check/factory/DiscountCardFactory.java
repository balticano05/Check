package ru.clevertec.check.factory;

import ru.clevertec.check.entity.abstr.DiscountCard;
import ru.clevertec.check.entity.discountcards.NoneDiscountCard;
import ru.clevertec.check.entity.discountcards.ShopDiscountCard;
import ru.clevertec.check.entity.discountcards.UserDiscountCard;

public class DiscountCardFactory {
    public static DiscountCard build(int id, String number, int discountAmount) {
        return new ShopDiscountCard(id, number, discountAmount);
    }
    public static DiscountCard build(String number) {
        return new UserDiscountCard(number);
    }
    public static DiscountCard build() {
        return new NoneDiscountCard();
    }
}
