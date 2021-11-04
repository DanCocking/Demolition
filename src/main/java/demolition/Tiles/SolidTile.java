package demolition.Tiles;

import demolition.App;
import processing.core.PImage;

/**
 * GoalTile class, Used to implent goal tiles that are able to be displayed to window in correct position
 * and able to be not passed by moveables nor passed by or exploded by explosions
 */
public class SolidTile extends Tile {
    /**
     * The image displayed when the tile is drawn to window
     */
    public static PImage sprite;

    /**
     * Class constructor.
     * This method creates a SolidTile at coordinates (x,y)
     * @param x         the x-coordinate of the tile
     * @param y         the y-coordinate of the tile
     */
    public SolidTile(int x, int y) {
        super(x, y);
    }

    /**
     * Returns whether the block is breakble or not
     * @return false
     */
    public boolean isBreakable() {
        return false;
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
        app.image(SolidTile.sprite, this.x, this.y);
    }


}
