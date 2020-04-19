package demo;

import demo.impl.CsvLoader;
import demo.impl.Mp3Loader;
import demo.impl.Words;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class GetMissedPronunciations {

    public static void main(String[] args) throws Exception {
        List<List<String>> records = CsvLoader.load();

        int available = 0;
        int unavailable = 0;

        for (List<String> record : records) {
            String word = record.get(0);
            if (word != null) {
                String fileName = Words.convertWordToPronunciationFileName(word);
                Optional<InputStream> is = Mp3Loader.getPronunciationInputStream(fileName);
                if (is.isPresent()) {
                    available++;
                } else {
                    System.out.println(word);
                    unavailable++;
                }
            }
        }

        System.out.println("Count of available pronunciations: " + available);
        System.out.println("Count of unavailable pronunciations: " + unavailable);
    }
}
