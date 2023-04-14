package main.Entities.Items;

import javafx.scene.image.Image;
import static main.BombermanGame.*;
import main.Graphics.Sprite;
import main.Entities.Entity;

public class BombItem extends Item {
    
    public BombItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public BombItem() {

    }

    public BombItem(boolean gained) {
        super(gained);
    }

    @Override
    public void update() {
        
    }

}
