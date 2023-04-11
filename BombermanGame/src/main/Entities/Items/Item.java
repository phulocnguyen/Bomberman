package main.Entities.Items;

import javafx.scene.image.Image;
import main.Entities.Entity;

public abstract class Item extends Entity {

    protected boolean gained = false;

    public Item(int x, int y, Image img) {
        super(x, y, img);
    }

    public Item() {

    }

    public boolean isGained() {
        return gained;
    }

    public void setGained(boolean gained) {
        this.gained = gained;
    }

    @Override
    public void update() {

    }
}
