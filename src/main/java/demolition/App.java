package demolition;

import demolition.Tiles.BreakableTile;
import demolition.Tiles.EmptyTile;
import demolition.Tiles.GoalTile;
import demolition.Tiles.SolidTile;
import processing.core.PApplet;


public class App extends PApplet {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;

    public static final int FPS = 60;

    private Player player;
    private Map map;
    private boolean[] pressedKeys = new boolean[4];



    public App() {
        this.player = new Player(32, 96);

        //TODO can only show a single level.
        this.map = new Map("level1.txt");
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void setup() {
        frameRate(FPS);
        // Load images during setup

        //load Player
        // left
        player.sprites[0][0] = this.loadImage("src/main/resources/player/player_left1.png");
        player.sprites[0][1] = this.loadImage("src/main/resources/player/player_left2.png");
        player.sprites[0][2] = this.loadImage("src/main/resources/player/player_left3.png");
        player.sprites[0][3] = this.loadImage("src/main/resources/player/player_left4.png");
        // up
        player.sprites[1][0] = this.loadImage("src/main/resources/player/player_up1.png");
        player.sprites[1][1] = this.loadImage("src/main/resources/player/player_up2.png");
        player.sprites[1][2] = this.loadImage("src/main/resources/player/player_up3.png");
        player.sprites[1][3] = this.loadImage("src/main/resources/player/player_up4.png");
        // right
        player.sprites[2][0] = this.loadImage("src/main/resources/player/player_right1.png");
        player.sprites[2][1] = this.loadImage("src/main/resources/player/player_right2.png");
        player.sprites[2][2] = this.loadImage("src/main/resources/player/player_right3.png");
        player.sprites[2][3] = this.loadImage("src/main/resources/player/player_right4.png");
        // down
        player.sprites[3][0] = this.loadImage("src/main/resources/player/player1.png");
        player.sprites[3][1] = this.loadImage("src/main/resources/player/player2.png");
        player.sprites[3][2] = this.loadImage("src/main/resources/player/player3.png");
        player.sprites[3][3] = this.loadImage("src/main/resources/player/player4.png");

        // load tiles
        BreakableTile.sprite = this.loadImage("src/main/resources/broken/broken.png");
        SolidTile.sprite = this.loadImage("src/main/resources/wall/solid.png");
        EmptyTile.sprite = this.loadImage("src/main/resources/empty/empty.png");
        GoalTile.sprite = this.loadImage("src/main/resources/goal/goal.png");

    }

    public void draw() {
        background(255, 128, 0);
        this.map.tick();
        this.player.tick();
        this.map.draw(this);
        this.player.draw(this);


    }

    public void keyPressed() {
        // Left: 37
        // Up: 38
        // Right: 39
        // Down: 40

        if (this.keyCode == 37 && !pressedKeys[0]) {
            this.player.moveLeft(map);
            pressedKeys[0] = true;
        } else if (this.keyCode == 38 && !pressedKeys[1]) {
            this.player.moveUp(map);
            pressedKeys[1] = true;
        } else if (this.keyCode == 39 && !pressedKeys[2]) {
            this.player.moveRight(map);
            pressedKeys[2] = true;
        } else if (this.keyCode == 40 && !pressedKeys[3]) {
            this.player.moveDown(map);
            pressedKeys[3] = true;
        }
    }

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
        }
    }

    public static void main(String[] args) {
        PApplet.main("demolition.App");
    }
}
