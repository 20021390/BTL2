package bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


import bomberman.graphics.Sprite;
import bomberman.Map;
import bomberman.entities.Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bomber extends Entity {
    private static int speed = 1;
    protected boolean left = false, right = false, up = false, down = false, isDead = false;
    private ArrayList<Sprite> bomberAnimLeft;
    private ArrayList<Sprite> bomberAnimRight ;
    private ArrayList<Sprite> bomberAnimUp;
    private ArrayList<Sprite> bomberAnimDown;
    private int AnimIndex = 0;

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Bomber.speed = speed;
    }


    public Bomber(int x, int y, Image img) {
        super( x, y, img);
        explosive = true;
    }


    public void moveUp() {
        if(Map.canMove(x, y-speed)) {
            y -= speed;
            img = Sprite.player_up.getFxImage();
        }
    }

    public void moveDown() {
        if(Map.canMove(x, y+speed)) {
            y += speed;
            img = Sprite.player_down.getFxImage();
        }
    }

    public void moveLeft() {
        if(Map.canMove(x-speed, y)) {
            x -= speed;
            img = Sprite.player_left.getFxImage();
        }
    }

    public void moveRight() {
        if(Map.canMove(x+speed, y)) {
            x += speed;
            img = Sprite.player_right.getFxImage();
        }
    }


    @Override
    public void update() {
        if(left) {
            moveLeft();
        }
        if(right) {
            moveRight();
        }
        if(up) {
            moveUp();
        }
        if(down) {
            moveDown();
        }

    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setBomberAnimLeft() {
        bomberAnimLeft.add(Sprite.player_left);
        bomberAnimLeft.add(Sprite.player_left_1);
        bomberAnimLeft.add(Sprite.player_left_2);
    }

    public void setBomberAnimRight() {
        bomberAnimRight.add(Sprite.player_right);
        bomberAnimRight.add(Sprite.player_right_1);
        bomberAnimRight.add(Sprite.player_right_2);
    }

    public void setBomberAnimUp() {
        bomberAnimUp.add(Sprite.player_up);
        bomberAnimUp.add(Sprite.player_up_1);
        bomberAnimUp.add(Sprite.player_up_2);
    }

    public void setBomberAnimDown() {
        bomberAnimDown.add(Sprite.player_down);
        bomberAnimDown.add(Sprite.player_down_1);
        bomberAnimDown.add(Sprite.player_down_2);
    }




}