package demolition.moveables;

import demolition.App;
import demolition.Map;
import processing.core.PImage;


public abstract class Enemy extends Moveable{

    public boolean alive = true;
    public int spriteNum = 0;
    public int timer = 0;
    public int moveTimer = 0;

    public final double TIME_BETWEEN_FRAMES = 0.2;
    public final double TIME_BETWEEN_MOVES = 1;

    public PImage currSprite;
    public Map map;

    /**
     * Class constructor.
     *
     * Initialises enemy at (x,y) coordinates on map
     *
     * @param x    the x-coordinate of the enemy
     * @param y    the y-coordinate of the enemy
     * @param map  the map the enemy is placed onto
     */
    public Enemy(int x, int y, Map map) {
        super(x,y);
        this.map = map;
    }


    /**
     * Draws enemy sprite to the application window
     * @param app   the application that is drawn to
     */
    public void draw(App app) {
        app.image(currSprite, x, y);
    }

    /**
     * Performs tick on enemy
     */
    public abstract void tick();

    /**
     * Will change the enemy from alive state to not alive state and return success
     * @return the boolean value of if the enemy is alive
     */
    public void loseLife() {
        alive = false;
    }


}
