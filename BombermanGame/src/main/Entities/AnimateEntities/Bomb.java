package main.Entities.AnimateEntities;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import main.Control.*;
import main.Entities.Entity;
import main.Graphics.Sprite;
import static main.BombermanGame.*;
import static main.Control.Menu.*;
import static main.Utility.SoundManager.*;

public class Bomb extends Entity {
    private static double bombTime;
    private static double tmpTime;
    private static Entity bomb;
    private static int swapActive = 1;
    private static int swapExplosion = 1;

    public static int bomb_power = 0;

    private static final List<Entity> list = new ArrayList<>();
    private static final List<Entity> list1 = new ArrayList<>();


    private static int bombUp_power = 0;
    private static int bombDown_power = 0;
    private static int bombLeft_power = 0;
    private static int bombRight_power = 0;

    private static Entity edgeDown = null;
    private static Entity edgeUp = null;
    private static Entity edgeRight = null;
    private static Entity edgeLeft = null;
    
    private static boolean isEdge = false;
    private static boolean isMiddle = false;

    public static int isBomb = 0; // 0 no bomb , 1 has bomb, 2 exploded

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void putBomb() {
        if (isBomb == 0 && bombNumber > 0) {
            bombNumber--;
            isBomb = 1;
            bombTime = System.currentTimeMillis();
            tmpTime = bombTime;
            int x = player.getX() / 32;
            int y = player.getY() / 32;
            x = Math.round(x);
            y = Math.round(y);
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            block.add(bomb);
            id_Objects[player.getX() / 32][player.getY() / 32] = 4;
        }
    }

