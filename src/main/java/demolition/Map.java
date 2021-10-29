package demolition;

import java.util.*;

import demolition.Tiles.BreakableTile;
import demolition.Tiles.EmptyTile;
import demolition.Tiles.GoalTile;
import demolition.Tiles.SolidTile;
import demolition.Tiles.Tile;

import java.io.*;

import processing.core.PApplet;
public class Map implements Displayed {
    Tile[][] levelMap;

    public Map(String path) {
        File file = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (IOException e) {
            return;
        }
        Tile[][] map = new Tile[13][15];
        int row = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Tile[] rowMap = new Tile[15];
            int column = 0;
            for (char character : line.toCharArray()) {
                float x = column * 32;
                float y = 64 + row * 32;
                Tile tile;

                if (character == 'W') {

                    tile = new SolidTile(x, y);
                } else if (character == 'B') {
                    tile = new BreakableTile(x, y);
                } else if (character == 'G') {
                    tile = new GoalTile(x, y);
                } else if (character == ' ') {
                    tile = new EmptyTile(x, y);
                } else  {
                    tile = new EmptyTile(x, y);
                }
                rowMap[column] = tile;
                column++;
            }
            map[row] = rowMap;
            row++;
        }
        this.levelMap = map;
        scanner.close();

    }

    public Tile tileAt(int x, int y) {
        return (levelMap[y/32 - 2][x/32]);
    }


    public void tick() {

    }

    public void draw(PApplet app) {
        for (int i = 0; i < levelMap.length; i++) {

            for (int j = 0; j < levelMap[i].length; j++) {
                levelMap[i][j].draw(app);
                // System.out.print(levelMap[i][j] == null);
                }
                System.out.println();
        }
    }
}
