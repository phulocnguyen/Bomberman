package main.Levels;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Graphics.CreateEnemy;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;

import static main.Control.Menu.*;
import static main.Entities.AnimateEntities.DynamicEntities.Bomber.swapKill;
import static main.Entities.AnimateEntities.Bomb.bomb_power;
import static main.Entities.AnimateEntities.Bomb.isBomb;
import static main.Utility.SoundManager.isSoundDied;
import static main.Utility.SoundManager.isSoundTitle;
import static main.Entities.Items.SpeedItem.speed;
import static main.BombermanGame.*;

public class nowLevel {
    public nowLevel(int now_level) {
        String path = "BombermanGame/src/res/levels/Level" + now_level + ".txt";
        enemy.clear();
        block.clear();
        swapKill = 1; 
        bomb_power = 0; 
        new CreateMap(path);
        player.setAlive(true);
        player.setX(1 * Sprite.scaledSize);
        player.setY(1 * Sprite.scaledSize);
        isSoundDied = false; 
        isSoundTitle = false; 
        timeNumber = 120;
        isBomb = 0;
        speed = 1;

        player.setImg(Sprite.playerRight_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        new CreateEnemy(path);
        for(DynamicEntity enemy_ : enemy) {
            enemy_.setAlive(true);
        }

    }
}