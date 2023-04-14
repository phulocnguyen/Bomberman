package main.Entities.Items;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.Bomb;
import static main.BombermanGame.*;
import main.Graphics.Sprite;
import main.Entities.Entity;

public class FlameItem extends Item {
    
    public FlameItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public FlameItem() {
        
    }

    public FlameItem(boolean gained) {
        super(gained);
    }

    @Override
    public void update() {
        for (Entity entity : block)
            if (entity instanceof FlameItem && !this.gained)
                if (list_Kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerupFlames.getFxImage());

        if (!this.gained)
            if (player.getX() == this.x && player.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.gained = true;
                Bomb.bomb_power += 2;
            }
    }

}
