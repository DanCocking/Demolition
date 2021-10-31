package demolition.Tiles;
import processing.core.PApplet;
import processing.core.PImage;



public class BreakableTile extends Tile {
    public static PImage sprite;

    public BreakableTile(int x, int y) {
        super(x, y);
    }
    public boolean isBreakable() {
        return true;
    }
    public boolean stopsExplosions() {
        return true;
    }
    public boolean isPassable() {
        return false;
    }

    public void draw(PApplet app) {
        app.image(BreakableTile.sprite, this.x, this.y);
    }
    public void tick() {

    }
    public void type() {
        System.out.println("B");
    }

}
