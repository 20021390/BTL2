package bomberman.entities.Item;

import bomberman.BombermanGame;
import bomberman.entities.Bomber;
import bomberman.entities.Entity;
import javafx.scene.image.Image;

import java.util.List;

public class SpeedItem extends Item {
    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        super.update();
        for (int i = 0; i < BombermanGame.getEntities().size(); i++) {
            if (collide()) {
                Bomber bomber = (Bomber) BombermanGame.getEntities().get(0);
                bomber.setSpeed(bomber.getSpeed() + 1);
            }
        }
    }
}


