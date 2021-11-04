package demolition.moveables;

import demolition.App;
import demolition.Bomb;
import demolition.Direction;
import demolition.GameController;
import demolition.Map;

import processing.core.PImage;

public class Player extends Moveable {
    public int lives = 3;
    public int spriteNum = 0;
    public int timer = 0;
    public final double TIME_BETWEEN_FRAMES = 0.2;
    public PImage currSprite;
    public static PImage[][] sprites = new PImage[4][4];

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
    public void loseLife(GameController gameController) {
        lives--;
        gameController.reMap();
    }

    /**
     * Will create a new bomb and place it onto the game map. This funtion stops multiple bombs being on one tile simultaneously.
     *
     *
     * @param map       The map the bomb is to be placed onto
     */
    public void dropBomb(Map map) {
        // comment out following loop to allow multiple bombs on one tile simultaneously
        for (Bomb bomb : map.bombs) {
            if (bomb.getX() == x && bomb.getY() == y + 16) {
                return;
            }
        }

        new Bomb(x, y, map);
    }
}
