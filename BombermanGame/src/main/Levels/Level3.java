package main.Levels;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Graphics.*;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Ballom;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Doll;


import static main.Control.Menu.*;
import static main.Entities.AnimateEntities.DynamicEntities.Bomber.swapKill;
import static main.Entities.AnimateEntities.Bomb.isBomb;
import static main.Utility.SoundManager.isSoundDied;
import static main.Utility.SoundManager.isSoundTitle;
import static main.Entities.Items.SpeedItem.speed;
import static main.BombermanGame.*;


public class Level3 {
    public Level3() {
        enemy.clear();
        block.clear();
        swapKill = 1;
        new CreateMap("res/levels/Level3.txt");
        player.setAlive(true);
        player.setX(32);
        player.setY(32);
        speed = 1;
        isSoundDied = false;
        isSoundTitle = false;
        timeNumber = 120;
        bombNumber = 40;
        isBomb = 0;

        player.setImg(Sprite.playerRight_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        DynamicEntity enemy1 = new Ballom(5, 5, Sprite.ballomLeft_1.getFxImage());
        DynamicEntity enemy2 = new Ballom(11, 9, Sprite.ballomLeft_1.getFxImage());
        enemy.add(enemy1);
        enemy.add(enemy2);

        DynamicEntity enemy3 = new Doll(7, 5, Sprite.dollLeft_1.getFxImage());
        enemy.add(enemy3);

        for (DynamicEntity animal : enemy) {
            animal.setAlive(true);
        }
     }
}
