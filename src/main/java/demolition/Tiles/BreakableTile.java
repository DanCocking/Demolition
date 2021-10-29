package demolition.Tiles;
import processing.core.PApplet;
import processing.core.PImage;



public class BreakableTile extends Tile {
    public static PImage sprite;

    public BreakableTile(float x, float y) {
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

    public boolean explode() {
        //TODO Need to replace the tile xx
        Tile replacement = new EmptyTile(x,y);
        return true;
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
