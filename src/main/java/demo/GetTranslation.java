package demo;

import demo.impl.CsvLoader;
import demo.impl.Pronouncer;

import java.util.List;
import java.util.Random;

public class GetTranslation {

    public static void main(String[] args) throws Exception {
        List<List<String>> records = CsvLoader.load();

        Random random = new Random();
        while (records.size() > 0) {
            int i = random.nextInt(records.size());

            List<String> record = records.get(i);
            records.remove(i);

            String word = record.get(0);

            System.out.print(String.format("%-20s%-20s", word, record.get(1)));
            Pronouncer.pronounce(word);

            Thread.sleep(5000);
            System.out.println(record.get(2));
        }
    }
}
