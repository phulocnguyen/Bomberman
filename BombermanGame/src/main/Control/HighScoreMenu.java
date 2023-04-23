package main.Control;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static main.Control.Menu.*;
import static main.BombermanGame.*;

public class HighScoreMenu {
    public static Text title;
    public static Text top1;
    public static Text top2;
    public static Text top3;
    public static Text top4;
    public static Text top5;
    public static Text exit;

    public static void createHighScoreMenu(Group root) {
        title = new Text("HIGH SCORE");
        title.setFont(Font.font("Time New Roman", FontWeight.EXTRA_BOLD, 25));
        title.setFill(Color.RED);
        title.setX(30);
        title.setY(60);

        String s;
        s = "Top 1: " + gamehighscore.getHighScoreSt(0);
        top1 = new Text(s);
        top1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        top1.setFill(Color.YELLOW);
        top1.setX(30);
        top1.setY(110);

        s = "Top 2: " + gamehighscore.getHighScoreSt(1);
        top2 = new Text(s);
        top2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        top2.setFill(Color.WHITE);
        top2.setX(30);
        top2.setY(140);

        s = "Top 3: " + gamehighscore.getHighScoreSt(2);
        top3 = new Text(s);
        top3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        top3.setFill(Color.WHITE);
        top3.setX(30);
        top3.setY(170);

        s = "Top 4: " + gamehighscore.getHighScoreSt(3);
        top4 = new Text(s);
        top4.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        top4.setFill(Color.WHITE);
        top4.setX(30);
        top4.setY(200);

        s = "Top 5: " + gamehighscore.getHighScoreSt(4);
        top5 = new Text(s);
        top5.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        top5.setFill(Color.WHITE);
        top5.setX(30);
        top5.setY(230);

        exit = new Text("Exit");
        exit.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        exit.setFill(Color.BLACK);
        exit.setX(180);
        exit.setY(270);

        Pane pane1 = new Pane();
        pane1.setMinSize(400, 300);
        pane1.setMaxSize(400, 300);
        pane1.setLayoutX(10);
        pane1.setLayoutY(200);
        pane1.setStyle("-fx-background-color: rgba(255, 255, 255, 0);");

        Pane pane = new Pane();
        pane.getChildren().addAll(title, top1, top2, top3, top4, top5, exit);
        pane.setMinSize(400, 300);
        pane.setMaxSize(400, 300);
        pane.setLayoutX(200);
        pane.setLayoutY(110);
        pane.setStyle("-fx-background-color: #679289; -fx-background-radius: 20;"); // đặt độ cong cho pane

        root.getChildren().addAll(pane1, pane);

        exit.setOnMouseClicked(event -> {
            root.getChildren().remove(pane);
            root.getChildren().remove(pane1);
        });
    }
}
