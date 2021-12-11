package bomberman.entities.Item;

import bomberman.entities.Bomber;
import bomberman.entities.Entity;
import javafx.scene.image.Image;

public class BombItem extends Item{
    public boolean collide() {
        return false;
    }


    public BombItem (int x, int y, Image img) {
        super(x,y,img);
    }

    @Override
    public void update() {};



}
