package ru.clevertec.check.services;

import ru.clevertec.check.factory.OrderItemFactory;
import ru.clevertec.check.utils.csv.CSVParser;
import ru.clevertec.check.utils.csv.CSVReaderProductFile;
import ru.clevertec.check.entity.Item;
import ru.clevertec.check.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrder {
    private static String path;

    public ServiceOrder() {
        this.path = "src/main/resources/products.csv";
    }

    public static List<OrderItem> getOrderItems(List<String> pairs) {
        List<OrderItem> orderItems = new ArrayList<>();

        CSVReaderProductFile csvReader = new CSVReaderProductFile(path);
        List<String[]> data = csvReader.read();

        for (String pair : pairs) {
            String[] parts = pair.split("-");
            String id = parts[0];
            String quantityStr = parts[1];
            boolean found = false;

            for (String[] row : data) {
                if (row[0].equals(id)) {
                    System.out.println(row[1] + " " + row[2]);
                    CSVParser csvParser = new CSVParser();
                    Item item = csvParser.parseRowToItem(row);
                    int quantity = Integer.parseInt(quantityStr);
                    OrderItem orderItem = OrderItemFactory.build(item, quantity);
                    orderItems.add(orderItem);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Item with index " + id + " not found");
            }
        }
        System.out.println("\nOrder Items: ");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getItem().toString()+":"+orderItem.getQuantity());
        }

        return orderItems;
    }
}