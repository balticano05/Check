package ru.clevertec.check.services;

import ru.clevertec.check.factory.DebitCardFactory;
import ru.clevertec.check.entity.DebitCard;

public class ServiceDebitBalance{
    public static DebitCard getDebitCard(Double Balance) {
        DebitCard debitCard = DebitCardFactory.build(Balance);
        return debitCard;
    }
}
