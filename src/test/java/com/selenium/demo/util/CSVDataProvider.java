package com.selenium.demo.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVDataProvider {

    public static Object[][] getCSVData(String csvFilePath) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        String[] csvCell;
        int rowCount = 0;
        while ((csvCell = csvReader.readNext()) != null) {
            rowCount++;
        }
        csvReader.close();

        Object[][] data = new Object[rowCount][2];
        csvReader = new CSVReader(new FileReader(csvFilePath));
        for (int i = 0; i < rowCount; i++) {
            csvCell = csvReader.readNext();
            data[i][0] = csvCell[0]; // Email
            data[i][1] = csvCell[1]; // Password
        }
        return data;
    }
}
