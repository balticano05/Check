package ru.clevertec.check.factory;

import ru.clevertec.check.entity.abstr.DiscountCard;
import ru.clevertec.check.entity.Invoice;
import ru.clevertec.check.entity.discountcards.LineGoods;

import java.util.List;

public class InvoiceFactory {
    public static Invoice build(List<LineGoods> linesGoods, DiscountCard discountCard) {
        Double totalPrice = 0.0;
        Double totalDiscount = 0.0;
        Double totalDiscountPrice = 0.0;

        for(LineGoods lineGoods : linesGoods) {
            totalPrice += lineGoods.getPrice();
            totalDiscount += lineGoods.getDiscount();
            totalDiscountPrice += lineGoods.getPrice();
        }
        return new Invoice(totalPrice, totalDiscount, totalDiscountPrice-totalDiscount, linesGoods, discountCard.getNumber(),
                discountCard.getDiscountAmount());
    }
}
