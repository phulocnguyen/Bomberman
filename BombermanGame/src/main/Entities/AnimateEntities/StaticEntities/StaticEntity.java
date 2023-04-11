package main.Entities.AnimateEntities.StaticEntities;

import main.Entities.AnimateEntities.AnimateEntity;
import javafx.scene.image.Image;


public abstract class StaticEntity extends AnimateEntity {
    
    public StaticEntity(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        
    }
}
