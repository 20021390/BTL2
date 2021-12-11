package bomberman.entities;

import bomberman.Map;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.util.Random;

public abstract class Enemy extends Entity{

    private int speed = 1;
    protected boolean dead = false;
    public Enemy(int x, int y, Image img) {
        super(x, y, img);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public abstract void moveUp();

    public abstract void moveDown();

    public abstract void moveLeft();
    public abstract void moveRight();
    public void aimMove (int k) {
        if (k== 0) {
            moveUp();
        }
        else if (k == 1) {
            moveDown();
        }
        else if (k == 2) {
            moveLeft();
        }
        else {
            moveRight();
        }
    }
    public void randomMove() {
        Random random = new Random();
        aimMove(random.nextInt(4));
    }
    @Override
    public abstract void update();
}
