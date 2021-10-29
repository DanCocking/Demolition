package demolition;

import processing.core.PImage;

//TODO still need to put in things for if there is a blcok in said area; also need to stop on screen edge
public class Moveable {
    int x;
    int y;
    Direction direction = Direction.down;
    PImage[][] sprites = new PImage[4][4];

    public Moveable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean moveLeft(Map map) {
        direction = Direction.left;
        if (map.tileAt(x-32, y).isPassable()) {
            x -= 32;
            return true;
        }
        return false;

    }
    public boolean moveRight(Map map) {
        direction = Direction.right;
        if (map.tileAt(x+32, y).isPassable()) {
            x += 32;
            return true;
        }
        return false;

    }
    public boolean moveUp(Map map) {
        direction = Direction.up;

        if (map.tileAt(x, y - 32).isPassable()) {
            y -= 32;
            return true;
        }
        return false;

    }
    public boolean moveDown(Map map) {
        direction = Direction.down;

        if (map.tileAt(x, y + 32).isPassable()) {
            y += 32;
            return true;
        }
        return false;
    }
}
