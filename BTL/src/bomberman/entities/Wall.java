package bomberman.entities;

import javafx.scene.image.Image;
import bomberman.Map;

public class Wall extends Entity {
    public Wall(int x, int y, Image img) {
        super(x, y, img);
        explosive = false;
    }


    @Override
    public void update() {

    }
    public boolean collide(Entity e) {
        return false;
    }
}