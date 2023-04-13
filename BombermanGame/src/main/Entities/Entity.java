package main.Entities;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import main.Graphics.Sprite;

public abstract class Entity {
    // Tọa độ x của vật theo trục ngang
    protected int x;

    //Tọa độ y của vật theo trục thẳng đứng 
    protected int y;

    protected boolean invisible;

    protected Image img;

    public Entity(int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.scaledSize;
        this.y = yUnit * Sprite.scaledSize;
        this.img = img;
    }

    public Entity() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void render(GraphicsContext g) {
        g.drawImage(img, x, y);
    }

    public abstract void update();

}
