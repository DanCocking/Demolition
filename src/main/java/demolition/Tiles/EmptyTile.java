package demolition.Tiles;
import demolition.App;
import processing.core.PImage;

/**
 * Empty class, Used to implent empty tiles that are able to be displayed to window in correct position
 * and able to be passed by moveables
 */
public class EmptyTile extends Tile{
    /**
     * The image displayed when the tile is drawn to window
     */
    public static PImage sprite;

    /**
     * Class constructor.
     * This method creates a EmptyTile at coordinates (x,y)
     * @param x         the x-coordinate of the tile
     * @param y         the y-coordinate of the tile
     */
    public EmptyTile(int x, int y) {
        super(x, y);
    }

    /**
     * Returns whether the block is breakble or not
     * @return true
     */
    public boolean isBreakable() {
        return true;
    }

     /**
     * Returns whether the block stops explosions from effecting the next block
     *
     * @return false
     */
    public boolean stopsExplosions() {
        return false;
    }

    /**
     * Returns whether the block is passable by moveables or not
     * @return true
     */
    public boolean isPassable() {
        return true;
    }

    /**
     * Draws tile to app
     * @param app       the runnig application
     */
    public void draw(App app) {
        app.image(EmptyTile.sprite, this.x, this.y);
    }




}
