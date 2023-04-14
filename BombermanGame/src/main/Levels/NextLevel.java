package main.Levels;

import javafx.scene.image.Image;

import static main.BombermanGame.*;

public class NextLevel {
    public static boolean wait;
    public static long waitingTime;

    public static void waitToLevelUp() {
        if (wait) {
            Image waitToNext = new Image("images/levelUp.png");
            authorView.setImage(waitToNext);
            long now = System.currentTimeMillis();
            if (now - waitingTime > 3000) {
                new nowLevel(_level + 1);
                wait = false;
            }
        }
    }
}