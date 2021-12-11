package bomberman.entities;

import bomberman.Map;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;


public class Balloon extends Enemy {
    private int speed =1;
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
    }

    public void moveUp() {
        if(Map.canMove(x, y-speed)) {
            y -= speed;
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3
                    , this.y, Sprite.DEFAULT_SIZE).getFxImage();
        }
    }

    public void moveDown() {
        if(Map.canMove(x, y+speed)) {
            y += speed;
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3
                    , this.y, Sprite.DEFAULT_SIZE).getFxImage();
        }
    }

    public void moveLeft() {
        if(Map.canMove(x-speed, y)) {
            x -= speed;
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3
                    , this.x, Sprite.DEFAULT_SIZE).getFxImage();
        }
    }

    public void moveRight() {
        if(Map.canMove(x+speed, y)) {
            x += speed;
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3
                    , this.x, Sprite.DEFAULT_SIZE).getFxImage();
        }
    }
    public void update() {
        if (dead == false) {
            this.randomMove();
        }
        else {
            img = Sprite.balloom_dead.getFxImage();
        }
    }

}
