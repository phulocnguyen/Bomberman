package main.Entities.AnimateEntities.DynamicEntities.Enemies;

import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import javafx.scene.image.Image;
import main.Graphics.Sprite;
import main.Control.Move;

import static main.BombermanGame.player;
import static main.BombermanGame.enemy;

public class Minvo extends DynamicEntity {
    private static int swapKill = 1;
    private static int countKill = 0;

    public Minvo(int x, int y, Image img) {
        super(x, y, img);
    }

    public Minvo(int isMove, int swap, String direction, int count, int countToRun) {
        super(4, 1, "up", 0, 0);
    }

    public Minvo(boolean alive) {
        super(alive);
    }

    public Minvo() {
    }

    private void killMinvo(DynamicEntity animal) {
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                animal.setImg(Sprite.onealDead.getFxImage());
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
            if (animal instanceof Oneal && !animal.isAlive())
                killMinvo(animal);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (player.getX() < this.x) {
                Move.left(this);
            }
            if (player.getX() > this.x) {
                Move.right(this);
            }
            if (player.getY() > this.y) {
                Move.down(this);
            }
            if (player.getY() < this.y) {
                Move.up(this);
            }
        }
    }
    
}
