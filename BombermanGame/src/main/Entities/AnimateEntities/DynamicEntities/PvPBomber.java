package main.Entities.AnimateEntities.DynamicEntities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import main.PvPGame;
import main.Entities.AnimateEntities.Bomb;
import main.Entities.AnimateEntities.DynamicEntities.Bomber;

import main.Entities.Entity;
import main.Graphics.CreatePvPMap;
import main.Graphics.Sprite;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static main.PvPGame.*;
import static main.PvPGame.player1;
import static main.PvPGame.player2;

public class PvPBomber extends DynamicEntity {

    public static int swap_Kill_pvp = 1;
    private static int count_kill = 0;
    public static int bomb_power = 0;
    private static final int MENU_START_X = 270;
    private static final int MENU_START_Y = 190;
    private long lastTime;

    // private final MenuButton ExitButton = new MenuButton("EXIT");
    // private final MenuButton RestartButton = new MenuButton("RESTART");
    private ImageView Overimg;
    private Image OverImg;
    private boolean p1;

    public PvPBomber() {

    }

    public PvPBomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public PvPBomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }

    private void killBomber(Entity entity) {
        if (count_kill % 16 == 0) {
            if (swap_Kill_pvp == 1) {
                entity.setImg(Sprite.playerDead_1.getFxImage());
                swap_Kill_pvp = 2;
            } else if (swap_Kill_pvp == 2) {
                entity.setImg(Sprite.playerDead_2.getFxImage());
                swap_Kill_pvp = 3;
            } else if (swap_Kill_pvp == 3) {
                entity.setImg(Sprite.playerDead_3.getFxImage());
                swap_Kill_pvp = 4;
            } else if (swap_Kill_pvp == 4) {
                entity.setImg(Sprite.playerDead_1.getFxImage());
                swap_Kill_pvp = 5;
            } else if (swap_Kill_pvp == 5) {
                entity.setImg(Sprite.playerDead_2.getFxImage());
                swap_Kill_pvp = 6;
            } else if (swap_Kill_pvp == 6) {
                entity.setImg(Sprite.playerDead_3.getFxImage());
                swap_Kill_pvp = 7;

            } else {
                running = false;
                Bomber.pvpDem = 1;

    //             try {
    //                 if (p1 == false) {
    //                     OverImg = new Image(new FileInputStream("res\\textures\\player2win.png"), 600, 120, false,
    //                             true);
    //                     Overimg = new ImageView(OverImg);
    //                     Overimg.setLayoutX(100);
    //                     Overimg.setLayoutY(70);
    //                 }
    //                 if (p1 == true) {
    //                     OverImg = new Image(new FileInputStream("res\\textures\\player1win.png"), 600, 120, false,
    //                             true);
    //                     Overimg = new ImageView(OverImg);
    //                     Overimg.setLayoutX(100);
    //                     Overimg.setLayoutY(70);
    //                 }
    //                 pvpRoot.getChildren().add(Overimg);
    //                 createdRestartButton();
    //                 createdExitButton();

    //             } catch (Exception e) {
    //             }
    //         }
    //     }
    // }

    // // private void addMenuButton(MenuButton button) {
    // //     pvpRoot.getChildren().add(button);
    // // }

    // // private void createdExitButton() {

    // //     addMenuButton(ExitButton);
    // //     ExitButton.setLayoutX(MENU_START_X);
    // //     ExitButton.setLayoutY(MENU_START_Y + 2 * 120 - 50);
    // //     ExitButton.setOnAction(new EventHandler<ActionEvent>() {
    //         @Override
    //         public void handle(ActionEvent actionEvent) {
    //             pvpStage.close();

    //         }
    //     });
    // }

    // // private void createdRestartButton() {

    //     addMenuButton(RestartButton);
    //     RestartButton.setLayoutX(MENU_START_X);
    //     RestartButton.setLayoutY(MENU_START_Y + 120 - 50);
    //     RestartButton.setOnAction(new EventHandler<ActionEvent>() {
    //         @Override
    //         public void handle(ActionEvent actionEvent) {
    //             Bomber.pvpDem =1;


    //             pvpRoot.getChildren().remove(Overimg);
    //             pvpRoot.getChildren().remove(RestartButton);
    //             pvpRoot.getChildren().remove(ExitButton);

    //             mainStage.show();

    //         }
    //     });
    // }

    private void checkBombs() {
        if (list_Kill[player1.getX() / 32][player1.getY() / 32 + 1] == 4)
            player1.setAlive(false);
        if (list_Kill[player2.getX() / 32][player2.getY() / 32 + 1] == 4)
            player2.setAlive(false);
    }

    @Override
    public void update() {
        // testing commit
        checkBombs();
        count_kill++;
        if (!player1.isAlive()) {
            killBomber(player1);
            p1 = false;
        }
        if (!player2.isAlive()) {
            killBomber(player2);
            p1 = true;
        }
    }
}
