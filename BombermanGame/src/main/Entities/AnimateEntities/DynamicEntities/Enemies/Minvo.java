package main.Entities.AnimateEntities.DynamicEntities.Enemies;

import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import main.Entities.AnimateEntities.DynamicEntities.Enemies.AI.*;
import javafx.scene.image.Image;
import main.Graphics.Sprite;
import main.Control.Move;

import static main.BombermanGame.*;

import java.util.List;
import java.util.Random;

public class Minvo extends DynamicEntity {
    private static int swapKill = 1;
    private static int countKill = 0;

    public Minvo(int x, int y, Image img) {
        super(x, y, img);
    }

    public Minvo(int isMove, int swap, String direction, int count, int countToRun) {
        super(4, 1, "up", 0, 0);
    }

    public Minvo(boolean alive) {
        super(alive);
    }

    public Minvo() {
    }

    private void killMinvo(DynamicEntity animal) {
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                my_score += 800;
                animal.setImg(Sprite.minvoDead.getFxImage());
                swapKill = 2;
            } else if (swapKill == 2) {
                animal.setImg(Sprite.playerDead_3.getFxImage());
                swapKill = 3;
            } else {
                animal.setAlive(false);
                enemy.remove(animal);
                swapKill = 1;
            }
        }
    }

    private void moveMinvo() {
        if (this.x % 32 == 0 && this.y % 32 == 0) {
            Node initialNode = new Node(this.y / 32, this.x / 32);
            Node finalNode = new Node(player.getY() / 32, player.getX() / 32);

            int rows = _height;
            int cols = _width;

            AStar aStar = new AStar(rows, cols, initialNode, finalNode);

            int[][] blocksArray = new int[_width * _height][2];
            int countBlock = 0;

            for (int i = 0; i < _height; i++)
                for (int j = 0; j < _width; j++)
                    if (id_Objects[j][i] != 0) {
                        blocksArray[countBlock][0] = i;
                        blocksArray[countBlock][1] = j;
                        countBlock++;
                    }

            aStar.set_Block(blocksArray, countBlock);
            List<Node> path = aStar.find_Path();
            if (path.size() != 0) {
                int nextY = path.get(1).get_row();
                int nextX = path.get(1).get_col();

                if (this.y / 32 > nextY)
                    Move.up(this);  
                else if (this.y / 32 < nextY)
                    Move.down(this);
                if (this.x / 32 > nextX)
                    Move.left(this);
                else if (this.x / 32 < nextX)
                    Move.right(this);
                
            }
        }
    }

    @Override
    public void update() {
        kill();
        countKill++;
        for (DynamicEntity animal : enemy) {
            if (animal instanceof Minvo && !animal.isAlive())
                killMinvo(animal);
        }

        int scopeX = Math.abs(this.getX() / 32 - player.getX() / 32);
        int scopeY = Math.abs(this.getY() / 32 - player.getY() / 32);
        if (player.isAlive() && this.x % 16 == 0 && this.y % 16 == 0) {
            if (scopeX <= 6 && scopeY <= 6)
                moveMinvo();
            else {
                Random random = new Random();
                int dir = random.nextInt(4);
                switch (dir) {
                    case 0:
                        Move.down(this);
                        break;
                    case 1:
                        Move.up(this);
                        break;
                    case 2:
                        Move.left(this);
                        break;
                    case 3:
                        Move.right(this);
                        break;
                }
            }
        }
    }
    
}
