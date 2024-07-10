package ru.clevertec.check.utils.csv;

import ru.clevertec.check.utils.exception.InvalidFormatFirstLineProductException;
import ru.clevertec.check.utils.exception.InvalidFormatLinesInFileException;
import ru.clevertec.check.utils.validation.FormatFirstLineInProductFile;
import ru.clevertec.check.utils.validation.FormatValidatorLineProduct;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CSVReaderProductFile {
    private String filePath;

    public CSVReaderProductFile(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> read() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Флаг для первой строки
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    FormatFirstLineInProductFile.isValidFirstLineInFile(line);
                    firstLine = false;
                    continue; // Пропускаем первую строку
                }

                FormatValidatorLineProduct.isValidFormat(line);

                String[] values = line.split(";");
                data.add(values);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND: " + filePath);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("ERROR READING FILE: " + filePath);
            throw new RuntimeException(e);
        } catch (InvalidFormatLinesInFileException e){
            System.out.println("ERROR PARSING FILE: " + filePath + ". " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InvalidFormatFirstLineProductException e){
            System.out.println("ERROR PARSING FILE: " + filePath + ". " + e.getMessage());
            throw new RuntimeException(e);
        }
        return data;
    }
}
