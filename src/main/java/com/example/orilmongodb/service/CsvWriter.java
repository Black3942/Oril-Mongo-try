package com.example.orilmongodb.service;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {
    public static void writeData(List<String> list, Double min, Double max) {
        List<String[]> csvData = createCsv(list, min, max);
        try (CSVWriter writer = new CSVWriter(new FileWriter("c:\\test\\test.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to csv");
        }

    }

    private static List<String[]> createCsv(List<String> list, Double min, Double max) {
        String[] header = {"Cryptocurrency Name", "Min Price", "Max Price"};
        List<String[]> result = new ArrayList<>();
        result.add(header);
        list.forEach(e -> {
            String[] record = {e, String.valueOf(min), String.valueOf(max)};
            result.add(record);
        });
        return result;
    }
}
