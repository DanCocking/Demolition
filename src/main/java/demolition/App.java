package demolition;

import processing.core.PApplet;
import processing.core.PFont;



public class App extends PApplet {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;

    public static final int FPS = 60;

    public Player player;

    public GameController gameController;
    private boolean[] pressedKeys = new boolean[5];


    /**
     * Class constructor.
     * The method initialises the Game Controller
     */
    public App() {
        //TODO can only show a single level.
        this.gameController = new GameController("config.json", this);
        this.player = gameController.player;
    }

    /**
     * The method sets the size of the application
     */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * The method sets the framerate, loads images, loads and sets the font
     */
    public void setup() {
        frameRate(FPS);
        // Load images during setup
        Images.loadImages(this);
        PFont press = createFont("PressStart2P-Regular.ttf", 20);
        textFont(press);
    }

    /**
     * Draws background and draws game controller
     * Calls game controller's draw() method
     */
    public void draw() {
        background(239, 129, 0);
        this.gameController.tick();
        this.gameController.draw();
    }

    /**
     * Reads keyboards input.
     * Moves player LEFT on left key, RIGHT on right key, UP on up key, DOWN on down key and drops bomb on SPACE key.
     */
    public void keyPressed() {
        // Left: 37
        // Up: 38
        // Right: 39
        // Down: 40

        if (this.keyCode == 37 && !pressedKeys[0]) {
            this.player.moveLeft(gameController.map);
            pressedKeys[0] = true;
        } else if (this.keyCode == 38 && !pressedKeys[1]) {
            this.player.moveUp(gameController.map);
            pressedKeys[1] = true;
        } else if (this.keyCode == 39 && !pressedKeys[2]) {
            this.player.moveRight(gameController.map);
            pressedKeys[2] = true;
        } else if (this.keyCode == 40 && !pressedKeys[3]) {
            this.player.moveDown(gameController.map);
            pressedKeys[3] = true;
        } else if (this.keyCode == 32 && !pressedKeys[4]) {
            this.player.dropBomb(gameController.map);
            pressedKeys[4] = true;
        }
    }

    /**
     * Reads keyboard input to ensure that input may not be held down.
     * Will prevent user from moving in any direction (or dropping bombs) without first releasing that key. They may give any other input whilst one is held down however.
     */
    public void keyReleased() {
        // Left: 37
        // Up: 38
        // Right: 39
        // Down: 40
        if (this.keyCode == 37) {
            pressedKeys[0] = false;
        } else if (this.keyCode == 38) {
            pressedKeys[1] = false;
        } else if (this.keyCode == 39) {
            pressedKeys[2] = false;
        } else if (this.keyCode == 40) {
            pressedKeys[3] = false;
        } else if (this.keyCode == 32) {
            pressedKeys[4] = false;
        }
    }


    /**
     * Main method ran on start
     * @param args  the command-line arguments given
     */
    public static void main(String[] args) {
        PApplet.main("demolition.App");
    }
}
