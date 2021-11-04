package demolition.moveables;

import demolition.Direction;
import demolition.Displayable;
import demolition.Map;

//TODO still need to put in things for if there is a blcok in said area; also need to stop on screen edge
public abstract class Moveable extends Displayable{
    Direction direction = Direction.down;

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
        direction = Direction.left;
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
        direction = Direction.right;
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
        direction = Direction.up;

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
        direction = Direction.down;

        if (map.tileAt(x, y + 48).isPassable()) {
            y += 32;
            return true;
        }
        return false;
    }
}
