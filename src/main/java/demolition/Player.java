package demolition;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends Moveable implements Displayed{
    public int lives = 3;
    public int spriteNum = 0;
    public int timer = 0;
    public final double TIME_BETWEEN_FRAMES = 0.2;
    public PImage currSprite;
    static PImage[][] sprites = new PImage[4][4];

    /**
     * Class constructor
     *
     * Initialises player at (x,y) coordinates with given number of lives
     *
     * @param x         the x-coordinate of the player
     * @param y         the y-coordinate of the player
     * @param lives     the number of lives that player starts with
     */
    public Player(int x, int y, int lives) {
        super(x,y);
        this.lives = lives;
    }

    /**
     * Draws player sprite to application window
     * @param app       the application window the player sprite is drawn to
     */
    public void draw(App app) {
        app.image(this.currSprite, this.x, this.y);
    }

    /**
     * Run on tick to update the player sprite to have correct direction and sprite
     */
    public void tick() {
        timer++;

        if (timer > TIME_BETWEEN_FRAMES * 60) {
            spriteNum = ((spriteNum + 1) % 4);
            timer = 0;
        }
        if (direction == Direction.left) {
            currSprite = sprites[0][spriteNum];
        } else if (direction == Direction.up) {
            currSprite = sprites[1][spriteNum];
        } else if (direction == Direction.right) {
            currSprite = sprites[2][spriteNum];
        } else if (direction == Direction.down) {
            currSprite = sprites[3][spriteNum];
        }
    }

    /**
     * The method subtracts a life and resets the map
     * Returns whether the method was succesful
     * @param gameController        the game controller with access to level maps to reset
     * @return                      the success of the method
     */
    public boolean loseLife(GameController gameController) {
        lives--;
        gameController.reMap();
        return true;
    }

    /**
     * Will create a new bomb and place it onto the game map
     *
     * @param map       The map the bomb is to be placed onto
     */
    public void dropBomb(Map map) {
        for (Bomb bomb : map.bombs) {
            if (bomb.x == x && bomb.y == y + 16) {
                return;
            }
        }
        Bomb bomb = new Bomb(x, y, map);
    }
}
