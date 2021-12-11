package bomberman.entities;

import javafx.scene.image.Image;
import bomberman.Map;

public class Grass extends Entity {
    public Grass(int x, int y, Image img) {
        super(x, y, img);
    }
    public boolean collide(Entity e) {
        return false;
    }


    @Override
    public void update() {}
}