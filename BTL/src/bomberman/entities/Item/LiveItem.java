package bomberman.entities.Item;

import bomberman.entities.Bomber;
import bomberman.entities.Entity;
import javafx.scene.image.Image;

public class LiveItem extends Item{
    public LiveItem (int x, int y, Image img) {
        super(x,y,img);
        explosive = true;
    }
    public void update() {};



}
