package main.Levels;

import main.Entities.AnimateEntities.Bomb;
import main.Entities.Entity;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.*;
import main.Graphics.CreatePvPMap;
import main.Graphics.Sprite;
import main.Graphics.CreateEnemy;

import static main.PvPGame.player1;
import static main.PvPGame.player2;
import static main.PvPGame.enemy;
import static main.PvPGame.block;
import static main.Control.Menu.*;
import static main.Entities.AnimateEntities.DynamicEntities.Bomber.swapKill;
import static main.Entities.AnimateEntities.Bomb.bomb_power;
import static main.Entities.AnimateEntities.Bomb.isBomb;
import static main.Utility.SoundManager.isSoundDied;
import static main.Utility.SoundManager.isSoundTitle;
import static main.Entities.Items.SpeedItem.speed;
import static main.PvPGame.*;


import javafx.scene.image.Image;

public class PvPLevel {
    public PvPLevel() {
        String path = "BombermanGame/src/res/levels/PvPMap.txt";
        enemy.clear();
        block.clear();
        swapKill = 1; 
        bomb_power = 0; 
        new CreatePvPMap(path);
        player1.setAlive(true);
        player1.setX(1 * Sprite.scaledSize);
        player1.setY(1 * Sprite.scaledSize);
        player2.setAlive(true);
        player2.setX(1 * Sprite.scaledSize);
        player2.setY(1 * Sprite.scaledSize);
        isSoundDied = false; 
        isSoundTitle = false; 
        timeNumber = 120;
        isBomb = 0;
        speed = 1;
        player1.setImg(Sprite.playerRight_2.getFxImage());
        player2.setImg(Sprite.playerLeft_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        new CreateEnemy(path);
        for(DynamicEntity enemy_ : enemy) {
            enemy_.setAlive(true);
        }

    }
}
