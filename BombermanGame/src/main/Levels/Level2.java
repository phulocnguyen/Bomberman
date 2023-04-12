package main.Levels;

import javafx.scene.image.Image;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;
import main.Graphics.CreateMap;
import main.Graphics.Sprite;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.*;

import static main.BombermanGame.*;
import static main.Control.*;

public class Level2 {
    _enemy.clear();
    block.clear();
    swap_kill = 1;
    new CreateMap("res/levels/Level2.txt");
    _player.setLife(32);
    _player.setX(32);
    _player.setY(32);
    speed = 1;
    is_SoundDied = false;
    is_SoundTitle = false;
    time_Number = 120;
    bomb_Number = 30;
    is_Bomb = 0;

    _player.setImg(Sprite.playerRight_2.getFxImage());
    Image transparent = new Image("images/transparent.png");
    authorView.setImage(transparent);

    Enemy enemy_1 = new Balloon(5, 5, Sprite.ballomLeft_1.getFxImage());
    Enemy enemy_2 = new Balloon(11, 9, Sprite.ballomLeft_1.getFxImage());
    _enemy.add(enemy_1);
    _enemy.add(enemy_2);

    Enemy enemy_3 = new Doll(1, 3, Sprite.dollRight_1.getFxImage());
    Enemy enemy_4 = new Doll(1, 7, Sprite.dollRight_1.getFxImage());
    Enemy enemy_5 = new Doll(1, 11, Sprite.dollRight_1.getFxImage());
    _ennemy.add(enemy3);
    _ennemy.add(enemy4);
    _ennemy.add(enemy5);

    Enemy enemy_6 = new Minvo(7, 5, Sprite.minvoRight_1.getFxImage());
    Enemy enemy_7 = new Minvo(19, 7, Sprite.minvoRight_1.getFxImage());
    _ennemy.add(enemy6);
    _ennemy.add(enemy7);

    for(Enemy enemy : _enemy) {
        enemy.setLife(true);
    }
}
