package demo.impl;

import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.Player;

import java.io.InputStream;
import java.util.Optional;

public class Pronouncer {

    public static void pronounce(String word) {
        try {
            String fileName = Words.convertWordToPronunciationFileName(word);
            Optional<InputStream> is = Mp3Loader.getPronunciationInputStream(fileName);
            if (is.isPresent()) {
                Player player = new Player(is.get(), FactoryRegistry.systemRegistry().createAudioDevice());
                player.play();
                while (!player.isComplete()) {
                    Thread.sleep(100);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
