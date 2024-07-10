package ru.clevertec.check.factory;

import ru.clevertec.check.entity.abstr.DiscountCard;
import ru.clevertec.check.entity.OrderItem;
import ru.clevertec.check.entity.discountcards.LineGoods;

public class LineGoodsFactory {
    public static LineGoods build(int quantity, String description,
                                           Double price, Double discount, Double total) {
        return new LineGoods(quantity,description,price,discount,total);
    }

    public static LineGoods build(OrderItem orderItem, DiscountCard discountCard){
        LineGoods lineGoods = new LineGoods();
        if(orderItem.getQuantity()<orderItem.getItem().getQuantity()){
            lineGoods.setQuantity(orderItem.getQuantity());
        }else{
            lineGoods.setQuantity(orderItem.getItem().getQuantity());
        }
        double precentage = discountCard.getDiscountAmount();
        if(orderItem.getItem().isWholesale()&&(lineGoods.getQuantity()>=5)){
            precentage = 10;
        }
        lineGoods.setDescription(orderItem.getItem().getDescription());
        lineGoods.setPrice(orderItem.getItem().getPrice());
        double totalPrice = lineGoods.getPrice()*lineGoods.getQuantity();
        lineGoods.setTotal(totalPrice);
        lineGoods.setDiscount(totalPrice*precentage/100);
        return lineGoods;
    }

}
