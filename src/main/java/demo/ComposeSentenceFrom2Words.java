package demo;

import demo.impl.CsvLoader;
import demo.impl.Pronouncer;

import java.util.List;
import java.util.Random;

public class ComposeSentenceFrom2Words {

    public static void main(String[] args) throws Exception {
        List<List<String>> records = CsvLoader.load();

         Random random = new Random();

        while (records.size() > 1) {
            pronounceWord(random, records);
            pronounceWord(random, records);

            Thread.sleep(15000);

            System.out.println();
        }
    }

    private static void pronounceWord(Random random, List<List<String>> records) {
        int i = random.nextInt(records.size());
        List<String> record = records.get(i);
        records.remove(i);

        String word = record.get(0);
        System.out.println(String.format("%-20s%-20s%s", word, record.get(1), record.get(2)));

        Pronouncer.pronounce(word);
    }
}
