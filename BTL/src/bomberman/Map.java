package bomberman;

import bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Map {
    private int level;
    private int row;
    private int column;
    private String path;
    public static String map[][];

    public Map(String path) {
        this.path = path;
        loadFromFile();
    }
    private void loadFromFile() {;
        Scanner input = null;
        try {
            input = new Scanner(new File(path));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file");
            System.exit(1);
        }

        try {
            level = input.nextInt();
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
        input.close();
    }

    public static boolean canMove(int nextX, int nextY) {
        int xUnit_1 = nextX/ Sprite.SCALED_SIZE;
        int yUnit_1 = nextY/ Sprite.SCALED_SIZE;

        int xUnit_2 = (nextX + Sprite.SCALED_SIZE - 1)/ Sprite.SCALED_SIZE;
        int yUnit_2 = nextY/ Sprite.SCALED_SIZE;

        int xUnit_3 = nextX/ Sprite.SCALED_SIZE;
        int yUnit_3 = (nextY + Sprite.SCALED_SIZE - 1)/ Sprite.SCALED_SIZE;

        int xUnit_4 = (nextX + Sprite.SCALED_SIZE - 1)/ Sprite.SCALED_SIZE;
        int yUnit_4 = (nextY + Sprite.SCALED_SIZE - 1)/ Sprite.SCALED_SIZE;

        return !(map[yUnit_1][xUnit_1].equals("#") ||
                map[yUnit_1][xUnit_1].equals("*") ||
                map[yUnit_2][xUnit_2].equals("#") ||
                map[yUnit_2][xUnit_2].equals("*") ||
                map[yUnit_3][xUnit_3].equals("#") ||
                map[yUnit_3][xUnit_3].equals("*") ||
                map[yUnit_4][xUnit_4].equals("#") ||
                map[yUnit_4][xUnit_4].equals("*") ) ;
    }

    public static String[][] getMap() {
        return map;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
