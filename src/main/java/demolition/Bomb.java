package demolition;

import demolition.Tiles.*;
import processing.core.PImage;

/**
 * Bomb class, implements the bomb feature, it can be displayed to window, and will explode neccesary
 * blocks and enemies on its map depending on their properties
 */
public class Bomb extends Displayable{
    private static final double TIME_BETWEEN_FRAMES = 0.25;
    private Map map;
    private int timer = 0;
    private int spriteNum = 0;


    /**
     * The images displayed to window of the bombs animation in order
     */
    static PImage[] sprites = new PImage[8];

    /**
     * Tracks whether the bomb has exploded or not
     */
    public boolean exploded = false;

    /**
     * Class constructor.
     *
     * Creates Bomb at coordinates (x,y) on map
     * @param x     the x-coordinate of the bomb
     * @param y     the y-coordinate of the bomb
     * @param map   the map the bomb is placed on
     */
    public Bomb(int x, int y, Map map) {
        super(x, y+16);
        this.map = map;
        map.bombs.add(this);
    }

    /**
     * Method ran every tick on the bomb
     *
     * Updates sprites and bomb state
     */
    public void tick() {
        if (exploded) return;
        timer++;

        if (timer > TIME_BETWEEN_FRAMES * 60) {
            spriteNum++;
            timer = 0;
        }
        if (spriteNum >= 8) {
            explode();
        }
    }

    /**
     * Draws bomb sprite to the application window
     * @param app   the application that is drawn to
     */
    public void draw(App app) {
        if (!exploded) {
            app.image(sprites[spriteNum], this.x, this.y);
        }
    }


    /**
     * Method that is ran when the bomb explodes.
     *
     * This checks nearby blocks as to whether they are breakble and whether they stop explosions. Will only go to those directly horizontal and directly vertical
     * Explosion will travel through any blocks that do not stop explosions to maximum of 2 blocks and destroy any that are breakable (making them empty tiles)
     * Explosion will be placed on all blocks that where empty and passed by an bomb explosion
     *
     */
    public void explode() {
        exploded = true;
        map.explosions.add(new Explosion(x, y, 0));
        //down
        if (!(map.tileAt(x, y + 32).stopsExplosions()) && map.tileAt(x, y + 64).isBreakable() ) {
            if (map.tileAt(x, y+64).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x, y + 64));
            }
            map.explosions.add(new Explosion(x, y+64, 2));
        }
        if (map.tileAt(x, y + 32).isBreakable()) {
            if (map.tileAt(x, y+32).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x, y + 32));
            }
            map.explosions.add(new Explosion(x, y+32, 2));
        }


        // up
        if (!(map.tileAt(x, y - 32).stopsExplosions()) && map.tileAt(x, y - 64).isBreakable()) {
            if (map.tileAt(x, y-64).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x, y - 64));
            }
            map.explosions.add(new Explosion(x, y-64, 2));
        }
        if (map.tileAt(x, y - 32).isBreakable()) {
            if (map.tileAt(x, y-32).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x, y - 32));
            }
            map.explosions.add(new Explosion(x, y-32, 2));
        }


        // right
        if (!(map.tileAt(x + 32, y).stopsExplosions()) && map.tileAt(x + 64, y).isBreakable()) {
            if (map.tileAt(x + 64, y).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x + 64, y));
            }
            map.explosions.add(new Explosion(x + 64, y, 1));
        }

        if (map.tileAt(x + 32, y).isBreakable()) {
            if (map.tileAt(x + 32, y).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x + 32, y));
            }
            map.explosions.add(new Explosion(x + 32, y, 1));
        }

        // left
        if (!(map.tileAt(x - 32, y).stopsExplosions()) && map.tileAt(x - 64, y).isBreakable()) {
            if (map.tileAt(x - 64, y).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x - 64, y));
            }
            map.explosions.add(new Explosion(x - 64, y, 1));
        }
        if (map.tileAt(x - 32, y).isBreakable()) {
            if (map.tileAt(x -32, y).getClass() != GoalTile.class) {
                map.setTile(new EmptyTile(x - 32, y));
            }
            map.explosions.add(new Explosion(x - 32, y, 1));
        }

    }

}
