package main.Entities.AnimateEntities.StaticEntities;

import javafx.scene.image.Image;
import main.Entities.Entity;

public class Portal extends Entity {
    
    public static boolean isPortal = false;

    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        
    }

}
