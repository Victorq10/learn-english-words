package demo.impl;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Words {

    public static String convertWordToPronunciationFileName(String word) {
        if (word.length() <= 2) {
            byte[] bytes = word.getBytes(StandardCharsets.UTF_8);
            return new BigInteger(1, bytes).toString(16);
        } else {
            if (word.startsWith("to ")) {
                word = word.substring(3);
            }
            word = word.replaceAll("\\?", "");
            word = word.replaceAll("\\(.*\\)", "");
            return word.trim();
        }
    }
}
