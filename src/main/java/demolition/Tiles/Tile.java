package demolition.Tiles;
import processing.core.PImage;
import demolition.Displayed;
import demolition.VulnerableToExplosion;
import processing.core.PApplet;


public abstract class Tile implements VulnerableToExplosion, Displayed {
    int x;
    int y;
    public abstract boolean stopsExplosions();
    public abstract boolean isBreakable();
    public abstract boolean isPassable();

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void draw(PApplet app);
    public abstract void tick();
    public abstract void type();
    public boolean explode() {
        return isBreakable();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}
