package demolition.Tiles;

import processing.core.PApplet;
import processing.core.PImage;


public class ExplosionTile extends Tile {
    public static PImage sprite;

    // 0: Center, 1: Horizontal, 2: Vertical
    int type;

    public ExplosionTile(float x, float y, int type) {
        super(x, y);
        this.type = type;
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
        app.image(ExplosionTile.sprite, this.x, this.y);
    }
    public void tick() {

    }
    public void type() {
        System.out.println("ex");
    }
}
