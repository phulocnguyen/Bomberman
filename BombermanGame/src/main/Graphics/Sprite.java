package main.Graphics;
import javafx.scene.image.*;

public class Sprite {

    public static final int defaultSize = 16;
    public static final int scaledSize = defaultSize * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00ff;
    public final int SIZE;
    
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;
    public static Sprite transparent = new Sprite(defaultSize, 15, 15, SpriteSheet._tiles, 16, 16);

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

    /**
     * Ghost.
     */
    public static Sprite ghostLeft_1 = new Sprite(defaultSize, 6, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite ghostLeft_2 = new Sprite(defaultSize, 6, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite ghostLeft_3 = new Sprite(defaultSize, 6, 7, SpriteSheet._tiles, 16, 16);

    public static Sprite ghostRight_1 = new Sprite(defaultSize, 7, 5, SpriteSheet._tiles, 16, 16);
    public static Sprite ghostRight_2 = new Sprite(defaultSize, 7, 6, SpriteSheet._tiles, 16, 16);
    public static Sprite ghostRight_3 = new Sprite(defaultSize, 7, 7, SpriteSheet._tiles, 16, 16);

    public static Sprite ghostDead = new Sprite(defaultSize,6,8 , SpriteSheet._tiles, 16, 16);


    //Pass
	public static Sprite passLeft_1 = new Sprite(defaultSize, 4, 5, SpriteSheet._tiles, 16, 16);
	public static Sprite passLeft_2 = new Sprite(defaultSize, 4, 6, SpriteSheet._tiles, 16, 16);
	public static Sprite passLeft_3 = new Sprite(defaultSize, 4, 7, SpriteSheet._tiles, 16, 16);

	public static Sprite passRight_1 = new Sprite(defaultSize, 5, 5, SpriteSheet._tiles, 16, 16);
	public static Sprite passRight_2 = new Sprite(defaultSize, 5, 6, SpriteSheet._tiles, 16, 16);
	public static Sprite passRight_3 = new Sprite(defaultSize, 5, 7, SpriteSheet._tiles, 16, 16);

	public static Sprite passDead = new Sprite(defaultSize, 4, 8, SpriteSheet._tiles, 16, 16);

    //Ovapi
	public static Sprite ovapiLeft_1 = new Sprite(defaultSize, 6, 5, SpriteSheet._tiles, 16, 16);
	public static Sprite ovapiLeft_2 = new Sprite(defaultSize, 6, 6, SpriteSheet._tiles, 16, 16);
	public static Sprite ovapiLeft_3 = new Sprite(defaultSize, 6, 7, SpriteSheet._tiles, 16, 16);

	public static Sprite ovapiRight_1 = new Sprite(defaultSize, 7, 5, SpriteSheet._tiles, 16, 16);
	public static Sprite ovapiRight_2 = new Sprite(defaultSize, 7, 6, SpriteSheet._tiles, 16, 16);
	public static Sprite ovapiRight_3 = new Sprite(defaultSize, 7, 7, SpriteSheet._tiles, 16, 16);

	public static Sprite ovapiDead = new Sprite(defaultSize, 6, 8, SpriteSheet._tiles, 16, 16);

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

    public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        _x = x * SIZE;
        _y = y * SIZE;
        _sheet = sheet;
        _realWidth = rw;
        _realHeight = rh;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {
        for (int i = 0; i < _pixels.length; i++) {
            _pixels[i] = color;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                _pixels[x + y * SIZE] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public int getPixel(int i) {
        return _pixels[i];
    }

    public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE, SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (_pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                } else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input, scaledSize / defaultSize);
    }

    private Image resample(Image input, int scaleFactor) {
        final int W = (int) input.getWidth();
        final int H = (int) input.getHeight();
        final int S = scaleFactor;

        WritableImage output = new WritableImage(
                W * S,
                H * S
        );

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                final int argb = reader.getArgb(x, y);
                for (int dy = 0; dy < S; dy++) {
                    for (int dx = 0; dx < S; dx++) {
                        writer.setArgb(x * S + dx, y * S + dy, argb);
                    }
                }
            }
        }

        return output;
    }
}
