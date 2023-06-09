package main.Entities.AnimateEntities.DynamicEntities;

import javafx.scene.image.Image;
import main.Control.EndMenu;
import main.Graphics.Sprite;

import static main.BombermanGame.*;

public class Bomber extends DynamicEntity {
    public static int swapKill = 1;
    private static int countKill = 0;

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomber() {

    }

    public Bomber(int isMove, int swap, String direction, int count, int countToRun) {
        super(8, 1, "down", 0, 0);
    }

    private void killBomber(DynamicEntity de) {
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                de.setImg(Sprite.playerDead_1.getFxImage());
                swapKill = 2;
            } else if (swapKill == 2) {
                de.setImg(Sprite.playerDead_2.getFxImage());
                swapKill = 3;
            } else if (swapKill == 3) {
                de.setImg(Sprite.playerDead_3.getFxImage());
                swapKill = 4;
            } else {
                de.setImg(Sprite.transparent.getFxImage());
                running = false;
                Image gameOver = new Image("images/transparent.png");
                authorView.setImage(gameOver);
                EndMenu.createEndMenu(rootmain);
            }
        }
    }

    private void checkBomb() {
        if (list_Kill[player.getX() / 32][player.getY() / 32] == 4)
            player.setAlive(false);
    }

    private void check(int x) {
        switch(x) {
            case 1:
                checkEnemy();
                break;
            case 2:
                checkEnemy2();
                break;
            case 3:
                checkEnemy3();
                break;
            
        }
    }

    private void checkEnemy() {
        int ax = player.getX() / 32;
        int ay = player.getY() / 32;
        for (DynamicEntity de : enemy) {
            int bx = de.getX() / 32;
            int by = de.getY() / 32;
            if (ax == bx && ay == by
                    || ax == bx && ay == by + 1 || ax == bx && ay == by - 1
                    || ay == by && ax == bx + 1 || ay == by && ax == bx - 1) {
                player.alive = false;
                break;
            }
        }
    }

    private void checkEnemy2() {    //easy level
        int ax = player.getX();
        int ay = player.getY();
        for (DynamicEntity de : enemy)
            if (ax == de.getX() && ay == de.getY()
                    || ax == de.getX() && ay == de.getY() - 32
                    || ax == de.getX() && ay == de.getY() + 32
                    || ay == de.getY() && ax == de.getX() - 32
                    || ay == de.getY() && ax == de.getX() + 32) {
                player.alive = false;
                break;
            }
    }

    private void checkEnemy3() {
        int ax = player.getX();
        int ay = player.getY();
        for (DynamicEntity de : enemy) {
            int bx = de.getX();
            int by = de.getY();
            if (ax == bx && by - 32 <= ay && by + 32 >= ay
                    || ay == by && bx - 32 <= ax && bx + 32 >= ax) {
                player.alive = false;
                break;
            }
        }
    }

    @Override
    public void update() {
        checkBomb();
        check(3);
        countKill++;
        if (!player.isAlive())
            killBomber(player);
    }
}
