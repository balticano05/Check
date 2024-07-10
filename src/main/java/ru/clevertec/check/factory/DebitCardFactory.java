package ru.clevertec.check.factory;

import ru.clevertec.check.entity.DebitCard;

public class DebitCardFactory {
    public static DebitCard build(double balance){
        return new DebitCard(balance);
    }
}
