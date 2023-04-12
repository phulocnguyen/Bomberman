package main.Graphics;

import main.Entities.AnimateEntities.StaticEntities.*;
import main.Entities.Entity;
import main.Entities.*;
import main.Entities.Items.FlameItem;
import main.Entities.Items.SpeedItem;

import static main.BombermanGame.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateMap {
    public CreateMap(String level) {
        System.out.println(System.getProperty("user.dir"));
        final File fileName = new File(level);
        try(FileReader inputFile = new FileReader(fileName)) {
            Scanner sc = new Scanner(inputFile);
            String line = sc.nextLine();

            StringTokenizer tokens = new StringTokenizer(line);
            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());

            while (sc.hasNextLine()) {
                id_Objects = new int[*width][*height];
                list_Kill = new int[*width][*height];
                for(int i = 0; i < *height; ++i) {
                    String line_Tile = sc.nextLine();
                    StringTokenizer token_Tile = new StringTokenizer(line_Tile);

                    for(int j = 0; j < *width; j++) {
                        int lm = Integer.parseInt(token_Tile.nextToken());
                        Entity entity;
                        switch (lm) {
                            case 1:
                                entity = new Portal(j, i, Sprite.grass.getFxImage());
                                lm = 0;
                                break;
                            case 2:
                                entity = new Wall(j, i, Sprite.wall.getFxImage());
                                break;
                            case 3:
                                entity = new Brick(j, i, Sprite.brick.getFxImage());
                                break;
                            case 6:
                                entity = new SpeedItem(j, i, Sprite.brick.getFxImage());
                                break;
                            case 7:
                                entity = new FlameItem(j, i, Sprite.brick.getFxImage());
                                break;
                            default:
                                entity = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        id_Objects[j][i] = lm;
                        bLock.add(entity);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
