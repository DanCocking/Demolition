package demolition;

import demolition.moveables.Player;
import processing.core.PApplet;
import processing.core.PFont;


/**
 * App class, initiates the running and setup of the entire application as well as managing user input
 */
public class App extends PApplet {

    private static final int WIDTH = 480;
    private static final int HEIGHT = 480;
    private static final int FPS = 60;

    private Player player;
    private boolean[] pressedKeys = new boolean[5];
    private String config = "config.json";

    /**
     * The Logic handler of the game, contains the level(Map) as well as all other parts of game logic and drawing
     */
    public GameController gameController;



    /**
     * Class constructor.
     */
    public App() {

    }

    /**
     * The method sets the size of the application
     */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * The method sets the framerate, loads images, loads and sets the font
     * The method initialises the Game Controller
     */
    public void setup() {
        frameRate(FPS);
        // Load images during setup
        Images.loadImages(this);
        PFont press = createFont("PressStart2P-Regular.ttf", 20);
        textFont(press);

        this.gameController = new GameController(config, this);
        this.player = gameController.player;
    }

    /**
     * Draws background and draws game controller
     * Calls game controller's tick() and draw() method
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
     * The method sets the config fule of the App
     * @param path  The path to the config file
     */
    public void setConfig(String path) {
        this.config = path;
    }


    /**
     * Main method ran on start
     * @param args  the command-line arguments given
     */
    public static void main(String[] args) {
        PApplet.main("demolition.App");
    }
}
