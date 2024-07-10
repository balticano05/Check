package ru.clevertec.check;

import ru.clevertec.check.services.ServiceGenerateCheck;


public class CheckRunner {
    public static void main(String[] args) {
        String testLine = String.join(" ",args);
        System.out.println(testLine);
        testLine = "3-1 2-5 5-1 discountCard=1211 balanceDebitCard=100.32";
        ServiceGenerateCheck serviceGenerateCheck = new ServiceGenerateCheck();
        serviceGenerateCheck.runService(testLine);

    }
}
