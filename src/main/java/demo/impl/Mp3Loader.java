package demo.impl;

import java.io.InputStream;
import java.util.Optional;

public class Mp3Loader {

    public static Optional<InputStream> getPronunciationInputStream(String fileName) {
        return Optional.ofNullable(
                Mp3Loader.class.getResourceAsStream("/pronunciation" + String.format("/%s.mp3", fileName))
        );
    }
}
