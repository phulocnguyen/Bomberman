package main.Graphics;

import javafx.scene.image.*;


public class Sprite {
    public static final int defaultSize = 16;
    public static final int scaledSize = defaultSize * 2;
    private static final int transparentColor = 0xffff00ff;
    public final int size;

    private int x, y;
    public int[] pixels;
    protected int realWidth; //_realWidth
    protected int realHeight; //_realHeight
    private SpriteSheet sheet;
    public static Sprite _transparent = new Sprite(defaultSize, 15, 15, SpriteSheet._tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
    */
    public static Sprite grass = new Sprite(defaultSize, 6, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite brick = new Sprite(defaultSize, 7, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite wall = new Sprite(defaultSize, 5, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite portal = new Sprite(defaultSize, 4, 0, SpriteSheet._tiles, 14, 14);

    /*
    |--------------------------------------------------------------------------
    | Bomber Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite playerUp = new Sprite(defaultSize,0, 0, SpriteSheet._tiles, 12, 16);
    public static Sprite playerDown = new Sprite(defaultSize, 2, 0, SpriteSheet._tiles, 12, 15);
    public static Sprite playerLeft = new Sprite(defaultSize, 3, 0, SpriteSheet._tiles, 10, 15);
    public static Sprite playRight = new Sprite(defaultSize, 1, 0, SpriteSheet._tiles, 10, 16);

    public static Sprite playerUp_1 = new Sprite(defaultSize, 0, 1, SpriteSheet._tiles, 12, 16);
    public static Sprite playerUp_2 = new Sprite(defaultSize, 0, 2, SpriteSheet._tiles, 12, 15);

    public static Sprite playerDown_1 = new Sprite(defaultSize, 2, 1, SpriteSheet._tiles, 12, 15);
    public static Sprite playerDown_2= new Sprite(defaultSize, 2, 2, SpriteSheet._tiles, 12, 16);

    public static Sprite playerLeft_1 = new Sprite(defaultSize, 3, 1, SpriteSheet._tiles, 11, 16);
    public  static Sprite playerLeft_2 = new Sprite(defaultSize, 3, 2, SpriteSheet._tiles, 12, 16);

    public static Sprite playerRight_1 = new Sprite(defaultSize, 1, 1, SpriteSheet._tiles, 12, 16);
    public static Sprite playerRight_2 = new Sprite(defaultSize, 1, 2, SpriteSheet._tiles, 12, 16);

    public static Sprite playerDead_1 = new Sprite(defaultSize, 4, 2, SpriteSheet._tiles, 14, 16);
    public static Sprite playerDead_2 = new Sprite(defaultSize, 5, 2, SpriteSheet._tiles, 13, 15);
    public static Sprite playerDead_3 = new Sprite(defaultSize, 6, 2, SpriteSheet._tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Character
    |--------------------------------------------------------------------------
     */
    //BALLOM
    public static Sprite ballomLeft_1 = new Sprite(defaultSize, 9, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite ballomLeft_2 = new Sprite(defaultSize, 9, 1, SpriteSheet._tiles, 16, 16);
    public static Sprite ballomLeft_3 = new Sprite(defaultSize, 9, 2, SpriteSheet._tiles, 16, 16);

    public static Sprite ballomRight_1 = new Sprite(defaultSize, 10, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite ballomRight_2 = new Sprite(defaultSize, 10, 1, SpriteSheet._tiles, 16, 16);
    public static Sprite ballomRight_3 = new Sprite(defaultSize, 10, 2, SpriteSheet._tiles, 16, 16);

    public static Sprite ballomDead = new Sprite(defaultSize, 9, 3, SpriteSheet._tiles, 16, 16);

    //ONEAL
    public static Sprite onealLeft_1 = new Sprite(defaultSize, 11, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite onealLeft_2 = new Sprite(defaultSize, 11, 1, SpriteSheet._tiles, 16, 16);
    public static Sprite onealLeft_3 = new Sprite(defaultSize, 11, 2, SpriteSheet._tiles, 16, 16);

    public static Sprite onealRight_1 = new Sprite(defaultSize, 12, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite onealRight_2 = new Sprite(defaultSize, 12, 1, SpriteSheet._tiles, 16, 16);
    public static Sprite onealRight_3 = new Sprite(defaultSize, 12, 2, SpriteSheet._tiles, 16, 16);

    public static Sprite onealDead = new Sprite(defaultSize, 11, 3, SpriteSheet._tiles, 16, 16);

    //Doll
    public  static Sprite dollLeft_1 = new Sprite(defaultSize, 13, 0, SpriteSheet._tiles, 16, 16);
    public  static Sprite dollLeft_2 = new Sprite(defaultSize, 13, 1, SpriteSheet._tiles, 16, 16);
    public  static Sprite dollLeft_3 = new Sprite(defaultSize, 13, 2, SpriteSheet._tiles, 16, 16);

    public  static Sprite dollRight_1 = new Sprite(defaultSize, 14, 0, SpriteSheet._tiles, 16, 16);
    public  static Sprite dollRight_2 = new Sprite(defaultSize, 14, 1, SpriteSheet._tiles, 16, 16);
    public  static Sprite dollRight_3 = new Sprite(defaultSize, 14, 2, SpriteSheet._tiles, 16, 16);

    public  static Sprite dollDead = new Sprite(defaultSize, 13, 3, SpriteSheet._tiles, 16, 16);

    //Minvo
    public static Sprite minvoLeft_1 = new Sprite(defaultSize, 8, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite minvoLeft_2 = new Sprite(defaultSize, 8, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite minvoLeft_3 = new Sprite(defaultSize, 8, 7, SpriteSheet._tiles, 16, 16);

    public static Sprite minvoRight_1 = new Sprite(defaultSize, 9, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite minvoRight_2 = new Sprite(defaultSize, 9, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite minvoRight_3 = new Sprite(defaultSize, 9, 7, SpriteSheet._tiles, 16, 16);

    public static Sprite minvoDead = new Sprite(defaultSize, 8, 8, SpriteSheet._tiles, 16, 16);

    //Kondoria
    public static Sprite kondoriaLeft_1 = new Sprite(defaultSize, 10, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite kondoriaLeft_2 = new Sprite(defaultSize, 10, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite kondoriaLeft_3 = new Sprite(defaultSize, 10, 7, SpriteSheet._tiles, 16, 16);

    public static Sprite kondoriaRight_1 = new Sprite(defaultSize, 11, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite kondoriaRight_2 = new Sprite(defaultSize, 11, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite kondoriaRight_3 = new Sprite(defaultSize, 11, 7, SpriteSheet._tiles, 16, 16);

    public static Sprite kondoriaDead = new Sprite(defaultSize, 10, 8, SpriteSheet._tiles, 16, 16);

    //ALL
    public static Sprite mobDead_1 = new Sprite(defaultSize, 15, 0, SpriteSheet._tiles, 16, 16);
    public static Sprite mobDead_2 = new Sprite(defaultSize, 15, 1, SpriteSheet._tiles, 16, 16);
    public static Sprite mobDead_3 = new Sprite(defaultSize, 15, 2, SpriteSheet._tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb = new Sprite(defaultSize, 0, 3, SpriteSheet._tiles, 15, 15);
    public static Sprite bomb_1 = new Sprite(defaultSize, 1, 3, SpriteSheet._tiles, 13, 15);
    public static Sprite bomb_2 = new Sprite(defaultSize, 2, 3, SpriteSheet._tiles, 12, 14);

    /*
    |--------------------------------------------------------------------------
    | FlameSegment Sprites
    |--------------------------------------------------------------------------
    */
    public static Sprite bombExploded = new Sprite(defaultSize, 0, 4, SpriteSheet._tiles, 16, 16);
    public static Sprite bombExploded_1 = new Sprite(defaultSize, 0, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite bombExploded_2 = new Sprite(defaultSize, 0, 6, SpriteSheet._tiles, 16, 16);

    public static Sprite explosionVertical = new Sprite(defaultSize, 1, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionVertical_1 = new Sprite(defaultSize, 2, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionVertical_2 = new Sprite(defaultSize, 3, 5, SpriteSheet._tiles, 16, 16);

    public static Sprite explosionHorizontal = new Sprite(defaultSize, 1, 7, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionHorizontal_1 = new Sprite(defaultSize, 1, 8, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionHorizontal_2 = new Sprite(defaultSize, 1, 9, SpriteSheet._tiles, 16, 16);

    public static Sprite explosionHorizontalLeftLast = new Sprite(defaultSize, 0, 7, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionHorizontalLeftLast_1 = new Sprite(defaultSize, 0, 8, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionHorizontalLeftLast_2 = new Sprite(defaultSize, 0, 9, SpriteSheet._tiles, 16, 16);

    public static Sprite explosionHorizontalRightLast = new Sprite(defaultSize, 2, 7, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionHorizontalRightLast_1 = new Sprite(defaultSize, 2, 8, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionHorizontalRightLast_2 = new Sprite(defaultSize, 2, 9, SpriteSheet._tiles, 16, 16);

    public static Sprite explosionVerticalTopLast = new Sprite(defaultSize, 1, 4, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionVerticalTopLast_1 = new Sprite(defaultSize, 2, 4, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionVerticalTopLast_2 = new Sprite(defaultSize, 3, 4, SpriteSheet._tiles, 16, 16);

    public static Sprite explosionVerticalDownLast = new Sprite(defaultSize, 1, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionVerticalDownLast_1 = new Sprite(defaultSize, 2, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite explosionVerticalDownLast_2 = new Sprite(defaultSize, 3, 6, SpriteSheet._tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Brick FlameSegment
    |--------------------------------------------------------------------------
     */
    public static Sprite brickExploded = new Sprite(defaultSize, 7, 1, SpriteSheet._tiles, 16, 16);
    public static Sprite brickExploded_1 = new Sprite(defaultSize, 7, 2, SpriteSheet._tiles, 16, 16);
    public static Sprite brickExploded_2 = new Sprite(defaultSize, 7, 3, SpriteSheet._tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Powerups
    |--------------------------------------------------------------------------
     */
    public static Sprite powerupBombs = new Sprite(defaultSize, 0, 10, SpriteSheet._tiles, 16, 16);
    public static Sprite powerupFlames = new Sprite(defaultSize, 1, 10, SpriteSheet._tiles, 16, 16);
    public static Sprite powerupSpeed = new Sprite(defaultSize, 2, 10, SpriteSheet._tiles, 16, 16);
    public static Sprite powerupWallpass = new Sprite(defaultSize, 3, 10, SpriteSheet._tiles, 16, 16);
    public static Sprite powerupDetonator = new Sprite(defaultSize, 4, 10, SpriteSheet._tiles, 16, 16);
    public static Sprite powerupBombpass = new Sprite(defaultSize, 5, 10, SpriteSheet._tiles, 16, 16);
    public static Sprite powerupFlamepass = new Sprite(defaultSize, 6, 10, SpriteSheet._tiles, 16, 16);

    public Sprite(int _size, int _x, int _y, SpriteSheet _sheet, int _rw, int _rh) {
        this.size = _size;
        this.x = _x * size;
        this.y = _y * size;
        this.sheet = _sheet;
        this.realHeight = _rh;
        this.realWidth = _rw;
        _load();
    }

    public Sprite(int _size, int _color) {
        size = _size;
        pixels = new int[size * size];
        setColor(_color);
    }
    private void setColor(int _color) {
        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = _color;
        }
    }

    private void _load() {
        for (int _y = 0; _y < size; _y++) {
            for (int _x = 0; _x < size; _x++) {
                pixels[_x + _y * size] = sheet.pixels[(_x + x) + (_y + y) * sheet.size];
            }
        }
    }
    public int getSize() {
        return size;
    }

    public int getPixel(int i) {
        return pixels[i];
    }

    public Image getFxImage() {
        WritableImage wri = new WritableImage(size, size);
        PixelWriter pwr = wri.getPixelWriter();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(pixels[i + j * size] == transparentColor) {
                    pwr.setArgb(i, j, 0);
                } else {
                    pwr.setArgb(i, j, pixels[i + j * size]);
                }
            }
        }
        Image input = new ImageView(wri).getImage();
        return resimple(input, scaledSize / defaultSize);
    }

    private Image resimple(Image input, int scaleFactor) {
        final int Ww = (int) input.getWidth();
        final int Hh = (int) input.getHeight();
        final int Ss = scaleFactor;

        WritableImage output = new WritableImage(Ww * Ss, Hh * Ss);

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = (PixelWriter) input.getPixelReader();

        for(int i = 0; i < Hh; i++) {
            for(int j = 0; j < Ww; j++) {
                final int agrb = reader.getArgb(j, i);
                for(int k = 0; k < Ss; k++) {
                    for(int l = 0; l < Ss; l++) {
                        writer.setArgb(j * Ss + l, i * Ss +k, agrb);
                    }
                }
            }
        }
        return output;
    }
}