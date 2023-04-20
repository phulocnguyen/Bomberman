package main.Graphics;

import main.Entities.AnimateEntities.DynamicEntities.Enemies.*;
// import static main.BombermanGame.*;
import static main.PvPGame.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateEnemy {
    public CreateEnemy(String _level) {
        System.out.println(System.getProperty("user.dir"));
        final File fileName = new File(_level);
        try(FileReader inputFile = new FileReader(fileName)) {
            try (Scanner sc = new Scanner(inputFile)) {
                String line = sc.nextLine();

                StringTokenizer tokens = new StringTokenizer(line);
                level = Integer.parseInt(tokens.nextToken());
                _height = Integer.parseInt(tokens.nextToken());
                _width = Integer.parseInt(tokens.nextToken());

                while (sc.hasNextLine()) {
                    for(int i = 0; i < _height; ++i) {
                        String line_Tile = sc.nextLine();
                        StringTokenizer token_Tile = new StringTokenizer(line_Tile);

                        for(int j = 0; j < _width; j++) {
                            int lm = Integer.parseInt(token_Tile.nextToken());
                            switch (lm) {
                                case 8:
                                    enemy.add(new Ballom(j, i, Sprite.ballomLeft_1.getFxImage()));
                                    break;
                                case 9:
                                    enemy.add(new Doll(j, i, Sprite.dollLeft_1.getFxImage()));
                                    break;
                                case 10:
                                    enemy.add(new Kondoria(j, i, Sprite.kondoriaLeft_1.getFxImage()));
                                    break;
                                case 11:
                                    enemy.add(new Minvo(j, i, Sprite.minvoLeft_1.getFxImage()));
                                    break;
                                case 12:
                                    enemy.add(new Oneal(j, i, Sprite.onealLeft_1.getFxImage()));
                                    break;
                                case 13:
                                    enemy.add(new Ghost(j, i, Sprite.ghostLeft_1.getFxImage()));
                                    break;
                                case 14:
                                    enemy.add(new Ovapi(j, i, Sprite.ovapiLeft_1.getFxImage()));
                                    break;
                                case 15:
                                    enemy.add(new Pass(j, i, Sprite.passLeft_1.getFxImage()));
                                    break;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}