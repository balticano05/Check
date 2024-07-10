package ru.clevertec.check.entity;

import ru.clevertec.check.entity.discountcards.LineGoods;

import java.util.List;

public class Invoice {
    private Double totalPrice;
    private Double totalDiscount;
    private Double totalDiscountPrice;
    private List<LineGoods> linesGoods;
    private String numberDiscountCard;
    private int percentage;

    public Invoice(){
    }

    public Invoice(Double totalPrice, Double totalDiscount, Double totalDiscountPrice, List<LineGoods> linesGoods,
                   String numberDiscountCard, int percentage) {
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalDiscountPrice = totalDiscountPrice;
        this.linesGoods = linesGoods;
        this.numberDiscountCard = numberDiscountCard;
        this.percentage = percentage;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public void setTotalDiscountPrice(Double totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public List<LineGoods> getLinesGoods() {
        return linesGoods;
    }

    public void setLinesGoods(List<LineGoods> linesGoods) {
        this.linesGoods = linesGoods;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getNumberDiscountCard() {
        return numberDiscountCard;
    }

    public void setNumberDiscountCard(String numberDiscountCard) {
        this.numberDiscountCard = numberDiscountCard;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalPrice=" + totalPrice +
                ", totalDiscount=" + totalDiscount +
                ", totalDiscountPrice=" + totalDiscountPrice +
                ", linesGoods=" + linesGoods +
                ", numberDiscountCard='" + numberDiscountCard + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    public void printCheck() {
        System.out.println("\nQTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL");
        for (LineGoods lineGoods : linesGoods) {
            // Форматирование строк с двумя знаками после запятой
            System.out.printf("%d;%s;%.2f$;%.2f$;%.2f$\n",
                    lineGoods.getQuantity(),
                    lineGoods.getDescription(),
                    lineGoods.getPrice(),
                    lineGoods.getDiscount(),
                    lineGoods.getTotal());
        }
        System.out.println("\nDISCOUNT CARD;DISCOUNT PERCENTAGE");
        System.out.printf("%s;%d\n", getNumberDiscountCard(), getPercentage(),"%");
        System.out.println("\nTOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT");
        // Форматирование строк с двумя знаками после запятой для итоговых сумм
        System.out.printf("%.2f$;%.2f$;%.2f$\n", getTotalPrice(), getTotalDiscount(), getTotalDiscountPrice());
    }
}
