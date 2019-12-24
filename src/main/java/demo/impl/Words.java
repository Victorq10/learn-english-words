package demo.impl;

public class Words {

    public static String convertWordToPronunciationFileName(String word) {
        if (word.startsWith("to ")) {
            word = word.substring(3);
        }
        word = word.replaceAll("\\?","").trim();
        return word;
    }
}
