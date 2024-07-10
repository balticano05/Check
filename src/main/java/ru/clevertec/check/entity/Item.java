package ru.clevertec.check.entity;

public class Item {
    private int id;
    private String description;
    private double price;
    private int quantity;
    private boolean isWholesale;

    public Item() {
    }

    public Item(int id, String description, double price, int quantity, boolean isWholesale) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.isWholesale = isWholesale;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean isWholesale() {
        return isWholesale;
    }
    public void setWholesale(boolean wholesale) {
        isWholesale = wholesale;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", isWholesale=" + isWholesale +
                '}';
    }
}
