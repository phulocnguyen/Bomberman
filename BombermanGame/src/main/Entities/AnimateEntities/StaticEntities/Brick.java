package main.Entities.AnimateEntities.StaticEntities;

import javafx.scene.image.Image;
import main.Entities.Entity;
import main.Graphics.Sprite;

public class Brick extends StaticEntity {
    
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    private void checkHidden() {
        for (Entity entity : staticentities) {
            if (entity instanceof Brick) {

            }
        }
    }

    public void update() {
        checkHidden();
    }
}
