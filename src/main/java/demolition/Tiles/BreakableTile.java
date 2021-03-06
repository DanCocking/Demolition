package demolition.Tiles;
import demolition.App;
import processing.core.PImage;


/**
 * BreakableTile class, Used to implent breakable tiles that are able to be displayed to window in correct position
 * and able to be exploded by bomb
 */
public class BreakableTile extends Tile {
    /**
     * The image displayed when the tile is drawn to window
     */
    public static PImage sprite;

    /**
     * Class constructor.
     * This method creates a BreakableTile at coordinates (x,y)
     * @param x         the x-coordinate of the tile
     * @param y         the y-coordinate of the tile
     */
    public BreakableTile(int x, int y) {
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
     * @return true
     */
    public boolean stopsExplosions() {
        return true;
    }

    /**
     * Returns whether the block is passable by moveables or not
     * @return false
     */
    public boolean isPassable() {
        return false;
    }

    /**
     * Draws tile to app
     * @param app       the runnig application
     */
    public void draw(App app) {
        app.image(BreakableTile.sprite, this.x, this.y);
    }



}
