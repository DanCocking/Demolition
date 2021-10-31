package demolition;

import java.util.*;

import demolition.Tiles.*;


import java.io.*;

import processing.core.PApplet;
public class Map implements Displayed {
    Tile[][] levelMap;
    ArrayList<Displayed> drawables = new ArrayList<>();
    Player player;

    public Map(String path, App app) {
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
                int x = column * 32;
                int y = 64 + row * 32;
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
                    if (character == 'P') {
                        Player player = new Player(x, y-16);
                        app.player = player;
                        this.player = player;
                    } else if (character == 'R') {
                        RedEnemy red = new RedEnemy(x, y-16);
                        red.setMap(this);
                        drawables.add(red);
                    } else if (character == 'Y') {
                        YellowEnemy yellow = new YellowEnemy(x, y-16);
                        yellow.setMap(this);
                        drawables.add(yellow);
                    }
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
        for (Tile[] tiles : levelMap) {
            for (Tile tile : tiles) {
                tile.tick();
            }
        }
        player.tick();
        for (Displayed disp : drawables) {
            disp.tick();
        }
    }

    public void draw(PApplet app) {
        for (int i = 0; i < levelMap.length; i++) {

            for (int j = 0; j < levelMap[i].length; j++) {
                levelMap[i][j].draw(app);
                // System.out.print(levelMap[i][j] == null);
                }
        }
        for (Displayed img : drawables ) {
            img.draw(app);
        }
        player.draw(app);

    }
}
