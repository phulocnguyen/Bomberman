package main.Entities.Items;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.Player1Bomb;
import main.Entities.AnimateEntities.Player2Bomb;
import static main.PvPGame.*;
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
            if (player1.getX() == this.x && player1.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.gained = true;
                Player1Bomb.bomb_power += 2;
            }
            if (!this.gained)
            if (player2.getX() == this.x && player2.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.gained = true;
                Player2Bomb.bomb_power += 2;
            }
    }

}
