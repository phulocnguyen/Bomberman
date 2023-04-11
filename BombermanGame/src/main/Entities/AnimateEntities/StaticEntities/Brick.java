package main.Entities.AnimateEntities.StaticEntities;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.StaticEntities.StaticEntity;
import main.Graphics.Sprite;
import static main.BombermanGame.*;

public class Brick extends StaticEntity {
    
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    private void checkHidden() {
        for (StaticEntity entity : block) {
            if (entity instanceof Brick)
                if (listKill[entity.getX() / 32][entity.getY() / 32] == 4) {
                    entity.setImg(Sprite.Grass.getFxImage());
                }
        }
    }

    @Override
    public void update() {
        checkHidden();
    }
}
