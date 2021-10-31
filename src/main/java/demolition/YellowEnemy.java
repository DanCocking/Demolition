package demolition;

import processing.core.PImage;

public class YellowEnemy extends Enemy {
    static PImage[][] sprites = new PImage[4][4];

    YellowEnemy(int x, int y) {
        super(x, y);
        this.currSprite = sprites[3][0];
    }
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
    public boolean explode() {
        return loseLife();
    }
}
