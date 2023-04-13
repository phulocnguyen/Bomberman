package main.Entities.AnimateEntities.DynamicEntities.Enemies;

import main.Graphics.Sprite;
import static main.BombermanGame.*;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import javafx.scene.image.Image;
import main.Control.Move;

public class Kondoria extends DynamicEntity {

    private static int swapKill = 1;
    private static int countKill = 0;
    private static boolean dir;

    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }

    public Kondoria(int isMove, int swap, String direction, int count, int countToRun) {
        super(4, 1, "up", 0, 0);
    }

    public Kondoria(boolean alive) {
        super(alive);
    }

    public Kondoria() {
    }

    private void killKondoria(DynamicEntity animal) {
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                animal.setImg(Sprite.kondoriaDead.getFxImage());
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
        countKill++;
        for (DynamicEntity animal : enemy) {
            if (animal instanceof Kondoria && !animal.isAlive())
                killKondoria(animal);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (this.x / 32 <= 1 || this.x / 32 >= _width - 2)
                dir = !dir;

            if (dir)
                Move.left(this);
            else
                Move.right(this);
        }
    }
}
