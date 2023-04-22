package main.Entities.AnimateEntities.StaticEntities;

import javafx.scene.image.Image;
import main.Entities.Entity;
import main.Graphics.Sprite;
import static main.PvPGame.*;


public class Brick extends Entity {
    
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    private void checkHidden() {
        for (Entity entity : block) {
            if (entity instanceof Brick)
                if (list_Kill[entity.getX() / 32][entity.getY() / 32] == 4) {
                    entity.setImg(Sprite.grass.getFxImage());
                }
        }
    }

    @Override
    public void update() {
        checkHidden();
    }
}
