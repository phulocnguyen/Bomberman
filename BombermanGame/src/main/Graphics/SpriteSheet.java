package main.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {
    private String path; //_path;
    public final int size;
    public int[] pixels;
    public BufferedImage image;

    public static SpriteSheet _tiles = new SpriteSheet("textures/classic.png", 256);

    public SpriteSheet(String _path, int _size) {
        path = _path;
        size =  _size;
        pixels = new int[size * size];
        _load();
    }

    private void _load() {
        try {
            URL lam = SpriteSheet.class.getResource(path);
            image = ImageIO.read(lam);
            int _w = image.getWidth();
            int _h = image.getHeight();
            image.getRGB(0, 0, _w, _h, pixels, 0, _w);
        } catch (IOException l) {
            System.out.println(l.getMessage());
            l.printStackTrace();
            System.exit(0);
        }
    }
}