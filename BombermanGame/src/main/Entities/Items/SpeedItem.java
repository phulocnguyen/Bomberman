package main.Entities.Items;


import javafx.scene.image.Image;


public class SpeedItem extends Item {
    public static int speed = 1;

    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public SpeedItem() {

    }

    public SpeedItem(boolean gained) {
        this.gained = gained;
    }

    // public void update() {
    //     for (Entity entity : block) {
    //         //if (entity instanceof SpeedItem && !this.gained) {
            
            
    //     }
    // }
}
