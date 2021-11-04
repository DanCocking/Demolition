package demolition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import demolition.moveables.Player;
import processing.core.PImage;
import processing.data.JSONObject;

/**
 * GameController class, controls the logic of the game as a whole, including time, player and the level generation and management
 */
public class GameController {
    private App app;
    private JSONObject config;
    private int time;
    private int level = 0;
    private int timer = 0;
    private boolean playing = true;

    /**
     * Tracks whether user has won the game or not
     */
    public boolean win = false;

    /**
     * holds the game state of the current level
     */
    Map map;

    /**
     * Stores image for the clock icon
     */
    static PImage clock;

    /**
     * Stores image for the playerFace icon
     */
    static PImage playerFace;

    /**
     * The player that is playing the game
     */
    public Player player;

    /**
     * Class constructor.
     *
     * Initialises game controller from config file, it creats a player with given number of lives, and a map and time given for the first level
     * @param configPath
     * @param app
     */
    GameController(String configPath, App app) {
        this.app = app;
        File f = new File(configPath);
        String configString = "";
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                configString += sc.next();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject config = JSONObject.parse(configString);
        this.config = config;
        int lives = config.getInt("lives");
        player = new Player(0, 0, lives);
        map = new Map(config.getJSONArray("levels").getJSONObject(0).getString("path"), app, this);
        time = config.getJSONArray("levels").getJSONObject(0).getInt("time");
    }

    /**
     * Runs tick on game controller
     * Measures time spent in the level and checks player has not lost
     */
    public void tick() {

        if (playing) {
            if (timer++ > 1 * 60) {
                time--;
                timer = 0;
            }

            map.tick();
            if (time <= 0 || player.lives <= 0) {
                gameOver();
            }
        }
    }

    /**
     * Draws all components of the game to application window
     */
    public void draw() {
        if (playing) {
            map.draw(app);
            app.image(clock, 345, 16);
            app.image(playerFace, 135, 16);
            app.text(time, 377, 43);
            app.fill(1);
            app.text(player.lives, 167, 43);
            app.fill(1);
        } else if (win) {
            app.text("YOU WIN", 170, 200);
            app.fill(1);
        } else {
            app.text("GAME OVER", 150, 200);
            app.fill(1);
        }

    }

    /**
     * Will create map of original config for a level.
     */
    public void reMap() {
        map = new Map(config.getJSONArray("levels").getJSONObject(level).getString("path"), app, this);

    }

    /**
     * Ran if game is lost, sets playing attribute to false
     */
    public void gameOver() {
        playing = false;
    }

    /**
     * Ran when a level is complete
     * Will load next level or run win method if no levels remain
     */
    public void levelComplete() {
        level++;
        if (level >= config.getJSONArray("levels").size()) {
            win();
        } else {
            reMap();
            time = config.getJSONArray("levels").getJSONObject(0).getInt("time");

        }

    }

    /**
     * Ran if player wins. Sets win attribute to true and playing to false
     */
    public void win() {
        playing = false;
        win = true;
    }
}
