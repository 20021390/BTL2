package bomberman;

import bomberman.graphics.Sprite;

import java.io.*;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Play {
    private int position;
    private int row;
    private int column;
    private int bomber_x;
    private int bomber_y;
    private String path;
    public static String map[][];


    private void loadFromFile() {;
        Scanner input = null;
        try {
            input = new Scanner(new File(path));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file");
            System.exit(1);
        }

        try {
            position = input.nextInt();
            row = input.nextInt();
            column = input.nextInt();
            map = new String[row][column];
            String curLine = input.nextLine();
            for (int i=0; i<row; i++) {
                curLine = input.nextLine();
                if (curLine == null) return;
                String[] s = curLine.split("");
                for (int j = 0; j < column; j++) {
                    map[i][j] = s[j].trim();
                    if (map[i][j].equals("B")) {
                        bomber_x = i;
                        bomber_y = j;
                    }
                }
            }
        }catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file");
            System.exit(1);
        }
        if (input != null) {
            input.close();
        }
    }

    public boolean isValid(int nextX, int nextY) {
        return nextX > 0 && nextX < column && nextY > 0 && nextY < row;
    }
    public boolean canMove(int nextX, int nextY) {
        if (!isValid(nextX, nextY)) return false;
        return !(map[nextY][nextX].equals("#") ||
                map[nextY][nextX].equals("*"));
    }
    public void print() {
        for (int i=0; i<row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void updateBomberPosition(int x, int y) {
        bomber_x = x;
        bomber_y = y;
    }

    public void move() {
        Scanner input = new Scanner(System.in);
        do {
            String press = input.next();
            switch (press) {
                case "w":
                    UP();
                    print();
                    break;
                case "s":
                    DOWN();
                    print();
                    break;
                case "a":
                    LEFT();
                    print();
                    break;
                case "d":
                    RIGHT();
                    print();
                    break;
                case "q":
                    return;
            }
        } while (input.hasNext());
    }

    public void UP() {
        if (bomber_x > 0 && map[bomber_x-1][bomber_y].equals("s")) {
            String tmp = map[bomber_x][bomber_y];
            map[bomber_x][bomber_y] = map[bomber_x-1][bomber_y];
            map[bomber_x-1][bomber_y] = tmp;
            updateBomberPosition(bomber_x -1, bomber_y);
        } else return;
    }

    public void DOWN() {
        if (bomber_x < row -1 && map[bomber_x+1][bomber_y].equals("s")) {
            String tmp = map[bomber_x][bomber_y];
            map[bomber_x][bomber_y] = map[bomber_x+1][bomber_y];
            map[bomber_x+1][bomber_y] = tmp;
            updateBomberPosition(bomber_x + 1, bomber_y);
        } else return;
    }

    public void RIGHT() {
        if (bomber_y < column -1 && map[bomber_x][bomber_y + 1].equals("s")) {
            String tmp = map[bomber_x][bomber_y];
            map[bomber_x][bomber_y] = map[bomber_x][bomber_y + 1];
            map[bomber_x][bomber_y + 1] = tmp;
            updateBomberPosition(bomber_x, bomber_y + 1);
        } else return;
    }

    public void LEFT() {
        if (bomber_y > 0 && map[bomber_x][bomber_y - 1].equals("s")) {
            String tmp = map[bomber_x][bomber_y];
            map[bomber_x][bomber_y] = map[bomber_x][bomber_y - 1];
            map[bomber_x][bomber_y - 1] = tmp;
            updateBomberPosition(bomber_x, bomber_y - 1);
        } else return;
    }

    public String[][] getMap() {
        return map;
    }

    public void setPath(String path) {
        this.path = path;
        loadFromFile();
    }

    public Play() {}

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}


class Test {
    public static void main(String[] args) {
        Play newPlay = new Play();
        newPlay.setPath("D:\\OOP\\BTL\\src\\bomberman\\level\\M1.txt");
        newPlay.print();
    }
}