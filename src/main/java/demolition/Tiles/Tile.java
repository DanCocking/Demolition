package demolition.Tiles;
import processing.core.PImage;
import demolition.App;
import demolition.Displayed;
import processing.core.PApplet;


public abstract class Tile implements Displayed {
    int x;
    int y;

    /**
     * Returns whether the block stops explosions from effecting the next block
     *
     * @return the boolean value of if the block will stop explosions
     */
    public abstract boolean stopsExplosions();

     /**
     * Returns whether the block is breakable or not
     *
     * @return the boolean value of if the block is breakable
     */
    public abstract boolean isBreakable();

    /**
     * Returns whether the block is passable by moveables or not
     * @return the boolean value of if the block is passable by moveables
     */
    public abstract boolean isPassable();

    /**
     * Class constructor.
     * This method creates a Tile at coordinates (x,y)
     * @param x         the x-coordinate of the tile
     * @param y         the y-coordinate of the tile
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws tile to app
     * @param app       the runnig application
     */
    public abstract void draw(App app);

    /**
     * Runs tick on Tile
     * Currently unused and is to maintain interface consistency
     */
    public void tick() {

    }

    /**
     * Returns the x-coordinate of the tile
     * @return the x-coordinate of the tile
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the tile
     * @return the y-coordinate of the tile
     */
    public int getY() {
        return y;
    }

}
