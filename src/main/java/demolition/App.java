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

    public Player player;

    private Map map;
    private boolean[] pressedKeys = new boolean[4];



    public App() {
        //TODO can only show a single level.
        this.map = new Map("level1.txt", this);

    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void setup() {
        frameRate(FPS);
        // Load images during setup

        //load Player
        // left
        Player.sprites[0][0] = this.loadImage("src/main/resources/player/player_left1.png");
        Player.sprites[0][1] = this.loadImage("src/main/resources/player/player_left2.png");
        Player.sprites[0][2] = this.loadImage("src/main/resources/player/player_left3.png");
        Player.sprites[0][3] = this.loadImage("src/main/resources/player/player_left4.png");
        // up
        Player.sprites[1][0] = this.loadImage("src/main/resources/player/player_up1.png");
        Player.sprites[1][1] = this.loadImage("src/main/resources/player/player_up2.png");
        Player.sprites[1][2] = this.loadImage("src/main/resources/player/player_up3.png");
        Player.sprites[1][3] = this.loadImage("src/main/resources/player/player_up4.png");
        // right
        Player.sprites[2][0] = this.loadImage("src/main/resources/player/player_right1.png");
        Player.sprites[2][1] = this.loadImage("src/main/resources/player/player_right2.png");
        Player.sprites[2][2] = this.loadImage("src/main/resources/player/player_right3.png");
        Player.sprites[2][3] = this.loadImage("src/main/resources/player/player_right4.png");
        // down
        Player.sprites[3][0] = this.loadImage("src/main/resources/player/player1.png");
        Player.sprites[3][1] = this.loadImage("src/main/resources/player/player2.png");
        Player.sprites[3][2] = this.loadImage("src/main/resources/player/player3.png");
        Player.sprites[3][3] = this.loadImage("src/main/resources/player/player4.png");



        // Red Enemy
        // left
        RedEnemy.sprites[0][0] = this.loadImage("src/main/resources/red_enemy/red_left1.png");
        RedEnemy.sprites[0][1] = this.loadImage("src/main/resources/red_enemy/red_left2.png");
        RedEnemy.sprites[0][2] = this.loadImage("src/main/resources/red_enemy/red_left3.png");
        RedEnemy.sprites[0][3] = this.loadImage("src/main/resources/red_enemy/red_left4.png");
        // upred_enemyred
        RedEnemy.sprites[1][0] = this.loadImage("src/main/resources/red_enemy/red_up1.png");
        RedEnemy.sprites[1][1] = this.loadImage("src/main/resources/red_enemy/red_up2.png");
        RedEnemy.sprites[1][2] = this.loadImage("src/main/resources/red_enemy/red_up3.png");
        RedEnemy.sprites[1][3] = this.loadImage("src/main/resources/red_enemy/red_up4.png");
        // rightred_enemyred
        RedEnemy.sprites[2][0] = this.loadImage("src/main/resources/red_enemy/red_right1.png");
        RedEnemy.sprites[2][1] = this.loadImage("src/main/resources/red_enemy/red_right2.png");
        RedEnemy.sprites[2][2] = this.loadImage("src/main/resources/red_enemy/red_right3.png");
        RedEnemy.sprites[2][3] = this.loadImage("src/main/resources/red_enemy/red_right4.png");
        // downred_enemyred
        RedEnemy.sprites[3][0] = this.loadImage("src/main/resources/red_enemy/red_down1.png");
        RedEnemy.sprites[3][1] = this.loadImage("src/main/resources/red_enemy/red_down2.png");
        RedEnemy.sprites[3][2] = this.loadImage("src/main/resources/red_enemy/red_down3.png");
        RedEnemy.sprites[3][3] = this.loadImage("src/main/resources/red_enemy/red_down4.png");

        // Yellow Enemy
        // left
        YellowEnemy.sprites[0][0] = this.loadImage("src/main/resources/yellow_enemy/yellow_left1.png");
        YellowEnemy.sprites[0][1] = this.loadImage("src/main/resources/yellow_enemy/yellow_left2.png");
        YellowEnemy.sprites[0][2] = this.loadImage("src/main/resources/yellow_enemy/yellow_left3.png");
        YellowEnemy.sprites[0][3] = this.loadImage("src/main/resources/yellow_enemy/yellow_left4.png");

        YellowEnemy.sprites[1][0] = this.loadImage("src/main/resources/yellow_enemy/yellow_up1.png");
        YellowEnemy.sprites[1][1] = this.loadImage("src/main/resources/yellow_enemy/yellow_up2.png");
        YellowEnemy.sprites[1][2] = this.loadImage("src/main/resources/yellow_enemy/yellow_up3.png");
        YellowEnemy.sprites[1][3] = this.loadImage("src/main/resources/yellow_enemy/yellow_up4.png");

        YellowEnemy.sprites[2][0] = this.loadImage("src/main/resources/yellow_enemy/yellow_right1.png");
        YellowEnemy.sprites[2][1] = this.loadImage("src/main/resources/yellow_enemy/yellow_right2.png");
        YellowEnemy.sprites[2][2] = this.loadImage("src/main/resources/yellow_enemy/yellow_right3.png");
        YellowEnemy.sprites[2][3] = this.loadImage("src/main/resources/yellow_enemy/yellow_right4.png");

        YellowEnemy.sprites[3][0] = this.loadImage("src/main/resources/yellow_enemy/yellow_down1.png");
        YellowEnemy.sprites[3][1] = this.loadImage("src/main/resources/yellow_enemy/yellow_down2.png");
        YellowEnemy.sprites[3][2] = this.loadImage("src/main/resources/yellow_enemy/yellow_down3.png");
        YellowEnemy.sprites[3][3] = this.loadImage("src/main/resources/yellow_enemy/yellow_down4.png");

        // load tiles
        BreakableTile.sprite = this.loadImage("src/main/resources/broken/broken.png");
        SolidTile.sprite = this.loadImage("src/main/resources/wall/solid.png");
        EmptyTile.sprite = this.loadImage("src/main/resources/empty/empty.png");
        GoalTile.sprite = this.loadImage("src/main/resources/goal/goal.png");

    }

    public void draw() {
        background(255, 128, 0);
        this.map.tick();
        this.map.draw(this);
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
