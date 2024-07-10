package ru.clevertec.check.services;

import ru.clevertec.check.factory.OrderFactory;
import ru.clevertec.check.utils.csv.CSVWriter;
import ru.clevertec.check.dto.ResponseDTO;
import ru.clevertec.check.entity.DebitCard;
import ru.clevertec.check.entity.Invoice;
import ru.clevertec.check.entity.Order;
import ru.clevertec.check.entity.OrderItem;
import ru.clevertec.check.entity.abstr.DiscountCard;
import ru.clevertec.check.utils.parser.InputParser;
import ru.clevertec.check.utils.parser.ParsedInput;
import ru.clevertec.check.utils.validation.FormatValidatorArgs;

import java.util.ArrayList;
import java.util.List;

public class ServiceGenerateCheck {

    public void runService(String testLine){
        CSVWriter csvWriter = new CSVWriter();
        ResponseDTO responseDTO;
        try {
            if (FormatValidatorArgs.validateInput(testLine) && FormatValidatorArgs.hasBalanceDebitCard()) {
                System.out.println("GOOD.");

                ParsedInput parsedInput = InputParser.parseInput(testLine);

                System.out.println("ID-Quantity Pairs: " + parsedInput.getIdQuantityPairs()); // List<String>
                System.out.println("Discount Card: " + (parsedInput.getDiscountCard() != null ? parsedInput.getDiscountCard() : "None"));
                System.out.println("Balance Debit Card: " + parsedInput.getBalanceDebitCard());

                List<OrderItem> orderItems = new ArrayList<OrderItem>();
                DebitCard debitCard = new DebitCard();

                ServiceOrder serviceOrder = new ServiceOrder();
                ServiceDiscountCard serviceDiscountCard = new ServiceDiscountCard();
                ServiceDebitBalance serviceDebitBalance = new ServiceDebitBalance();
                Order order = new Order();

                System.out.println(parsedInput.getDiscountCard());
                orderItems = ServiceOrder.getOrderItems(parsedInput.getIdQuantityPairs());
                if (orderItems.isEmpty()) {
                    System.out.println();
                    System.out.println("NO ORDER ITEMS FOUND.");
                    System.out.println("BAD REQUEST.");
                    return;                                           //-------------------------------------
                }

                DiscountCard discountCard = ServiceDiscountCard.getDiscountCard(parsedInput.getDiscountCard());
                System.out.println(discountCard.toString());

                debitCard = ServiceDebitBalance.getDebitCard(parsedInput.getBalanceDebitCard());
                System.out.println(debitCard.toString());
                order = OrderFactory.createOrder(orderItems, discountCard, debitCard);
                System.out.println("-------------CREATE INVOICE-------------");
                Invoice invoice = ServiceInvoice.getInvoiceByOrder(order);
                invoice.printCheck();

                if (invoice.getTotalDiscountPrice() <= debitCard.getBalance()) {
                    csvWriter.write(invoice);
                } else {
                    responseDTO = new ResponseDTO("ERROR","NOT ENOUGH MONEY");
                    csvWriter.write(responseDTO);
                }

            } else {
                responseDTO = new ResponseDTO("ERROR","BAD REQUEST");
                csvWriter.write(responseDTO);
                System.out.println("BAD REQUEST.");                     //RECORD IN FILE ---------------------------
            }
        }catch (Exception e) {
            responseDTO = new ResponseDTO("ERROR","INTERNAL ERROR");
            csvWriter.write(responseDTO);
        }
    }
}
