package demolition;

import processing.core.PApplet;
import processing.core.PImage;

public class Images extends PApplet {

    public Images() {
        setup();
    }

    PImage[] left;
    public void setup() {
        //load sprites
        // left
        left = new PImage[4];
        left[0] = this.loadImage("src/main/resources/player/player_left1.png");
        left[1] = this.loadImage("src/main/resources/player/player_left2.png");
        left[2] = this.loadImage("src/main/resources/player/player_left3.png");
        left[3] = this.loadImage("src/main/resources/player/player_left4.png");

    }
}
