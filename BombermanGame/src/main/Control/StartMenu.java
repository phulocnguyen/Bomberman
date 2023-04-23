package main.Control;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static main.Control.Menu.*;
import static main.BombermanGame.*;

import main.Levels.*;
public class StartMenu {
    private static ImageView MenuNewGame;
    private static ImageView MenuExit;
    private static ImageView HighScoreButton;
    public static Text status;
    
    public static void createStartMenu(Group root) {
        Image newGame1 = new Image("images/endNewGame.png");
        MenuNewGame = new ImageView(newGame1);
        MenuNewGame.setX(-185);
        MenuNewGame.setY(55);
        MenuNewGame.setScaleX(0.4);
        MenuNewGame.setScaleY(0.4);
        Image exitGame = new Image("images/endMenuExit.png");
        MenuExit = new ImageView(exitGame);
        MenuExit.setX(-185);
        MenuExit.setY(170);
        MenuExit.setScaleX(0.3);
        MenuExit.setScaleY(0.3);
        Image highscorebutton = new Image("images/HighScore.png");
        HighScoreButton = new ImageView(highscorebutton);
        HighScoreButton.setX(-198.5);
        HighScoreButton.setY(88);
        HighScoreButton.setScaleX(0.3);
        HighScoreButton.setScaleY(0.3);
        Pane pane = new Pane();
        pane.getChildren().addAll(MenuNewGame, MenuExit, HighScoreButton);
        pane.setMinSize(400, 300);
        pane.setMaxSize(400, 300);
        pane.setLayoutX(10);
        pane.setLayoutY(200);
        //pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        status = new Text("BOMBERMAN");
        status.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        status.setFill(Color.WHITE);
        status.setX(350);
        status.setY(20);
        
        Pane pane1 = new Pane();
        pane1.getChildren().addAll(status);
        pane1.setMinSize(800, 32);
        pane1.setMaxSize(800, 32);
        pane1.setStyle("-fx-background-color: #353535");
        
        root.getChildren().add(pane1);

        MenuNewGame.setOnMouseClicked(event -> {
            root.getChildren().remove(pane);
            root.getChildren().remove(pane1);
            if (player.isAlive()) {
                running = !running;
            } else {
                new nowLevel(1);
                running = true;
            }
            updateMenu();
        });

        MenuExit.setOnMouseClicked(event -> {
            Platform.exit();
        });

        HighScoreButton.setOnMouseClicked(event -> {
            HighScoreMenu.createHighScoreMenu(rootmain);
        });
    }
}
