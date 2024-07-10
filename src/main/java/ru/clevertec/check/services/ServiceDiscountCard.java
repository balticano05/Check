package ru.clevertec.check.services;

import ru.clevertec.check.utils.csv.CSVReaderCardFile;
import ru.clevertec.check.utils.csv.CSVParser;
import ru.clevertec.check.factory.DiscountCardFactory;
import ru.clevertec.check.entity.abstr.DiscountCard;

import java.util.List;

public class ServiceDiscountCard {
    public static DiscountCard getDiscountCard(String numberDiscountCard) {
        if (numberDiscountCard != null) {
            // Fetch data from CSV file
            CSVReaderCardFile csvReaderCardFile = new CSVReaderCardFile();
            List<String[]> data = csvReaderCardFile.read();
            String[] foundDiscountCard = null;

            for (String[] dataRow : data) {
                if (dataRow[1].equals(numberDiscountCard)) {
                    foundDiscountCard = dataRow;
                    break;
                }
            }

            if (foundDiscountCard != null) {
                System.out.println("ID DISCOUNT CARD WAS FOUND.");
                CSVParser csvParser = new CSVParser();
                return csvParser.parseRowToDiscountCard(foundDiscountCard);
            } else {
                System.out.println("DISCOUNT CARD NOT FOUND IN FILE.");

                return DiscountCardFactory.build(numberDiscountCard);
            }
        }

        return DiscountCardFactory.build();
    }
}