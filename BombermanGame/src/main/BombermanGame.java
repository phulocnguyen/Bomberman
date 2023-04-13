package main;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import main.Control.Menu;
import main.Control.Move;
import main.Entities.Entity;
import main.Entities.AnimateEntities.DynamicEntities.*;
import main.Entities.AnimateEntities.DynamicEntities.Bomber;
import main.Entities.AnimateEntities.StaticEntities.Portal;
import main.Entities.AnimateEntities.Bomb;
import main.Graphics.Sprite;

import static main.Levels.NextLevel.*;
import static main.Control.Menu.*;
import static main.Entities.AnimateEntities.StaticEntities.Portal.isPortal;
import static main.Utility.SoundManager.updateSound;



public class BombermanGame extends Application {

    /**
     * The default size of the window
     * H: 480px W: 800px
     */
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;
    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;

    public static final List<Entity> block = new ArrayList<>(); //Contains fixed entities
    public static List<DynamicEntity> enemy = new ArrayList<>();       //Contains enemy entities
    public static int[][] id_Objects = new int[WIDTH][HEIGHT];    //Two-dimensional array is used to test paths
    public static int[][] list_Kill = new int[WIDTH][HEIGHT];     //Array containing dead positions
    public static DynamicEntity player;
    public static boolean running;
    public static ImageView authorView;

    private GraphicsContext gc;
    private Canvas canvas;

    private int frame = 1;
    private long lastTime;

    public static Stage mainStage = null;


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.scaledSize * WIDTH, Sprite.scaledSize * HEIGHT);
        canvas.setTranslateY(32);
        gc = canvas.getGraphicsContext2D();
        Image author = new Image("images/author.png");
        authorView = new ImageView(author);
        authorView.setX(-400);
        authorView.setY(-208);
        authorView.setScaleX(0.5);
        authorView.setScaleY(0.5);
        Group root = new Group();
        Menu.createMenu(root);
        root.getChildren().add(canvas);
        //root.getChildren().add(authorView);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            if (player.isAlive())
                switch (event.getCode()) {
                    case UP:
                        Move.up(player);
                        break;
                    case DOWN:
                        Move.down(player);
                        break;
                    case LEFT:
                        Move.left(player);
                        break;
                    case RIGHT:
                        Move.right(player);
                        break;
                    case SPACE:
                        Bomb.putBomb();
                        break;
                }
        });

        stage.setScene(scene);
        stage.setTitle("Bomberman");
        Image icon = new Image("images/ttsalpha4.0@0.5x.png");
        //stage.getIcons().add(icon);
        mainStage = stage;
        mainStage.show();

        lastTime = System.currentTimeMillis();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                if (running) {
                    render();
                    update();
                    time();
                    updateMenu();
                }
            }
        };
        timer.start();

        player = new Bomber(1, 1, Sprite.playerRight_2.getFxImage());
        player.setAlive(false);
    }

    public void update() {
        block.forEach(Entity::update);
        enemy.forEach(Entity::update);
        player.update();

        player.setCountToRun(player.getCountToRun() + 1);
        if (player.getCountToRun() == 4) {
            Move.checkRun(player);
            player.setCountToRun(0);
        }

        for (DynamicEntity a : enemy) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 8) {
                Move.checkRun(a);
                a.setCountToRun(0);
            }
        }

        if (enemy.size() == 0 && !isPortal && !wait) {
            Entity portal = new Portal(_width - 2, _height - 2, Sprite.portal.getFxImage());
            block.add(portal);
            if (player.getX() / 32 == portal.getX() / 32 && player.getY() / 32 == portal.getY() / 32) {
                wait = true;
                waitingTime = System.currentTimeMillis();
            }
        }
        waitToLevelUp();
        updateSound();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
        player.render(gc);
    }

    public void time() {
        frame++;

        long now = System.currentTimeMillis();
        if (now - lastTime > 1000) {
            lastTime = System.currentTimeMillis();
            mainStage.setTitle("Bomberman from Son Tran | " + frame + " frame");
            frame = 0;

            time.setText("Time: " + timeNumber);
            timeNumber--;
            if (timeNumber < 0)
                player.setAlive(false);
        }
    }
}
