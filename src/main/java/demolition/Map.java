package demolition;

import java.util.*;
import java.io.*;

import demolition.Tiles.*;
import demolition.moveables.Enemy;
import demolition.moveables.Player;
import demolition.moveables.RedEnemy;
import demolition.moveables.YellowEnemy;

/**
 * Map Class, Controls the current level of the game, tracks all entitys aand the state of the map/tile layout.
 */
public class Map {
    private App app;
    private Player player;
    private GameController gameController;
    private int timer = 0;
    private static final int PURGE_TIME = 1200;

    /**
     * The map of the level displayed as a 2D list of Tiles
     */
    public Tile[][] levelMap;

    /**
     * List of all Enemys currently on the map
     */
    public ArrayList<Enemy> enemys = new ArrayList<>();

    /**
     * List of all bombs currently on the map
     */
    public ArrayList<Bomb> bombs = new ArrayList<>();

    /**
     * List of all explosioins currently on map
     */
    public ArrayList<Explosion> explosions = new ArrayList<>();



    /**
     * Class constructor
     *
     * Uses level setup file to create a map with enemies and blocks
     *
     * @param path              the path to level setup file
     * @param app               the application window the map runs in
     * @param gameController    the game controller that controls the map
     */
    public Map(String path, App app, GameController gameController) {
        this.app = app;
        this.gameController = gameController;
        this.player = gameController.player;
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
                        gameController.player.setX(x);
                        gameController.player.setY(y - 16);
                    } else if (character == 'R') {
                        RedEnemy red = new RedEnemy(x, y-16, this);
                        enemys.add(red);
                    } else if (character == 'Y') {
                        YellowEnemy yellow = new YellowEnemy(x, y-16, this);
                        enemys.add(yellow);
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

    /**
     * Returns tile at a given set of (x,y) coordinates
     *
     * @param x     the x-coordinate of the tile
     * @param y     the y-coordinate of the tile
     * @return      the Tile at the given coordinates
     */
    public Tile tileAt(int x, int y) {
        return (levelMap[y/32 - 2][x/32]);
    }

    /**
     * Replaces tile in level map with tile supplied.
     * The tile to be replaced is the one with the same coordinates as the one given in params
     * @param tile  the tile that is replacing current tile of same coords
     */
    public void setTile(Tile tile) {
        levelMap[tile.getY()/32 - 2][tile.getX()/32] = tile;
    }

    /**
     * Runs an ingame tick on all aspects of the map.
     *
     * The methods ticks all tiles, the player, enemies (the player loses a life if at same coords as them),
     * bombs, explosions (players and enemies both lose life if at same coords), checks if player has reached
     * goal tile and occasionally purges lists of unnecessary objects to maintain performance
     *
     */
    public void tick() {
        for (Tile[] tiles : levelMap) {
            for (Tile tile : tiles) {
                tile.tick();
            }
        }

        player.tick();

        for (Enemy enemy : enemys) {
            enemy.tick();
            if (enemy.alive && enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
                player.loseLife(app.gameController);
            }
        }
        for (Bomb bomb : bombs) {
            if (!bomb.exploded) {
                bomb.tick();
            }
        }

        for (Explosion explosion : explosions) {
            explosion.tick();

            if (explosion.burning) {
                if (explosion.getX() == player.getX() && explosion.getY() == player.getY() + 16) {
                    player.loseLife(app.gameController);
                    break;
                }
                for (Enemy enemy : enemys) {
                    if (explosion.getX() == enemy.getX() && explosion.getY() == enemy.getY() + 16) {
                        enemy.loseLife();
                    }
                }
            }
        }
        if (timer++ > PURGE_TIME) {
            purge();
        }
        for (Tile[] tiles : levelMap) {
            for (Tile tile : tiles) {
                if (tile.getX() == player.getX() && tile.getY() == player.getY() + 16 && tile.getClass() == demolition.Tiles.GoalTile.class) {
                    gameController.levelComplete();
                }
            }
        }

    }

    /**
     * Will draw blocks, bombs, enemies, explosions and player to the window
     * @param app       the application window to be drawn to
     */
    public void draw(App app) {
        for (int i = 0; i < levelMap.length; i++) {

            for (int j = 0; j < levelMap[i].length; j++) {
                levelMap[i][j].draw(app);
                // System.out.print(levelMap[i][j] == null);
                }
        }
        for (Bomb bomb : bombs) {
            if (!bomb.exploded) {
                bomb.draw(app);
            }
        }
        for (Enemy enemy : enemys ) {
            if (enemy.alive) {
                enemy.draw(app);
            }
        }

        for (Explosion explosion : explosions) {
            if (explosion.burning) {
                explosion.draw(app);
            }
        }

        player.draw(app);
    }

    /**
     * Removes bombs that are exploded, explosions that are no longer present, and non alive enemies from their respective lists
     */
    private void purge() {
        bombs.removeIf((bomb) -> (bomb.exploded));
        explosions.removeIf((explosion) -> (!explosion.burning));
        enemys.removeIf((enemy) -> (!enemy.alive));

    }
}
