package main.Control;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static main.Control.Menu.*;
import static main.Utility.SoundManager.*;

import java.util.logging.Level;

import static main.BombermanGame.*;

import main.BombermanGame;
import main.Graphics.Sprite;
import main.Levels.*;
import static main.Utility.SoundManager.*;
public class StartMenu {
    private static ImageView MenuNewGame;
    public static Text status;
    
    public static void createStartMenu(Group root) {
        Image newGame1 = new Image("images/newGame.png");
        MenuNewGame = new ImageView(newGame1);
        MenuNewGame.setX(39);
        MenuNewGame.setY(160);
        MenuNewGame.setScaleX(1);
        MenuNewGame.setScaleY(1);
        Pane pane = new Pane();
        pane.getChildren().addAll(MenuNewGame);
        pane.setMinSize(400, 300);
        pane.setMaxSize(400, 300);
        pane.setLayoutX(200);
        pane.setLayoutY(80);
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
                new nowLevel(0);
                running = true;
            }
            updateMenu();
        });
    }
}
