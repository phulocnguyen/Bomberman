package main.Utility;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import static main.PvPGame.*;
// import static main.Levels.NextLevel.*;

public class SoundManager extends JFrame {
    public static boolean isSound = true;
    public static Clip titleScreen;
    public static Clip bombExplosion;
    public static Clip justDied;

    public static boolean isSoundDied;
    public static boolean isSoundTitle;
    // private static boolean isSoundComplete;

    public SoundManager(String _name, String _sound) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            URL url = this.getClass().getClassLoader().getResource(_name);

            assert url != null;
            AudioInputStream audio_in = AudioSystem.getAudioInputStream(url);
            if (_sound.equals("title")) {
                titleScreen = AudioSystem.getClip();
                titleScreen.open(audio_in);
                titleScreen.start();
                titleScreen.loop(10);
            }
            if (_sound.equals("explosion")) {
                bombExplosion = AudioSystem.getClip();
                bombExplosion.open(audio_in);
                bombExplosion.start();
            }
            if (_sound.equals("just_died")) {
                justDied = AudioSystem.getClip();
                justDied.open(audio_in);
                justDied.start();
            }
            if (_sound.equals("default")) {
                Clip clipp = AudioSystem.getClip();
                clipp.open(audio_in);
                clipp.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void updateSound() {
        if (isSound) {
            if (!isSoundTitle) {
                new SoundManager("sound/title_screen.wav", "title");
                isSoundTitle = true;
            }
            if (!player1.isAlive() || !player2.isAlive()) {
                titleScreen.close();
                bombExplosion.close();
                if (!isSoundDied) {
                    new SoundManager("sound/just_died.wav", "just_died");
                    isSoundDied = true;
                }
            }
            // if (wait) {
            //     titleScreen.close();
            //     bombExplosion.close();
            //     if (!isSoundComplete) {
            //         new SoundManager("sound/level_complete.wav", "default");
            //         isSoundComplete = true;
            //     }
            // }
        } else {
            titleScreen.stop();
            isSoundTitle = false;
        }
    }

    public static void updateSound(String s) {
        if(isSound == true) {
            if (s == "explosion") {
                new SoundManager("sound/bomb_explosion.wav", "explosion");
            }
            if (s == "StartMenu") {
                new SoundManager("sound/just_died.wav", "title");
            }
        }
    }
}