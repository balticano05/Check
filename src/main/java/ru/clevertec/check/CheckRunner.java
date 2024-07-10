package ru.clevertec.check;

import ru.clevertec.check.services.ServiceGenerateCheck;


public class CheckRunner {
    public static void main(String[] args) {
        String inp = String.join(" ",args);
        System.out.println(inp);
        ServiceGenerateCheck serviceGenerateCheck = new ServiceGenerateCheck();
        serviceGenerateCheck.runService(inp);

    }
}
