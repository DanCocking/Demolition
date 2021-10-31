package demolition.Tiles;
import processing.core.PApplet;
import processing.core.PImage;


public class EmptyTile extends Tile{
    public static PImage sprite;

    public EmptyTile(int x, int y) {
        super(x, y);
    }

    public boolean isBreakable() {
        return true;
    }

    public boolean stopsExplosions() {
        return false;
    }

    public boolean isPassable() {
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
