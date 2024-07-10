package ru.clevertec.check.services;

import ru.clevertec.check.factory.InvoiceFactory;
import ru.clevertec.check.factory.LineGoodsFactory;
import ru.clevertec.check.entity.Invoice;
import ru.clevertec.check.entity.Order;
import ru.clevertec.check.entity.OrderItem;
import ru.clevertec.check.entity.discountcards.LineGoods;

import java.util.ArrayList;
import java.util.List;

public class ServiceInvoice {
    public static Invoice getInvoiceByOrder(Order order){
        Invoice invoice = new Invoice();
        List<LineGoods> linesGoods = new ArrayList<>();

        List<OrderItem> orderItems = Order.getItems();
        for(OrderItem orderItem :orderItems){
            System.out.print(orderItem.toString());
            LineGoods lineGoods = LineGoodsFactory.build(orderItem, order.getDiscountCard());
            linesGoods.add(lineGoods);
            invoice = InvoiceFactory.build(linesGoods, order.getDiscountCard());
        }
        return invoice;
    }
}
