package main.Entities.Items;

import static main.BombermanGame.*;
import main.Graphics.Sprite;
import main.Entities.Entity;


import javafx.scene.image.Image;


public class SpeedItem extends Item {
    public static int speed = 1;

    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public SpeedItem() {

    }

    public SpeedItem(boolean gained) {
        super(gained);
    }

    @Override
    public void update() {
        for (Entity entity : block)
            if (entity instanceof SpeedItem && !this.gained)
                if (list_Kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerupSpeed.getFxImage());

        if (!this.gained)
            if (player.getX() == this.x && player.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.gained = true;
                speed = 2;
            }
    }
}
