package Modul2;

import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class AudioInputStreamDemo {
    public static void main(String[] args) throws Exception {

        String audioFile = "d:/do.wav";
        InputStream in = new FileInputStream(audioFile);

        AudioStream audioStream = new AudioStream(in);
        
        AudioPlayer.player.start(audioStream);
    }
}
