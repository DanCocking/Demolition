package demolition.Tiles;
import processing.core.PImage;
import demolition.Displayed;
import demolition.VulnerableToExplosion;
import processing.core.PApplet;


public abstract class Tile implements VulnerableToExplosion, Displayed {
    float x;
    float y;
    public abstract boolean stopsExplosions();
    public abstract boolean isBreakable();
    public abstract boolean isPassable();

    public Tile(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public abstract void draw(PApplet app);
    public abstract void tick();
    public abstract void type();


}
