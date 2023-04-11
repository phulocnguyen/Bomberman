package main.Entities.AnimateEntities;

import main.Entities.Entity;
import java.math.*;
import javafx.scene.image.Image;

public abstract class AnimateEntity extends Entity {

    public AnimateEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public double distance(Entity e1, Entity e2) {
        return Math.sqrt(Math.pow(e1.getX() - e2.getX(), 2) + Math.pow(e1.getY() - e2.getY(), 2));
    }

}
