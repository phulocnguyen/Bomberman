package main.Control;

import main.Entities.Entity;
import static main.PvPGame.*;
import static main.Graphics.Sprite.*;

public class Blocked {
    
    public static boolean block_down(Entity entity) {
        return id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize + 1] == 0;
    }

    public static boolean block_up(Entity entity) {
        return id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize - 1] == 0;
    }

    public static boolean block_left(Entity entity) {
        return id_Objects[entity.getX() / scaledSize - 1][entity.getY() / scaledSize] == 0;
    }

    public static boolean block_right(Entity entity) {
        return id_Objects[entity.getX() / scaledSize + 1][entity.getY() / scaledSize] == 0;
    }

    public static boolean block_down_bomb(Entity entity, int power) {
        return id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize + 1 + power] == 0
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize + 1 + power] == 3
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize + 1 + power] == 6
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize + 1 + power] == 7
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize + 1 + power] == 8;
    }

    public static boolean block_up_bomb(Entity entity, int power) {
        return id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize - 1 - power] == 0
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize - 1 - power] == 3
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize - 1 - power] == 6
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize - 1 - power] == 7
                || id_Objects[entity.getX() / scaledSize][entity.getY() / scaledSize - 1 - power] == 8;
    }

    public static boolean block_left_bomb(Entity entity, int power) {
        return id_Objects[entity.getX() / scaledSize - 1 - power][entity.getY() / scaledSize] == 0
                || id_Objects[entity.getX() / scaledSize - 1 - power][entity.getY() / scaledSize] == 3
                || id_Objects[entity.getX() / scaledSize - 1 - power][entity.getY() / scaledSize] == 6
                || id_Objects[entity.getX() / scaledSize - 1 - power][entity.getY() / scaledSize] == 7
                || id_Objects[entity.getX() / scaledSize - 1 - power][entity.getY() / scaledSize] == 8;
    }

    public static boolean block_right_bomb(Entity entity, int power) {
        return id_Objects[entity.getX() / scaledSize + 1 + power][entity.getY() / scaledSize] == 0
                || id_Objects[entity.getX() / scaledSize + 1 + power][entity.getY() / scaledSize] == 3
                || id_Objects[entity.getX() / scaledSize + 1 + power][entity.getY() / scaledSize] == 6
                || id_Objects[entity.getX() / scaledSize + 1 + power][entity.getY() / scaledSize] == 7
                || id_Objects[entity.getX() / scaledSize + 1 + power][entity.getY() / scaledSize] == 8;
    }
}