package main.Control;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static main.Utility.SoundManager.*;
import static main.BombermanGame.*;
import main.Levels.*;

public class Menu {
    private static ImageView statusGame;
    private static ImageView statusSound;
    public static Text level, score, time;
    public static int timeNumber = 120;

    public static void createMenu(Group root) {
        level = new Text("");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(416);
        level.setY(20);
        score = new Text("");
        score.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        score.setFill(Color.WHITE);
        score.setX(512);
        score.setY(20);
        time = new Text("");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(608);
        time.setY(20);

        Image newGame = new Image("images/newGame.png");
        statusGame = new ImageView(newGame);
        statusGame.setX(-75);
        statusGame.setY(-10);
        statusGame.setScaleX(0.5);
        statusGame.setScaleY(0.5);

        Image muteSound = new Image("images/mute.png");
        statusSound = new ImageView(muteSound);
        statusSound.setX(497);
        statusSound.setY(-240);
        statusSound.setScaleX(0.05);
        statusSound.setScaleY(0.05);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, score, time, statusGame, statusSound);
        pane.setMinSize(800, 32);
        pane.setMaxSize(800, 32);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        statusSound.setOnMouseClicked(event -> {
            updatestatusSound();
        });

        statusGame.setOnMouseClicked(event -> {
            if (player.isAlive()) {
                running = !running;
            } else {
                new nowLevel(0);
                running = true;
            }
            updateMenu();
        });
    }

    public static void updatestatusSound() {
        if(isSound == true) {
            Image unmuteSound = new Image("images/unmute.png");
            isSound = false;
            statusSound.setImage(unmuteSound);
            updateSound();

        } else {
            Image muteSound = new Image("images/mute.png");
            isSound = true;
            statusSound.setImage(muteSound);
            updateSound();    
        }
    }

    public static void updateMenu() {
        level.setText("Level: " + _level);
        if (player.isAlive())
            if (running) {
                Image pauseGame = new Image("images/pauseGame.png");
                statusGame.setImage(pauseGame);
            } else {
                Image playGame = new Image("images/playGame.png");
                statusGame.setImage(playGame);
            }
        else {
            Image newGame = new Image("images/newGame.png");
            statusGame.setImage(newGame);
        }
    }
}
