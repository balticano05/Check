package ru.clevertec.check.entity.discountcards;

public class LineGoods {
    private int quantity;
    private String description;
    private Double price;
    private Double discount;
    private Double Total;

    public LineGoods() {
    }

    public LineGoods(int quantity, String description, Double price, Double discount, Double total) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.discount = discount;
        Total = total;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public Double getTotal() {
        return Total;
    }
    public void setTotal(Double total) {
        Total = total;
    }
}
