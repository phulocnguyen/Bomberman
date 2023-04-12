package main.Levels;

import javafx.scene.image.Image;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Ballom;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Doll;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Minvo;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;

import static main.Control.Menu.*;
import static main.Entities.AnimateEntities.DynamicEntities.Bomber.swapKill;
import static main.Utility.SoundManager.isSoundDied;
import static main.Utility.SoundManager.isSoundTitle;
import static main.Entities.Items.SpeedItem.speed;
import static main.BombermanGame.block;
import static main.BombermanGame.enemy;
import static main.BombermanGame.player;
import static main.BombermanGame.authorView;
import static main.Entities.AnimateEntities.Bomb.isBomb;


public class Level2 {
    public Level2() {
        enemy.clear();
        block.clear();
        swapKill = 1;
        new CreateMap("res/levels/Level2.txt");
        player.setAlive(true);
        player.setX(32);
        player.setY(32);
        speed = 1;
        isSoundDied = false;
        isSoundTitle = false;
        timeNumber = 120;
        bombNumber = 30;
        isBomb = 0;

        player.setImg(Sprite.playerRight_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        DynamicEntity enemy_1 = new Ballom(5, 5, Sprite.ballomLeft_1.getFxImage());
        DynamicEntity enemy_2 = new Ballom(11, 9, Sprite.ballomLeft_1.getFxImage());
        enemy.add(enemy_1);
        enemy.add(enemy_2);

        DynamicEntity enemy_3 = new Doll(1, 3, Sprite.dollRight_1.getFxImage());
        DynamicEntity enemy_4 = new Doll(1, 7, Sprite.dollRight_1.getFxImage());
        DynamicEntity enemy_5 = new Doll(1, 11, Sprite.dollRight_1.getFxImage());
        enemy.add(enemy_3);
        enemy.add(enemy_4);
        enemy.add(enemy_5);

        DynamicEntity enemy_6 = new Minvo(7, 5, Sprite.minvoRight_1.getFxImage());
        DynamicEntity enemy_7 = new Minvo(19, 7, Sprite.minvoRight_1.getFxImage());
        enemy.add(enemy_6);
        enemy.add(enemy_7);

        for(DynamicEntity _enemy : enemy) {
            _enemy.setAlive(true);
        }
    }
}