package ru.clevertec.check.entity.abstr;

public abstract class DiscountCard {
    protected int id;
    protected String number;
    protected int discountAmount;

    public DiscountCard(int id, String number, int discountAmount) {
        this.id = id;
        this.number = number;
        this.discountAmount = discountAmount;
    }

    //getters/setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
