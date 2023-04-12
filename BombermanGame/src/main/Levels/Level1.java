package main.Levels;

import com.sun.prism.shader.Solid_TextureFirstPassLCD_AlphaTest_Loader;
import javafx.scene.image.Image;
import main.Entities.AnimateEntities.*;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Balloon;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.Enemy;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;

import static main.BombermanGame.*;
import main.*;
public class Level1 {
    public Level1() {
        _enemy.clear();
        bLock.clear();
        swap_kill = 1; //xuat hien o animal
        power_bomb = 0; // chua biet o dau
        new CreateMap("res/levels/Level1.txt");
        _player.setLife(true);//trong bomberman
        _player.setX(32);
        _player.setY(32);
        is_SoundDied = false; //chua tim thay
        is_SoundTitle = false; //chua tim thay
        time_Number = 120;//nt
        bomb_Number = 20;//nt
        is_Bomb = 0;//bomb.java
        speed = 1;

        _player.setImg(Sprite.playerRight_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        authorView.setImage(transparent);

        Enemy enemy_1 = new Balloon(4, 4, Sprite.ballomLeft_1.getFxImage());
        Enemy enemy_2 = new Balloon(9, 9, Sprite.ballomLeft_1.getFxImage());
        Enemy enemy_3 = new Balloon(22, 6, Sprite.ballomLeft_1.getFxImage());

        _enemy.add(enemy_1);
        _enemy.add(enemy_2);
        _enemy.add(enemy_3);

        for(Enemy enemy_ : _enemy) {
            enemy_.setLife(true);
        }

    }
}
