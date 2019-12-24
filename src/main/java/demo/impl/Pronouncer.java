package demo.impl;

import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.Player;

import java.io.InputStream;

public class Pronouncer {

    public static void pronounce(String word) {
        try {
            String fileName = Words.convertWordToPronunciationFileName(word);
            InputStream is = Mp3Loader.getPronunciationInputStream(fileName);
            if (is != null) {
                Player player = new Player(is, FactoryRegistry.systemRegistry().createAudioDevice());
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
