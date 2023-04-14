package main.Entities.Items;

import static main.BombermanGame.*;
import main.Graphics.Sprite;
import main.Entities.Entity;

import javafx.scene.image.Image;

public class FlamePassItem extends Item {
    public FlamePassItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public FlamePassItem(boolean gained) {
        super(gained);
    }

    public FlamePassItem() {

    }

    @Override
    public void update() {

    }
}
