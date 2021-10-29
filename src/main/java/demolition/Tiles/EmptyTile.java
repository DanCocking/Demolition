package demolition.Tiles;
import processing.core.PApplet;
import processing.core.PImage;


public class EmptyTile extends Tile{
    public static PImage sprite;

    public EmptyTile(float x, float y) {
        super(x, y);
    }

    public boolean isBreakable() {
        return false;
    }

    public boolean stopsExplosions() {
        return false;
    }

    public boolean isPassable() {
        return true;
    }

    public boolean explode() {
        return true;
    }
    public void draw(PApplet app) {
        app.image(EmptyTile.sprite, this.x, this.y);
    }
    public void tick() {

    }
    public void type() {
        System.out.println("e");
    }
}
