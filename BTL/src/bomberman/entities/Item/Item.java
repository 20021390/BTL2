package bomberman.entities.Item;

import bomberman.BombermanGame;
import bomberman.entities.Bomber;
import bomberman.entities.Entity;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.util.List;

public abstract class Item extends Entity {
    protected boolean active = false;

    public Item(int x, int y, Image img) {
        super(x, y, img);
    }

    public boolean collide() {
        int x1 = x;
        int y1 = y;
        int x2 = x + Sprite.SCALED_SIZE - 1;
        int y2 = y + Sprite.SCALED_SIZE - 1;
        for (int i = 0; i < BombermanGame.getEntities().size(); i++) {
            if (BombermanGame.getEntities().get(i) instanceof Bomber) {
                Bomber bomber = (Bomber) BombermanGame.getEntities().get(i);
                int bomberX1 = bomber.getX();
                int bomberY1 = bomber.getY();
                int bomberX2 = bomber.getX() + Sprite.SCALED_SIZE - 1;
                int bomberY2 = bomber.getY() + Sprite.SCALED_SIZE - 1;
                if (x1 >= bomberX1 && x1 <= bomberX2 && y1 >= bomberY1 && y1 <= bomberY2
                        || x2 >= bomberX1 && x2 <= bomberX2 && y2 >= bomberY1 && y2 <= bomberY2) {
                    return true;
                }

            }
        }
        return false;
    }

    public void update() {
        if (collide()) {
            List<Entity> item = BombermanGame.getPowers_up();
            item.remove(this);
            BombermanGame.setPowers_up(item);
        }
    }
}

