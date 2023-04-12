package main.Entities.AnimateEntities.DynamicEntities;

import javafx.scene.image.Image;
import main.Entities.*;

public abstract class DynamicEntity extends Entity {
    protected int swap;
    protected int isMove;
    protected String direction;
    protected int count;
    protected int countToRun;
    protected boolean alive;

    public DynamicEntity(int x, int y, Image img) {
        super(x, y, img);
    }

    public DynamicEntity() {

    }

    public DynamicEntity(int isMove, int swap, String direction, int count, int countToRun) {
        this.isMove = isMove;
        this.swap = swap;
        this.direction = direction;
        this.count = count;
        this.countToRun = countToRun;
    }

    public DynamicEntity(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getIsMove() {
        return isMove;
    }

    public void setIsMove(int isMove) {
        this.isMove = isMove;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountToRun() {
        return countToRun;
    }

    public void setCountToRun(int countToRun) {
        this.countToRun = countToRun;
    }

    @Override
    public void update() {

    }

}
