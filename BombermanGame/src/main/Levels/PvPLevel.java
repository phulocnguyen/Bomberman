package main.Levels;

<<<<<<< Updated upstream
import main.Entities.Entity;
import main.Entities.AnimateEntities.Player1Bomb;
import main.Entities.AnimateEntities.Player2Bomb;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.*;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;
import main.Graphics.CreateEnemy;
import main.Entities.AnimateEntities.DynamicEntities.Bomber;
=======
import main.Entities.AnimateEntities.Player1Bomb;
import main.Entities.AnimateEntities.Player2Bomb;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;
import main.Graphics.CreateEnemy;
import main.Entities.AnimateEntities.DynamicEntities.PvPBomber;
>>>>>>> Stashed changes

import static main.PvPGame.player1;
import static main.PvPGame.player2;
import static main.PvPGame.enemy;
import static main.PvPGame.block;
import static main.Control.Menu.*;
<<<<<<< Updated upstream
import static main.Entities.AnimateEntities.DynamicEntities.Bomber.swapKill;
=======
import static main.Entities.AnimateEntities.DynamicEntities.PvPBomber.swap_Kill;
>>>>>>> Stashed changes
import static main.Entities.AnimateEntities.Player1Bomb.*;
import static main.Entities.AnimateEntities.Player2Bomb.*;
import static main.Utility.SoundManager.isSoundDied;
import static main.Utility.SoundManager.isSoundTitle;
import static main.Entities.Items.SpeedItem.speed;
import static main.PvPGame.*;


<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import javafx.scene.image.Image;

public class PvPLevel {
    public PvPLevel() {
<<<<<<< Updated upstream
        String path = "BombermanGame/src/res/levels/PvPmap.txt";
        enemy.clear();
        block.clear();
        swapKill = 1; 
        Player1Bomb.bomb_power = 1; 
        Player2Bomb.bomb_power = 1; 

        player2.setX(1 * Sprite.scaledSize);
        player2.setY(1 * Sprite.scaledSize);
        player2.setAlive(true);
        player1.setAlive(true);
        player1.setX(1 * Sprite.scaledSize);
        player1.setY(1 * Sprite.scaledSize);
        
        player1 = new Bomber(1, 1, Sprite.playerRight_2.getFxImage());
        player1.setAlive(true);
        player2 = new Bomber(23, 13, Sprite.playerLeft_2.getFxImage());
        player2.setAlive(true);


        new CreateMap(path);
        
        isSoundDied = false; 
        isSoundTitle = false; 
        timeNumber = 120;
        Player1Bomb.isBomb = 0;
        Player2Bomb.isBomb = 0;
        speed = 1;
=======
        String path = "BombermanGame/src/res/levels/Level2.txt";
        enemy.clear();
        block.clear();
        swap_Kill = 1; 
        Player1Bomb.bomb_power = 0; 
        Player2Bomb.bomb_power = 0; 
        try {
            new CreateMap(path);
        } catch (Exception e){}
        
        player1.setAlive(true);
        player1.setX(1 * Sprite.scaledSize);
        player1.setY(1 * Sprite.scaledSize);
        player2.setAlive(true);
        player2.setX(1 * Sprite.scaledSize);
        player2.setY(1 * Sprite.scaledSize);
        player1 = new PvPBomber(1, 1, Sprite.playerRight_2.getFxImage());
        player1.setAlive(true);
        player2 = new PvPBomber(23, 13, Sprite.playerLeft_2.getFxImage());
        player2.setAlive(true);
    
        isSoundDied = false; 
        isSoundTitle = false; 
        timeNumber = 120;
        isBomb1 = 0;
        isBomb2 = 0;
        speed = 1;

>>>>>>> Stashed changes
        player1.setImg(Sprite.playerRight_2.getFxImage());
        player2.setImg(Sprite.playerLeft_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        new CreateEnemy(path);
<<<<<<< Updated upstream
        for(DynamicEntity enemy_ : enemy) {
            enemy_.setAlive(true);
=======

        for(DynamicEntity enemies : enemy) {
            enemies.setAlive(true);
>>>>>>> Stashed changes
        }

    }
}
