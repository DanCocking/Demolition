package demolition;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import demolition.Tiles.EmptyTile;
import processing.core.PApplet;

public class PlayerTest {
    @Test
    public void loadFromConfig() {
        // Create an instance of your application
        App app = new App();

        // Set the program to not loop automatically
        app.noLoop();

        app.setConfig("src/test/resources/config.json");

        // Tell PApplet to create the worker threads for the program
        PApplet.runSketch(new String[] {"App"}, app);

        // Call App.setup() to load in sprites
        app.setup();

        // Set a 1 second delay to ensure all resources are loaded
        app.delay(1000);

        // Change level
        app.gameController.levelComplete();
        //check level
        CheckDefaultMapToAppMapHelper.checkMap("src/test/resources/level2.txt", app);

        assertEquals(32, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        app.delay(1000);
        for (int i = 0; i < 11; i++) {
            app.draw();
        }
        assertEquals(0, app.gameController.player.spriteNum);
        app.draw();
        assertEquals(1, app.gameController.player.spriteNum);

        assertEquals(Direction.DOWN, app.gameController.player.direction);



        // Left wall
        app.keyCode = 37;
        app.keyPressed();
        app.keyReleased();

        assertEquals(32, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.LEFT, app.gameController.player.direction);

        app.keyCode = 38;
        app.keyPressed();
        app.keyReleased();


        assertEquals(32, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.UP, app.gameController.player.direction);

        app.keyCode = 40;
        app.keyPressed();
        app.keyReleased();

        assertEquals(32, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.DOWN, app.gameController.player.direction);

        app.keyCode = 39;
        app.keyPressed();
        app.keyReleased();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.RIGHT, app.gameController.player.direction);

        app.keyCode = 38;
        app.keyPressed();
        app.keyReleased();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(208, app.gameController.player.getY());
        assertEquals(Direction.UP, app.gameController.player.direction);

        app.keyCode = 40;
        app.keyPressed();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.DOWN, app.gameController.player.direction);

        app.keyPressed();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.DOWN, app.gameController.player.direction);

        app.keyReleased();
        app.keyPressed();
        app.keyReleased();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(272, app.gameController.player.getY());
        assertEquals(Direction.DOWN, app.gameController.player.direction);


        app.keyCode = 38;
        app.keyPressed();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.UP, app.gameController.player.direction);

        app.keyPressed();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.UP, app.gameController.player.direction);

        app.keyReleased();
        app.keyPressed();
        app.keyReleased();

        assertEquals(64, app.gameController.player.getX());
        assertEquals(208, app.gameController.player.getY());
        assertEquals(Direction.UP, app.gameController.player.direction);

        // MOVE BACK DOWN
        app.keyCode = 40;
        app.keyPressed();
        app.keyReleased();


        app.keyCode = 39;
        app.keyPressed();

        assertEquals(96, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.RIGHT, app.gameController.player.direction);

        app.keyPressed();

        assertEquals(96, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.RIGHT, app.gameController.player.direction);

        app.keyReleased();
        app.keyPressed();

        assertEquals(128, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.RIGHT, app.gameController.player.direction);

        app.keyReleased();
        app.keyPressed();

        assertEquals(160, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.RIGHT, app.gameController.player.direction);

        app.keyReleased();
        app.keyPressed();
        app.keyReleased();

        assertEquals(160, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.RIGHT, app.gameController.player.direction);


        // Drop Bomb
        app.keyCode = 32;
        app.keyPressed();
        app.keyReleased();
        assertTrue(app.gameController.map.bombs.get(0).getX() == 160 && app.gameController.map.bombs.get(0).getY() == 256);


        app.keyCode = 37;
        app.keyPressed();

        assertEquals(128, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.LEFT, app.gameController.player.direction);

        app.keyPressed();

        assertEquals(128, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.LEFT, app.gameController.player.direction);

        app.keyReleased();
        app.keyPressed();
        app.keyReleased();

        assertEquals(96, app.gameController.player.getX());
        assertEquals(240, app.gameController.player.getY());
        assertEquals(Direction.LEFT, app.gameController.player.direction);

        app.keyPressed();
        app.keyReleased();
        app.keyPressed();
        app.keyReleased();
        app.keyPressed();
        app.keyReleased();
        app.keyPressed();
        app.keyReleased();

        for (int index = 0; index < 1000; index++) {
            app.draw();
        }
        assertTrue(app.gameController.map.levelMap[6][6].getClass() == EmptyTile.class);

        app.keyCode = 39;
        for (int i = 0; i < 12; i++) {
            app.keyPressed();
            app.keyReleased();
        }
        app.draw();
        assertTrue(app.gameController.win);

    }
}
