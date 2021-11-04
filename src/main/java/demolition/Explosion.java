package demolition;

import processing.core.PImage;

/**
 * Explosion class, implements horizontal, vertical and center explosions and their basic logic
 */
public class Explosion extends Displayable{
    private static final double TIME_ON_SCREEN = 0.5;
     // 0: Center, 1: Horizontal, 2: Vertical
     private int type;
     private int timer = 0;

    /**
     * The images displayed to window of the explosions animation in order of type
     */
    static PImage[] sprites = new PImage[3];

    /**
     * tracks whether the explosion is still active or not
     */
    public boolean burning = true;


    /**
     * Class constructor
     *
     * Initialises explosion of given type at x, y coordinates
     * @param x         the x-coordinate of the explosion
     * @param y         the y-coordinate of the explosion
     * @param type      the type of the explosion (0: Center, 1: Horizontal, 2: Vertical)
     */
    public Explosion(int x, int y, int type) {
        super(x, y);
        this.type = type;
    }

    /**
     * Draws the explosion to the given application window
     * @param app       the explosion window to draw to
     */
    public void draw(App app) {
        if (burning) {
            app.image(Explosion.sprites[type], this.x, this.y);
        }
    }

    /**
     * Runs a tick on explosion
     * Will measure time of explosion to make burning variable false when explosion has lasted full time
     */
    public void tick() {
        if (!burning) return;
        timer++;

        if (timer > TIME_ON_SCREEN * 60) {
            burning = false;
        }

    }

    /**
     * Returns the x-coordinate of explosion
     * @return the x-coordinate of the explosion
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of explosion
     * @return the y-coordinate of the explosion
     */
    public int getY() {
        return y;
    }

}
