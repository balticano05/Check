package ru.clevertec.check.utils.csv;

import ru.clevertec.check.dto.ResponseDTO;
import ru.clevertec.check.entity.Invoice;
import ru.clevertec.check.entity.discountcards.LineGoods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class CSVWriter {
    private static String filePath;

    public CSVWriter() {
        filePath = "result.csv";
    }

    public static void write(Invoice invoice){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy;HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
            writer.println("Date;Time;");
            writer.println(formattedDateTime);
            writer.println();
            writer.println("QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL");
            for(LineGoods lineGoods : invoice.getLinesGoods()){
                writer.printf("%d;%s;%.2f$;%.2f$\n",
                        lineGoods.getQuantity(),
                        lineGoods.getDescription(),
                        lineGoods.getPrice(),
                        lineGoods.getDiscount(),
                        lineGoods.getTotal());
            }
            writer.println("\nDISCOUNT CARD;DISCOUNT PERCENTAGE");
            writer.printf("%s;%d%%\n", invoice.getNumberDiscountCard(), invoice.getPercentage());
            writer.println("\nTOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT");
            writer.printf("%.2f$;%.2f$;%.2f$\n", invoice.getTotalPrice(), invoice.getTotalDiscount(), invoice.getTotalDiscountPrice());
        } catch (IOException e) {
            System.out.println("ERROR WRITING FILE: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void write(ResponseDTO responseDTO){
        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))){
            writer.println(responseDTO.getStatus());
            writer.println(responseDTO.getMessage());
        }catch (IOException e) {
            System.out.println("ERROR WRITING FILE: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
