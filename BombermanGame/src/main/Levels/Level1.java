package main.Levels;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Ballom;
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

public class Level1 {
    public Level1() {
        enemy.clear();
        block.clear();
        swapKill = 1; 
        bomb_power = 0; 
        new CreateMap("BombermanGame/src/res/levels/Level1.txt");
        player.setAlive(true);
        player.setX(32);
        player.setY(32);
        isSoundDied = false; 
        isSoundTitle = false; 
        timeNumber = 120;
        bombNumber = 20;
        isBomb = 0;
        speed = 1;

        player.setImg(Sprite.playerRight_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        DynamicEntity enemy_1 = new Ballom(4, 4, Sprite.ballomLeft_1.getFxImage());
        DynamicEntity enemy_2 = new Ballom(9, 9, Sprite.ballomLeft_1.getFxImage());
        DynamicEntity enemy_3 = new Ballom(22, 6, Sprite.ballomLeft_1.getFxImage());

        enemy.add(enemy_1);
        enemy.add(enemy_2);
        enemy.add(enemy_3);

        for(DynamicEntity enemy_ : enemy) {
            enemy_.setAlive(true);
        }

    }
}