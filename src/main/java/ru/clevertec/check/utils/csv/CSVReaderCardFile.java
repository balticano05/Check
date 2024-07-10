package ru.clevertec.check.utils.csv;


import ru.clevertec.check.utils.validation.FormatFirstLineDiscountFile;
import ru.clevertec.check.utils.validation.FormatValidatorLineDiscountFile;
import ru.clevertec.check.utils.exception.InvalidFormatLineInDiscountFileException;
import ru.clevertec.check.utils.exception.InvalidFormatFirstLineDiscountException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CSVReaderCardFile {
    private String filePath;

    public CSVReaderCardFile(String filePath) {
        this.filePath = filePath;
    }

    public CSVReaderCardFile() {
        this.filePath = "src/main/resources/discountCards.csv";
    }

    public List<String[]> read() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Флаг для первой строки
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    FormatFirstLineDiscountFile.isValidFirstLineDiscount(line);      //  FORMAT FRIST LINE
                    firstLine = false;
                    continue; // Пропускаем первую строку
                }

                FormatValidatorLineDiscountFile.isValidFormat(line);

                String[] values = line.split(";");
                data.add(values);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND: " + filePath);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("ERROR READING FILE: " + filePath);
            throw new RuntimeException(e);
        } catch (InvalidFormatLineInDiscountFileException e) {
            System.out.println("ERROR PARSING FILE: " + filePath + ". " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InvalidFormatFirstLineDiscountException e) {
            System.out.println("ERROR PARSING FILE: " + filePath + ". " + e.getMessage());
            throw new RuntimeException(e);
        }
        return data;
    }
}
