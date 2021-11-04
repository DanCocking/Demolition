package demolition.Tiles;
import demolition.App;
import demolition.Displayable;


/**
 * Tile Class, used for implementing all tiles in Tiles module. Enforces all neccesary methods
 * and constructor
 */
public abstract class Tile extends Displayable {
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
        super(x,y);
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
}
