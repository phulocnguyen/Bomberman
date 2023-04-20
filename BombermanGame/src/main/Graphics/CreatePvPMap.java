package main.Graphics;

import main.Entities.AnimateEntities.StaticEntities.*;
import main.Entities.Entity;
import main.Entities.Items.FlameItem;
import main.Entities.Items.SpeedItem;
import main.PvPGame;

import static main.PvPGame.*;
import static main.PvPGame._height;
import static main.PvPGame._width;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreatePvPMap {
    public CreatePvPMap(String level) {
        System.out.println(System.getProperty("user.dir"));
        File fileName = new File("res/levels/PvPMap.txt");                    
        try (FileReader inputFile = new FileReader(fileName)) {   
            Scanner ip = new Scanner(inputFile);                    
            String line = ip.nextLine();                            
            StringTokenizer tokens = new StringTokenizer(line);
            PvPGame.level = Integer.parseInt(tokens.nextToken());
            _height = Integer.parseInt(tokens.nextToken());
            _width = Integer.parseInt(tokens.nextToken());
            //System.out.println("2");
            while (ip.hasNextLine()) {
                //System.out.println("2.1");
                id_Objects = new int[_width][_height];                 // Create new object id_object from main file.
                //string_id_objects = new String[width][height];                 // Create new object id_object from main file.
                list_Kill = new int[_width][_height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                //string_list_kill = new String[width][height];                  // Create new object lít_kill from main file.   Main file: RunBomberman.java
                //System.out.println("2.2");
                for (int i = 0; i < _height; ++i) {
                    //System.out.println("2.3");
                    String lineTile = ip.nextLine();               // Input variable lineTile in string data type.
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);  
                    for (int j = 0; j < _width; j++) {
                        int lm = Integer.parseInt(tokenTile.nextToken());
                        Entity entity;                              // Create object entity from class Entity.

                        // This switch statement running, and we got a full map for a game.
                        // Through the program, in the for-loop statement, we can get the map according to each loop it passed.
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
                                lm = 0;
                        }
                        id_Objects[j][i] = lm;        //
                        block.add(entity);              //
                    }
                }
            }
        } catch (IOException e) {                       // Catch exception
            e.printStackTrace();                        // printStackTrace(): Help to understand where the problem is actually happening.
        } catch (Exception e) {
            System.out.println("loi");
        }
    }
}