    public static void activateBomb() {
        if (swapActive == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swapActive = 2;
        } else if (swapActive == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swapActive = 3;
        } else if (swapActive == 3) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            swapActive = 4;
        } else {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swapActive = 1;
        }
    }

    public static void createEdge() {
        if (Blocked.block_down_bomb(bomb, 0)) {
            edgeDown = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + 1,
                    Sprite.bombExploded.getFxImage());
            if (bomb_power > 0)
                for (int i = 1; i <= bomb_power; i++)
                    if (Blocked.block_down_bomb(bomb, i)) {
                        edgeDown.setY(bomb.getY() + 32 + i * 32);
                        bombDown_power++;
                    } else break;
            block.add(edgeDown);
        }
        if (Blocked.block_up_bomb(bomb, 0)) {
            edgeUp = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - 1,
                    Sprite.bombExploded.getFxImage());
            if (bomb_power > 0)
                for (int i = 1; i <= bomb_power; i++)
                    if (Blocked.block_up_bomb(bomb, i)) {
                        edgeUp.setY(bomb.getY() - 32 - i * 32);
                        bombUp_power++;
                    } else break;
            block.add(edgeUp);
        }
        if (Blocked.block_left_bomb(bomb, 0)) {
            edgeLeft = new Bomb(bomb.getX() / 32 - 1, bomb.getY() / 32,
                    Sprite.bombExploded.getFxImage());
            if (bomb_power > 0)
                for (int i = 1; i <= bomb_power; i++)
                    if (Blocked.block_left_bomb(bomb, i)) {
                        edgeLeft.setX(bomb.getX() - 32 - i * 32);
                        bombLeft_power++;
                    } else break;
            block.add(edgeLeft);
        }
        if (Blocked.block_right_bomb(bomb, 0)) {
            edgeRight = new Bomb(bomb.getX() / 32 + 1, bomb.getY() / 32,
                    Sprite.bombExploded.getFxImage());
            if (bomb_power > 0)
                for (int i = 1; i <= bomb_power; i++)
                    if (Blocked.block_right_bomb(bomb, i)) {
                        edgeRight.setX(bomb.getX() + 32 + i * 32);
                        bombRight_power++;
                    } else break;
            block.add(edgeRight);
        }
    }

    public static void createMiddle() {
        Entity middle;
        for (int i = 1; i <= bombDown_power; i++) {
            middle = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + i,
                    Sprite.bombExploded.getFxImage());
            list1.add(middle);
        }
        for (int i = 1; i <= bombUp_power; i++) {
            middle = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - i,
                    Sprite.bombExploded.getFxImage());
            list1.add(middle);
        }
        for (int i = 1; i <= bombLeft_power; i++) {
            middle = new Bomb(bomb.getX() / 32 - i, bomb.getY() / 32,
                    Sprite.bombExploded.getFxImage());
            list.add(middle);
        }
        for (int i = 1; i <= bombRight_power; i++) {
            middle = new Bomb(bomb.getX() / 32 + i, bomb.getY() / 32,
                    Sprite.bombExploded.getFxImage());
            list.add(middle);
        }
        block.addAll(list1);
        block.addAll(list);
    }

    private static void checkActive() {
        if (isBomb == 1) {
            if (System.currentTimeMillis() - bombTime < 2000) {
                if (System.currentTimeMillis() - tmpTime > 100) {
                    activateBomb();
                    tmpTime += 100;
                }
            } else {
                isBomb = 2;
                bombTime = System.currentTimeMillis();
                tmpTime = bombTime;
            }
        }
    }

    public static void explodeCenter() {
        if (swapExplosion == 1) {
            bomb.setImg(Sprite.bombExploded.getFxImage());
            list_Kill[bomb.getX() / 32][bomb.getY() / 32] = 4;
            if (Blocked.block_down_bomb(bomb, bombDown_power)) {
                edgeDown.setImg(Sprite.explosionVerticalDownLast.getFxImage());
                list_Kill[edgeDown.getX() / 32][edgeDown.getY() / 32] = 4;
            }
            if (Blocked.block_up_bomb(bomb, bombUp_power)) {
                edgeUp.setImg(Sprite.explosionVerticalTopLast.getFxImage());
                list_Kill[edgeUp.getX() / 32][edgeUp.getY() / 32] = 4;
            }
            if (Blocked.block_left_bomb(bomb, bombLeft_power)) {
                edgeLeft.setImg(Sprite.explosionHorizontalLeftLast.getFxImage());
                list_Kill[edgeLeft.getX() / 32][edgeLeft.getY() / 32] = 4;
            }
            if (Blocked.block_right_bomb(bomb, bombRight_power)) {
                edgeRight.setImg(Sprite.explosionHorizontalRightLast.getFxImage());
                list_Kill[edgeRight.getX() / 32][edgeRight.getY() / 32] = 4;
            }
            if (list1.size() > 0)
                for (Entity e : list1) {
                    e.setImg(Sprite.explosionVertical.getFxImage());
                    list_Kill[e.getX() / 32][e.getY() / 32] = 4;
                }
            if (list.size() > 0)
                for (Entity e : list) {
                    e.setImg(Sprite.explosionHorizontal.getFxImage());
                    list_Kill[e.getX() / 32][e.getY() / 32] = 4;
                }
            swapExplosion = 2;

        } else if (swapExplosion == 2) {
            bomb.setImg(Sprite.bombExploded_1.getFxImage());
            if (Blocked.block_down_bomb(bomb, bombDown_power))
                edgeDown.setImg(Sprite.explosionVerticalDownLast_1.getFxImage());
            if (Blocked.block_up_bomb(bomb, bombUp_power))
                edgeUp.setImg(Sprite.explosionVerticalTopLast_1.getFxImage());
            if (Blocked.block_left_bomb(bomb, bombLeft_power))
                edgeLeft.setImg(Sprite.explosionHorizontalLeftLast_1.getFxImage());
            if (Blocked.block_right_bomb(bomb, bombRight_power))
                edgeRight.setImg(Sprite.explosionHorizontalRightLast_1.getFxImage());
            if (isMiddle) {
                for (Entity e : list1) {
                    e.setImg(Sprite.explosionVertical_1.getFxImage());
                }
                for (Entity e : list) {
                    e.setImg(Sprite.explosionHorizontal_1.getFxImage());
                }
            }
            swapExplosion = 3;

        } else if (swapExplosion == 3) {
            bomb.setImg(Sprite.bombExploded_2.getFxImage());
            if (Blocked.block_down_bomb(bomb, bombDown_power))
                edgeDown.setImg(Sprite.explosionVerticalDownLast_2.getFxImage());
            if (Blocked.block_up_bomb(bomb, bombUp_power))
                edgeUp.setImg(Sprite.explosionVerticalTopLast_2.getFxImage());
            if (Blocked.block_left_bomb(bomb, bombLeft_power))
                edgeLeft.setImg(Sprite.explosionHorizontalLeftLast_2.getFxImage());
            if (Blocked.block_right_bomb(bomb, bombRight_power))
                edgeRight.setImg(Sprite.explosionHorizontalRightLast_2.getFxImage());
            if (isMiddle) {
                for (Entity e : list1) {
                    e.setImg(Sprite.explosionVertical_2.getFxImage());
                }
                for (Entity e : list) {
                    e.setImg(Sprite.explosionHorizontal_2.getFxImage());
                }
            }
            swapExplosion = 1;
        }
    }

    private static void checkExplosion() {
        if (isBomb == 2)
            if (System.currentTimeMillis() - bombTime < 1000) {
                if (System.currentTimeMillis() - tmpTime > 100) {
                    if (!isEdge) {
                        createEdge();
                        isEdge = true;
                    }
                    if (bomb_power > 0) {
                        if (!isMiddle) {
                            createMiddle();
                            isMiddle = true;
                        }
                    }
                    updateSound("explosion");
                    explodeCenter();
                    tmpTime += 100;
                }
            } else {
                isBomb = 0;
                id_Objects[bomb.getX() / 32][bomb.getY() / 32] = 0;
                list_Kill[bomb.getX() / 32][bomb.getY() / 32] = 0;
                bomb.setImg(Sprite.transparent.getFxImage());
                if (Blocked.block_down_bomb(bomb, bombDown_power)) {
                    edgeDown.setImg(Sprite.transparent.getFxImage());
                    id_Objects[edgeDown.getX() / 32][edgeDown.getY() / 32] = 0;
                    list_Kill[edgeDown.getX() / 32][edgeDown.getY() / 32] = 0;
                }
                if (Blocked.block_up_bomb(bomb, bombUp_power)) {
                    edgeUp.setImg(Sprite.transparent.getFxImage());
                    id_Objects[edgeUp.getX() / 32][edgeUp.getY() / 32] = 0;
                    list_Kill[edgeUp.getX() / 32][edgeUp.getY() / 32] = 0;
                }
                if (Blocked.block_left_bomb(bomb, bombLeft_power)) {
                    edgeLeft.setImg(Sprite.transparent.getFxImage());
                    id_Objects[edgeLeft.getX() / 32][edgeLeft.getY() / 32] = 0;
                    list_Kill[edgeLeft.getX() / 32][edgeLeft.getY() / 32] = 0;
                }
                if (Blocked.block_right_bomb(bomb, bombRight_power)) {
                    edgeRight.setImg(Sprite.transparent.getFxImage());
                    id_Objects[edgeRight.getX() / 32][edgeRight.getY() / 32] = 0;
                    list_Kill[edgeRight.getX() / 32][edgeRight.getY() / 32] = 0;
                }
                if (isMiddle) {
                    for (Entity e : list1) {
                        list_Kill[e.getX() / 32][e.getY() / 32] = 0;
                        id_Objects[e.getX() / 32][e.getY() / 32] = 0;
                    }
                    for (Entity e : list) {
                        list_Kill[e.getX() / 32][e.getY() / 32] = 0;
                        id_Objects[e.getX() / 32][e.getY() / 32] = 0;
                    }
                }
                block.removeAll(list);
                block.removeAll(list1);
                list.clear();
                list1.clear();

                isEdge = false;
                isMiddle = false;
                bombDown_power = 0;
                bombUp_power = 0;
                bombLeft_power = 0;
                bombRight_power = 0;
            }
    }


    @Override
    public void update() {
        checkActive();
        checkExplosion();
    }

}
