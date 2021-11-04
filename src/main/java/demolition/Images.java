package demolition;

import processing.core.PApplet;

import demolition.Tiles.*;
import demolition.moveables.Player;
import demolition.moveables.RedEnemy;
import demolition.moveables.YellowEnemy;

/**
 * Images class, loads all images/sprites needed for the game
 */
public class Images  {

    /**
     * Loads PImages to their respective classes
     * @param app   the application to load the images
     */
    public static void loadImages(PApplet app) {

        //load Player
        // left
        Player.sprites[0][0] = app.loadImage("src/main/resources/player/player_left1.png");
        Player.sprites[0][1] = app.loadImage("src/main/resources/player/player_left2.png");
        Player.sprites[0][2] = app.loadImage("src/main/resources/player/player_left3.png");
        Player.sprites[0][3] = app.loadImage("src/main/resources/player/player_left4.png");
        // up
        Player.sprites[1][0] = app.loadImage("src/main/resources/player/player_up1.png");
        Player.sprites[1][1] = app.loadImage("src/main/resources/player/player_up2.png");
        Player.sprites[1][2] = app.loadImage("src/main/resources/player/player_up3.png");
        Player.sprites[1][3] = app.loadImage("src/main/resources/player/player_up4.png");
        // right
        Player.sprites[2][0] = app.loadImage("src/main/resources/player/player_right1.png");
        Player.sprites[2][1] = app.loadImage("src/main/resources/player/player_right2.png");
        Player.sprites[2][2] = app.loadImage("src/main/resources/player/player_right3.png");
        Player.sprites[2][3] = app.loadImage("src/main/resources/player/player_right4.png");
        // down
        Player.sprites[3][0] = app.loadImage("src/main/resources/player/player1.png");
        Player.sprites[3][1] = app.loadImage("src/main/resources/player/player2.png");
        Player.sprites[3][2] = app.loadImage("src/main/resources/player/player3.png");
        Player.sprites[3][3] = app.loadImage("src/main/resources/player/player4.png");



        // Red Enemy
        // left
        RedEnemy.sprites[0][0] = app.loadImage("src/main/resources/red_enemy/red_left1.png");
        RedEnemy.sprites[0][1] = app.loadImage("src/main/resources/red_enemy/red_left2.png");
        RedEnemy.sprites[0][2] = app.loadImage("src/main/resources/red_enemy/red_left3.png");
        RedEnemy.sprites[0][3] = app.loadImage("src/main/resources/red_enemy/red_left4.png");
        // upred_enemyred
        RedEnemy.sprites[1][0] = app.loadImage("src/main/resources/red_enemy/red_up1.png");
        RedEnemy.sprites[1][1] = app.loadImage("src/main/resources/red_enemy/red_up2.png");
        RedEnemy.sprites[1][2] = app.loadImage("src/main/resources/red_enemy/red_up3.png");
        RedEnemy.sprites[1][3] = app.loadImage("src/main/resources/red_enemy/red_up4.png");
        // rightred_enemyred
        RedEnemy.sprites[2][0] = app.loadImage("src/main/resources/red_enemy/red_right1.png");
        RedEnemy.sprites[2][1] = app.loadImage("src/main/resources/red_enemy/red_right2.png");
        RedEnemy.sprites[2][2] = app.loadImage("src/main/resources/red_enemy/red_right3.png");
        RedEnemy.sprites[2][3] = app.loadImage("src/main/resources/red_enemy/red_right4.png");
        // downred_enemyred
        RedEnemy.sprites[3][0] = app.loadImage("src/main/resources/red_enemy/red_down1.png");
        RedEnemy.sprites[3][1] = app.loadImage("src/main/resources/red_enemy/red_down2.png");
        RedEnemy.sprites[3][2] = app.loadImage("src/main/resources/red_enemy/red_down3.png");
        RedEnemy.sprites[3][3] = app.loadImage("src/main/resources/red_enemy/red_down4.png");

        // Yellow Enemy
        // left
        YellowEnemy.sprites[0][0] = app.loadImage("src/main/resources/yellow_enemy/yellow_left1.png");
        YellowEnemy.sprites[0][1] = app.loadImage("src/main/resources/yellow_enemy/yellow_left2.png");
        YellowEnemy.sprites[0][2] = app.loadImage("src/main/resources/yellow_enemy/yellow_left3.png");
        YellowEnemy.sprites[0][3] = app.loadImage("src/main/resources/yellow_enemy/yellow_left4.png");

        YellowEnemy.sprites[1][0] = app.loadImage("src/main/resources/yellow_enemy/yellow_up1.png");
        YellowEnemy.sprites[1][1] = app.loadImage("src/main/resources/yellow_enemy/yellow_up2.png");
        YellowEnemy.sprites[1][2] = app.loadImage("src/main/resources/yellow_enemy/yellow_up3.png");
        YellowEnemy.sprites[1][3] = app.loadImage("src/main/resources/yellow_enemy/yellow_up4.png");

        YellowEnemy.sprites[2][0] = app.loadImage("src/main/resources/yellow_enemy/yellow_right1.png");
        YellowEnemy.sprites[2][1] = app.loadImage("src/main/resources/yellow_enemy/yellow_right2.png");
        YellowEnemy.sprites[2][2] = app.loadImage("src/main/resources/yellow_enemy/yellow_right3.png");
        YellowEnemy.sprites[2][3] = app.loadImage("src/main/resources/yellow_enemy/yellow_right4.png");

        YellowEnemy.sprites[3][0] = app.loadImage("src/main/resources/yellow_enemy/yellow_down1.png");
        YellowEnemy.sprites[3][1] = app.loadImage("src/main/resources/yellow_enemy/yellow_down2.png");
        YellowEnemy.sprites[3][2] = app.loadImage("src/main/resources/yellow_enemy/yellow_down3.png");
        YellowEnemy.sprites[3][3] = app.loadImage("src/main/resources/yellow_enemy/yellow_down4.png");

        // load tiles
        BreakableTile.sprite = app.loadImage("src/main/resources/broken/broken.png");
        SolidTile.sprite = app.loadImage("src/main/resources/wall/solid.png");
        EmptyTile.sprite = app.loadImage("src/main/resources/empty/empty.png");
        GoalTile.sprite = app.loadImage("src/main/resources/goal/goal.png");

        // Bombs, Explosions
        Bomb.sprites[0] = app.loadImage("src/main/resources/bomb/bomb1.png");
        Bomb.sprites[1] = app.loadImage("src/main/resources/bomb/bomb2.png");
        Bomb.sprites[2] = app.loadImage("src/main/resources/bomb/bomb3.png");
        Bomb.sprites[3] = app.loadImage("src/main/resources/bomb/bomb4.png");
        Bomb.sprites[4] = app.loadImage("src/main/resources/bomb/bomb5.png");
        Bomb.sprites[5] = app.loadImage("src/main/resources/bomb/bomb6.png");
        Bomb.sprites[6] = app.loadImage("src/main/resources/bomb/bomb7.png");
        Bomb.sprites[7] = app.loadImage("src/main/resources/bomb/bomb8.png");

        Explosion.sprites[0] = app.loadImage("src/main/resources/explosion/centre.png");
        Explosion.sprites[1] = app.loadImage("src/main/resources/explosion/horizontal.png");
        Explosion.sprites[2] = app.loadImage("src/main/resources/explosion/vertical.png");

        // Extra Icons
        GameController.clock = app.loadImage("src/main/resources/icons/clock.png");
        GameController.playerFace = app.loadImage("src/main/resources/icons/player.png");

    }
}
