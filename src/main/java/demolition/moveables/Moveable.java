package demolition.moveables;

import demolition.Direction;
import demolition.Displayable;
import demolition.Map;

/**
 * Movable Class, Used to implement the basic movement funcitons, used in the implementation of
 * Enemy (and its subclasses) and Player
 */
public abstract class Moveable extends Displayable{
    /**
     * Tracks the Direction (from enum) that the movable is facing
     */
    Direction direction = Direction.DOWN;

    /**
     * Class constructor.
     *
     * Creates new Moveable at (x,y) coordinates
     * @param x     the x-coordinate of the moveable created
     * @param y     the y-coordinate of the moveable created
     */
    public Moveable(int x, int y) {
        super(x, y);
    }

    /**
     * Will move the moveable one block left (if block is passable) and return whether the moveable was able to move
     * @param map   the map the moveable is placed on - where the level map is
     * @return      the boolean value of if the move was a success
     */
    public boolean moveLeft(Map map) {
        direction = Direction.LEFT;
        if (map.tileAt(x-32, y+16).isPassable()) {
            x -= 32;
            return true;
        }
        return false;

    }

    /**
     * Will move the moveable one block right (if block is passable) and return whether the moveable was able to move
     * @param map   the map the moveable is placed on - where the level map is
     * @return      the boolean value of if the move was a success
     */
    public boolean moveRight(Map map) {
        direction = Direction.RIGHT;
        if (map.tileAt(x+32, y+16).isPassable()) {
            x += 32;
            return true;
        }
        return false;

    }

    /**
     * Will move the moveable one block up (if block is passable) and return whether the moveable was able to move
     * @param map   the map the moveable is placed on - where the level map is
     * @return      the boolean value of if the move was a success
     */
    public boolean moveUp(Map map) {
        direction = Direction.UP;

        if (map.tileAt(x, y - 16).isPassable()) {
            y -= 32;
            return true;
        }
        return false;

    }

    /**
     * Will move the moveable one block down (if block is passable) and return whether the moveable was able to move
     * @param map   the map the moveable is placed on - where the level map is
     * @return      the boolean value of if the move was a success
     */
    public boolean moveDown(Map map) {
        direction = Direction.DOWN;

        if (map.tileAt(x, y + 48).isPassable()) {
            y += 32;
            return true;
        }
        return false;
    }
}
