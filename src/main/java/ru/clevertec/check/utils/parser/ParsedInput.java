package ru.clevertec.check.utils.parser;

import java.util.List;

public final class ParsedInput {
    private List<String> idQuantityPairs;
    private String discountCard;
    private double balanceDebitCard;

    public ParsedInput(List<String> idQuantityPairs, String discountCard, double balanceDebitCard) {
        this.idQuantityPairs = idQuantityPairs;
        this.discountCard = discountCard;
        this.balanceDebitCard = balanceDebitCard;
    }

    public List<String> getIdQuantityPairs() {
        return idQuantityPairs;
    }

    public String getDiscountCard() {
        return discountCard;
    }

    public double getBalanceDebitCard() {
        return balanceDebitCard;
    }
}
