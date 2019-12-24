package demo.impl;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvLoader {

    public static List<List<String>> load() throws Exception {
        InputStream is = CsvLoader.class.getResourceAsStream("/words.csv");
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);

        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(isr)) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                List<String> record = Arrays.asList(values);
                records.add(record);
            }
        }

        return records;
    }
}
