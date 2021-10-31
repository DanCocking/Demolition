package demolition.Tiles;
import demolition.App;
import processing.core.PApplet;
import processing.core.PImage;



public class GoalTile extends Tile {
    public static PImage sprite;

    /**
     * Class constructor.
     * This method creates a GoalTile at coordinates (x,y)
     * @param x         the x-coordinate of the tile
     * @param y         the y-coordinate of the tile
     */
    public GoalTile(int x, int y) {
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
        app.image(GoalTile.sprite, this.x, this.y);
    }




}
