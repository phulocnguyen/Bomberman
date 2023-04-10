package main.Entities.AnimateEntities.StaticEntities;

import main.*;
import javafx.scene.image.Image;


public abstract class StaticEntity extends AnimateEntity {
    
    public StaticEntity(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void increaseScore() {
        score += 0;
    }
}
