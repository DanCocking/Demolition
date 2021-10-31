package demolition;

import processing.core.PImage;

public class YellowEnemy extends Enemy {
    static PImage[][] sprites = new PImage[4][4];

        /**
     * Class constructor.
     *
     * Initialises yellow enemy on map at (x,y) coordinates and first sprite set
     * @param x         the x-coordinate of the YellowEnemy
     * @param y         the y-coordinate of the YellowEnemy
     * @param map       the map the enemy is placed onto
     */
    YellowEnemy(int x, int y, Map map) {
        super(x, y, map);
        this.currSprite = sprites[3][0];
    }

    /**
     * Runs at gametick to change enemy sprites, move enemy and rotate the enemy clockwise whenever it hits a wall
      */
    @Override
    public void tick() {
        moveTimer++;
        if (moveTimer > TIME_BETWEEN_MOVES * 60) {
            boolean moved = false;

            while (!moved) {
                if (direction == Direction.left) {
                    moved = moveLeft(map);
                } else if (direction == Direction.up) {
                    moved = moveUp(map);
                } else if (direction == Direction.right) {
                    moved = moveRight(map);
                } else if (direction == Direction.down) {
                    moved = moveDown(map);
                }
                if (!moved) {
                    direction =  direction.turn();
                }
            }
            moveTimer = 0;
        }

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

}
