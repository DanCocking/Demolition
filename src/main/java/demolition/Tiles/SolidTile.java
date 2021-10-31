package demolition.Tiles;

import processing.core.PApplet;
import processing.core.PImage;


public class SolidTile extends Tile {
    public static PImage sprite;

    public SolidTile(int x, int y) {
        super(x, y);
    }

    public boolean isBreakable() {
        return false;
    }

    public boolean stopsExplosions() {
        return true;
    }

    public boolean isPassable() {
        return false;
    }


    public void draw(PApplet app) {
        app.image(SolidTile.sprite, this.x, this.y);
    }
    public void tick() {

    }
    public void type() {
        System.out.println("s");
    }
}
