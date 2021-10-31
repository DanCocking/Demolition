package demolition.Tiles;
import processing.core.PApplet;
import processing.core.PImage;



public class GoalTile extends Tile {
    public static PImage sprite;

    public GoalTile(int x, int y) {
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

    public void draw(PApplet app) {
        app.image(GoalTile.sprite, this.x, this.y);
    }
    public void tick() {

    }
    public void type() {
        System.out.println("g");
    }
}
