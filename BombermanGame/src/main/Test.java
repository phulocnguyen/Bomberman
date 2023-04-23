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
<<<<<<< Updated upstream
import main.Entities.AnimateEntities.DynamicEntities.Bomber;
import main.Entities.AnimateEntities.StaticEntities.Portal;
=======
import main.Entities.AnimateEntities.DynamicEntities.PvPBomber;
>>>>>>> Stashed changes
import main.Graphics.Sprite;

// import static main.Levels.NextLevel.*;
import static main.Control.Menu.*;
<<<<<<< Updated upstream
import static main.Entities.AnimateEntities.StaticEntities.Portal.isPortal;
=======
>>>>>>> Stashed changes
import static main.Utility.SoundManager.updateSound;
import main.Entities.AnimateEntities.Player1Bomb;
import main.Entities.AnimateEntities.Player2Bomb;



public class Test extends Application {

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

    public static final List<Entity> stillObjectsPvP = new ArrayList<>(); //Contains fixed entities
    public static List<DynamicEntity> enemy = new ArrayList<>();       //Contains enemy entities
    public static int[][] id_Objects;    //Two-dimensional array is used to test paths
    public static int[][] list_Kill;     //Array containing dead positions
    public static DynamicEntity player1;
    public static DynamicEntity player2;
    public static boolean running;
    public static ImageView authorView;
    public static Group rootmain;

    private GraphicsContext gc;
    private Canvas canvas;

    private int frame = 1;
    private long lastTime;

    public static Stage mainStage = null;

    // public static void main(String[] args) {
    //     Application.launch(BombermanGame.class);
    // }
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
            if (player1.isAlive() && running)
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
                    default:
                        break;
                }
                if (player2.isAlive() && running)
                switch (event.getCode()) {
                    case W:
                        Move.up(player1);
                        break;
                    case S:
                        Move.down(player1);
                        break;
                    case A:
                        Move.left(player1);
                        break;
                    case D:
                        Move.right(player1);
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

<<<<<<< Updated upstream
        player1 = new Bomber(1, 1, Sprite.playerRight_2.getFxImage());
        player1.setAlive(false);
        player2 = new Bomber(WIDTH - 2, HEIGHT - 4, Sprite.playerLeft.getFxImage());
=======
        player1 = new PvPBomber(1, 1, Sprite.playerRight_2.getFxImage());
        player1.setAlive(false);
        player2 = new PvPBomber(WIDTH - 2, HEIGHT - 2, Sprite.playerLeft.getFxImage());
>>>>>>> Stashed changes
        player2.setAlive(false);
    }

    public void update() {


        // enemy update
        for (int i = 0; i < enemy.size(); ++i) {
            enemy.get(i).update();
        }

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

        // objects update
        for (int i = 0; i < stillObjectsPvP.size(); ++i) {
            stillObjectsPvP.get(i).update();
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
        stillObjectsPvP.forEach(g -> g.render(gc));
        player1.render(gc);
        player2.render(gc);
    }

    public void time() {
        frame++;

        long now = System.currentTimeMillis();
        if (now - lastTime > 1000) {
            lastTime = System.currentTimeMillis();
            mainStage.setTitle("Bomberman | " + frame + " frame");
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
