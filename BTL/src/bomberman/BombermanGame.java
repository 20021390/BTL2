package bomberman;

import bomberman.entities.Item.Item;
import bomberman.entities.Item.SpeedItem;
import bomberman.sound.Sound;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import bomberman.entities.*;
import bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BombermanGame extends Application{
    public static int WIDTH ; // tương ứng với số cot
    public static int HEIGHT; // tương ứng với số hang

    private int level;
    private String map[][];
    private GraphicsContext gc;
    private Canvas canvas;
    private static List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private static List<Entity> powers_up = new ArrayList<>();
    private Bomber bomberman;


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }


    @Override
    public void start(Stage stage) {
        createMap("D:\\OOP\\BTL\\src\\bomberman\\level\\M1.txt");
        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);
        Sound.playIngame();
        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setTitle("Bomberman");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
                stage.addEventHandler(KeyEvent.ANY, (keyEvent) -> {
                    handleEvent(keyEvent);
                });
                update();
            }
        };
        timer.start();
        //timer.stop();
    }


    public void handleEvent(KeyEvent t) {
        if(t.getEventType() == KeyEvent.KEY_PRESSED) {
            if (t.getCode() == KeyCode.LEFT) {
                bomberman.setLeft(true);
            }
            if (t.getCode() == KeyCode.RIGHT) {
                bomberman.setRight(true);
            }
            if (t.getCode() == KeyCode.UP) {
                bomberman.setUp(true);
            }
            if (t.getCode() == KeyCode.DOWN) {
                bomberman.setDown(true);
            }
        }
        if (t.getEventType() == KeyEvent.KEY_RELEASED) {
            if (t.getCode() == KeyCode.LEFT) {
                bomberman.setLeft(false);
            }
            if (t.getCode() == KeyCode.RIGHT) {
                bomberman.setRight(false);
            }
            if (t.getCode() == KeyCode.UP) {
                bomberman.setUp(false);
            }
            if (t.getCode() == KeyCode.DOWN) {
                bomberman.setDown(false);
            }
        }
    }

    public void createMap(String path) {
        Map newGame = new Map(path);
        map = newGame.getMap();
        HEIGHT = newGame.getRow();
        WIDTH = newGame.getColumn();
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                switch (map[j][i]) {
                    case "1":
                        object = new Balloon(i, j, Sprite.balloom_left2.getFxImage());
                        break;
                    case "#":
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                        break;
                    case"*":
                        object = new Brick(i, j,  Sprite.brick.getFxImage());
                        break;
                    case"?":
                        powers_up.add(new SpeedItem(i,j,Sprite.powerup_speed.getFxImage()));
                        object = new SpeedItem(i, j,  Sprite.powerup_speed.getFxImage());
                        break;
                    case "P" :
                        object = new Portal(i, j, Sprite.portal.getFxImage());
                        break;
                    default:
                        object = new Grass(i, j, Sprite.grass.getFxImage());
                        break;
                }
                stillObjects.add(object);
            }
        }
    }

    public static List<Entity> getPowers_up() {
        return powers_up;
    }

    public static void setPowers_up(List<Entity> powers_up) {
        BombermanGame.powers_up = powers_up;
    }

    public static List<Entity> getEntities() {
        return entities;
    }

    public static void setEntities(List<Entity> entities) {
        BombermanGame.entities = entities;
    }

    public void update() {
        for (Entity item : powers_up) {
            item.update();
        }
        entities.forEach(Entity::update);
        powers_up.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        powers_up.forEach(g -> g.render(gc));
    }
}
