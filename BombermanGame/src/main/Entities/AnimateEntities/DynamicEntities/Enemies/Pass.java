package main.Entities.AnimateEntities.DynamicEntities.Enemies;

import main.Graphics.Sprite;
import static main.BombermanGame.*;
import main.Entities.AnimateEntities.DynamicEntities.DynamicEntity;
import javafx.scene.image.Image;
import main.Control.Move;

public class Pass extends DynamicEntity {
    private static int swapKill = 1;
    private static int countKill = 0;

    public Pass(int x, int y, Image img) {
        super(x, y, img);
    }

    public Pass(int isMove, int swap, String direction, int count, int countToRun) {
        super(4, 1, "up", 0, 0);
    }

    public Pass(boolean alive) {
        super(alive);
    }

    public Pass() {
    }

    private void killPass(DynamicEntity animal) {
        if (countKill % 16 == 0) {
            if (swapKill == 1) {
                animal.setImg(Sprite.onealDead.getFxImage());
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

    private void movePass() {
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
                if (this.y / 32 < nextY)
                    Move.down(this);
                if (this.x / 32 > nextX)
                    Move.left(this);
                if (this.x / 32 < nextX)
                    Move.right(this);
            }
        }
    }

    @Override
    public void update() {
        kill();
        countKill++;
        for (DynamicEntity animal : enemy) {
            if (animal instanceof Pass && !animal.isAlive())
                killPass(animal);
        }

        if(player.isAlive())
            movePass;
    }
}
