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
import static main.PvPGame.*;

import main.Levels.*;
public class EndMenu {
    private static ImageView MenuNewGame;
    private static ImageView MenuExit;
    private static ImageView GameOver;
    private static Text EndScore;
    public static Text status;
    
    public static void createEndMenu(Group root) {
        Image newGame1 = new Image("images/endNewGame.png");
        MenuNewGame = new ImageView(newGame1);
        MenuNewGame.setX(-185);
        MenuNewGame.setY(105);
        MenuNewGame.setScaleX(0.38);
        MenuNewGame.setScaleY(0.38);
        Image gameOver1 = new Image("images/GameOver.png");
        GameOver = new ImageView(gameOver1);
        GameOver.setX(120);
        GameOver.setY(0);
        GameOver.setScaleX(1.2);
        GameOver.setScaleY(1.2);
        Image exitGame1 = new Image("images/endMenuExit.png");
        MenuExit = new ImageView(exitGame1);
        MenuExit.setX(-185);
        MenuExit.setY(170);
        MenuExit.setScaleX(0.28);
        MenuExit.setScaleY(0.28);
        
        EndScore = new Text("SCORE: " + my_score);
        EndScore.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        EndScore.setFill(Color.BLACK);
        EndScore.setX(142);
        EndScore.setY(135);
        
        Pane pane = new Pane();
        pane.getChildren().addAll(MenuNewGame,MenuExit,GameOver,EndScore);
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
            my_score = 0;
            if (player1.isAlive() && player2.isAlive()) {
                running = !running;
            } else {
                new PvPLevel();
                running = true;
            }
            updateMenu();
        });

        MenuExit.setOnMouseClicked(event -> {
            Platform.exit();
        });
    }
}
