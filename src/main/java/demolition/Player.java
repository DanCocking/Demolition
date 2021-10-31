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

    public Player(int x, int y, int lives) {
        super(x,y);
        this.lives = lives;
    }

    public void setSprite(PImage sprite) {
        this.currSprite = sprite;
    }

    public void draw(PApplet app) {
        // The image() method is used to draw PImages onto the screen.
        // The first argument is the image, the second and third arguments are coordinates
        app.image(this.currSprite, this.x, this.y);
    }

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


    public boolean loseLife(GameController gameController) {
        // TODO Auto-generated method stub
        lives--;
        gameController.reMap();
        return true;
    }

    public boolean explode() {
         return false;
    }


    public void dropBomb(Map map) {
        for (Bomb bomb : map.bombs) {
            if (bomb.x == x && bomb.y == y + 16) {
                return;
            }
        }
        Bomb bomb = new Bomb(x, y, map);
    }
}
