package demolition.moveables;

import demolition.Direction;
import demolition.Map;
import processing.core.PImage;

/**
 * RedEnemy class, used to implement red enemies with thier random movement AI
 */
public class RedEnemy extends Enemy {
    /**
     * A list of all the sprites for RedEnemy organised as each direction having a list of its
     * individual frames/animation sprites
     */
    public static PImage[][] sprites = new PImage[4][4];

    /**
     * Class constructor.
     *
     * Initialises red Enemy on map at (x,y) coordinates and first sprite set
     * @param x         the x-coordinate of the RedEnemy
     * @param y         the y-coordinate of the RedEnemy
     * @param map       the map the enemy is placed onto
     */
    public RedEnemy(int x, int y, Map map) {
        super(x, y, map);
        this.currSprite = sprites[3][0];
    }

    /**
     * Runs at gametick to change enemy sprites, move enemy and change the enemy's direction in a random direction that is passable whenever it hits a wall
      */
    @Override
    public void tick() {
        moveTimer++;
        if (moveTimer > TIME_BETWEEN_MOVES * 60) {
            boolean moved = false;

            while (!moved) {
                if (direction == Direction.LEFT) {
                    moved = moveLeft(map);
                } else if (direction == Direction.UP) {
                    moved = moveUp(map);
                } else if (direction == Direction.RIGHT) {
                    moved = moveRight(map);
                } else if (direction == Direction.DOWN) {
                    moved = moveDown(map);
                }
                if (!moved) {
                    direction = Direction.getRandomDirection();
                }
            }
            moveTimer = 0;
        }

        timer++;

        if (timer > TIME_BETWEEN_FRAMES * 60) {
            spriteNum = ((spriteNum + 1) % 4);
            timer = 0;
        }
        if (direction == Direction.LEFT) {
            currSprite = sprites[0][spriteNum];
        } else if (direction == Direction.UP) {
            currSprite = sprites[1][spriteNum];
        } else if (direction == Direction.RIGHT) {
            currSprite = sprites[2][spriteNum];
        } else if (direction == Direction.DOWN) {
            currSprite = sprites[3][spriteNum];
        }
    }

}
