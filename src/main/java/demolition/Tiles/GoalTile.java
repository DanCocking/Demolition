package demolition.Tiles;
import processing.core.PApplet;
import processing.core.PImage;



public class GoalTile extends Tile {
    public static PImage sprite;

    public GoalTile(float x, float y) {
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

    public boolean explode() {
        return true;
    }
    public void draw(PApplet app) {
        app.image(GoalTile.sprite, this.x, this.y);
    }
    public void tick() {

    }
    public void type() {
        System.out.println("g");
    }
}
