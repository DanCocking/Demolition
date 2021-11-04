package demolition.moveables;

import demolition.App;
import demolition.Map;
import processing.core.PImage;

/**
 * Enemy class, can represent different emeny classes including RedEnemy and YellowEnemy
 */
public abstract class Enemy extends Moveable{
    /**
     * Marks if enemy is alive or not
     */
    public boolean alive = true;

    /**
     * Tracks which phase of the movement animation Enemy is currently at
     */
    protected int spriteNum = 0;

    /**
     * Number of ticks since last animation change
     */
    protected int timer = 0;

    /**
     * Number of ticks since last movement of the enemy
     */
    protected int moveTimer = 0;

    /**
     * The amount of time in seconds between animation frames
     */
    protected final double TIME_BETWEEN_FRAMES = 0.2;

    /**
     * The amount of time in seconds between movements of the enemy
     */
    protected final double TIME_BETWEEN_MOVES = 1;

    /**
     * The current sprite to be rendered on calling the draw method
     */
    protected PImage currSprite;

    /**
     * The map the enemy is moving on
     */
    protected Map map;

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
