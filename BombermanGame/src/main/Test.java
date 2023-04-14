package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import main.Control.Menu;
import static main.Graphics.Sprite.*;

public class Test extends Application {
    public static void main(String args[]) {
        Application.launch(Test.class, args);

    }

    public void start(Stage stage) {
        Canvas canvas = new Canvas(scaledSize * 25, scaledSize * 15);
        Group root = new Group();
        Menu.createMenu(root);
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setTitle("TEST");
        stage.setScene(scene);
        stage.show();
    }
}

// 1. chức năng qua màn
// 2. Bỏ bombNumber đổi thành Score 
// 3. Có các item, portal qua màn 
// 4. Dịch màn hình 
// 5. Giao diện menu 
