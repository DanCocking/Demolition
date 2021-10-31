package demolition;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Enemy extends Moveable implements Displayed{
    public boolean alive = true;
    public int spriteNum = 0;
    public int timer = 0;
    public int moveTimer = 0;

    public final double TIME_BETWEEN_FRAMES = 0.2;
    public final double TIME_BETWEEN_MOVES = 1;

    public PImage currSprite;
    public Map map;

    public Enemy(int x, int y) {
        super(x,y);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSprite(PImage sprite) {
        this.currSprite = sprite;
    }

    public void draw(PApplet app) {
        // The image() method is used to draw PImages onto the screen.
        // The first argument is the image, the second and third arguments are coordinates
        // if (currSprite == null) {
        //     currSprite = sprites[3][0];
        // }

        app.image(currSprite, x, y);
    }

    public abstract void tick();

    @Override
    public boolean loseLife() {
        alive = false;
        return true;
    }
}




// moveTimer++;
// if (moveTimer > TIME_BETWEEN_MOVES * 60) {
//     boolean moved = false;

//     while (!moved) {
//         if (direction == Direction.left) {
//             moved = moveLeft(map);
//         } else if (direction == Direction.up) {
//             moved = moveUp(map);
//         } else if (direction == Direction.right) {
//             moved = moveRight(map);
//         } else if (direction == Direction.down) {
//             moved = moveDown(map);
//         }
//         if (!moved) {
//             direction = Direction.getRandomDirection();
//         }
//     }
//     moveTimer = 0;
// }


// timer++;

// if (timer > TIME_BETWEEN_FRAMES * 60) {
//     spriteNum = ((spriteNum + 1) % 4);
//     timer = 0;
// }
// if (direction == Direction.left) {
//     currSprite = sprites[0][spriteNum];
// } else if (direction == Direction.up) {
//     currSprite = sprites[1][spriteNum];
// } else if (direction == Direction.right) {
//     currSprite = sprites[2][spriteNum];
// } else if (direction == Direction.down) {
//     currSprite = sprites[3][spriteNum];
// }
