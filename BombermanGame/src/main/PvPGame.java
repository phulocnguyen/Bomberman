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
import main.Control.StartMenu;
import main.Entities.Entity;
import main.Entities.AnimateEntities.DynamicEntities.*;
import main.Entities.AnimateEntities.DynamicEntities.Bomber;
// import main.Entities.AnimateEntities.StaticEntities.Portal;
import main.Graphics.Sprite;

// import static main.Levels.NextLevel.*;
import static main.Control.Menu.*;
// import static main.Entities.AnimateEntities.StaticEntities.Portal.isPortal;
import static main.Utility.SoundManager.updateSound;
import main.Entities.AnimateEntities.Player1Bomb;
import main.Entities.AnimateEntities.Player2Bomb;



public class PvPGame extends Application {

    /**
     * The default size of the window
     * H: 480px W: 800px
     */
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;
    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;
    public static int my_score = 0;

    public static final List<Entity> block = new ArrayList<>(); //Contains fixed entities
    public static List<DynamicEntity> enemy = new ArrayList<>();       //Contains enemy entities
    public static int[][] id_Objects = new int [WIDTH][HEIGHT];    //Two-dimensional array is used to test paths
    public static int[][] list_Kill = new int [WIDTH][HEIGHT];     //Array containing dead positions
    public static Bomber player1; 
    public static Bomber player2;
    public static boolean running = true;
    public static ImageView authorView;
    public static Group rootmain;

    private GraphicsContext gc;
    private Canvas canvas;

    private int frame = 1;
    private long lastTime;

    public static Stage mainStage = null;

   
    public static void main(String[] args) {
        Application.launch(PvPGame.class);
    }

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.scaledSize * WIDTH, Sprite.scaledSize * HEIGHT);
        canvas.setTranslateY(32);
        gc = canvas.getGraphicsContext2D();
        Image author = new Image("images/author.png");
        authorView = new ImageView(author);
        authorView.setX(-240);
        authorView.setY(-113);
        authorView.setScaleX(0.625);
        authorView.setScaleY(0.625);
        rootmain = new Group();
        Menu.createMenu(rootmain);
        rootmain.getChildren().add(canvas);
        rootmain.getChildren().add(authorView);
        StartMenu.createStartMenu(rootmain);
        //EndMenu.createEndMenu(rootmain);
        
        Scene scene = new Scene(rootmain);

        scene.setOnKeyPressed(event -> {
            if (player1.isAlive()  || player2.isAlive())
                switch (event.getCode()) {
                    case UP:
                        Move.up(player1);
                        break;
                    case DOWN:
                        Move.down(player1);
                        break;
                    case LEFT:
                        Move.left(player1);
                        break;
                    case RIGHT:
                        Move.right(player1);
                        break;
                    case ENTER:
                        Player1Bomb.putBomb();
                        break;
                    case W:
                        Move.up(player2);
                        break;
                    case S:
                        Move.down(player2);
                        break;
                    case A:
                        Move.left(player2);
                        break;
                    case D:
                        Move.right(player2);
                        break;
                    case SPACE:
                        Player2Bomb.putBomb();
                        break;
                    default:
                        break;
                }
        });

        stage.setScene(scene);
        stage.setTitle("Bomberman");
        Image icon = new Image("images/app_icon.png");
        stage.getIcons().add(icon);
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

        player1 = new Bomber(1, 1, Sprite.playerRight_2.getFxImage());
        player1.setAlive(false);
        player2 = new Bomber(WIDTH - 1, HEIGHT - 1, Sprite.playerLeft_2.getFxImage());
        player2.setAlive(false);
    }

    public void update() {

        block.forEach(Entity::update);
        enemy.forEach(Entity::update);

        // player1 update
        player1.update();
        player1.setCountToRun(player1.getCountToRun() + 1);
        if (player1.getCountToRun() == 4) {
            Move.checkRun(player1);
            player1.setCountToRun(0);
        }

        // player2 update
        player2.update();
        player2.setCountToRun(player2.getCountToRun() + 1);
        if (player2.getCountToRun() == 4) {
            Move.checkRun(player2);
            player2.setCountToRun(0);
        }


        for (DynamicEntity a : enemy) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 8) {
                Move.checkRun(a);
                a.setCountToRun(0);
            }
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        enemy.forEach(g -> g.render(gc));
        block.forEach(g -> g.render(gc));
        player1.render(gc);
        player2.render(gc);
    }

    public void time() {
        frame++;
        long now = System.currentTimeMillis();
        if (now - lastTime > 1000) {
            lastTime = System.currentTimeMillis();
            mainStage.setTitle("Bomberman  " + frame + " frame");
            frame = 0;
            if(my_score < 0)
                my_score = 0;
            score.setText("Score: " + my_score);
            time.setText("Time: " + timeNumber);
            timeNumber--;
            if (timeNumber < 0)
                player1.setAlive(false);
                player2.setAlive(false);
        }
    }
 }
