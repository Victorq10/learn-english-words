package demo.impl;

import java.io.InputStream;

public class Mp3Loader {

    public static InputStream getPronunciationInputStream(String fileName) {
        return Mp3Loader.class.getResourceAsStream("/pronunciation" + String.format("/%s.mp3", fileName));
    }
}
