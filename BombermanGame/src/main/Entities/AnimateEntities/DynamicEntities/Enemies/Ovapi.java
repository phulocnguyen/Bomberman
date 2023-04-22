package main.Entities.AnimateEntities.DynamicEntities.Enemies;

import main.Graphics.Sprite;
import static main.PvPGame.*;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import javafx.scene.image.Image;
import main.Control.Move;

public class Ovapi extends DynamicEntity {
    private static int swapKill = 1;
    private static int countKill = 0;

    public Ovapi(int x, int y, Image img) {
        super(x, y, img);
    }

    public Ovapi(int isMove, int swap, String direction, int count, int countToRun) {
        super(4, 1, "up", 0, 0);
    }

    public Ovapi(boolean alive) {
        super(alive);
    }

    public Ovapi() {
    }

    private void killOvapi(DynamicEntity animal) {
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                my_score += 1000;
                animal.setImg(Sprite.ovapiDead.getFxImage());
                swapKill = 2;
            } else if (swapKill == 2) {
                animal.setImg(Sprite.playerDead_3.getFxImage());
                swapKill = 3;
            } else {
                animal.setAlive(false);
                enemy.remove(animal);
                swapKill = 1;
            }
        }
    }

    @Override
    public void update() {
        kill();
        countKill++;
        for (DynamicEntity animal : enemy) {
            if (animal instanceof Ovapi && !animal.isAlive())
                killOvapi(animal);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (player2.getX() < this.x) {
                Move.left(this);
            }
            if (player2.getX() > this.x) {
                Move.right(this);
            }
            if (player2.getY() > this.y) {
                Move.down(this);
            }
            if (player2.getY() < this.y) {
                Move.up(this);
            }
        }
    }
}
