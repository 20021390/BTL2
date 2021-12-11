package bomberman.sound;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Sound {
    public static String inGame = "D:\\OOP\\BTL\\src\\bomberman\\sound\\sound effect\\ingame.wav";
    public Sound() {};
    public static void play (String path) {
        InputStream music;
        try {
            music = new FileInputStream(new File(path));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playIngame() {
        Sound.play(inGame);
    }
}
