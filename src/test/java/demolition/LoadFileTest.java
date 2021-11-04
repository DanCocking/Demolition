package demolition;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import demolition.Tiles.*;
import demolition.moveables.Enemy;
import demolition.moveables.RedEnemy;
import demolition.moveables.YellowEnemy;
import processing.core.PApplet;

public class LoadFileTest {

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

        // Check position of Tiles
        File file = new File("src/test/resources/level1.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            assertTrue(false);
            return;
        }

        int row = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int column = 0;
            for (char character : line.toCharArray()) {

                if (character == 'W') {
                    assertTrue(app.gameController.map.levelMap[row][column].getClass() == SolidTile.class);
                    assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                    assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                } else if (character == 'B') {
                    assertTrue(app.gameController.map.levelMap[row][column].getClass() == BreakableTile.class);
                    assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                    assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                } else if (character == 'G') {
                    assertTrue(app.gameController.map.levelMap[row][column].getClass() == GoalTile.class);
                    assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                    assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                } else if (character == ' ') {
                    assertTrue(app.gameController.map.levelMap[row][column].getClass() == EmptyTile.class);
                    assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                    assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                }
                else  {

                    if (character == 'P') {
                        assertTrue(app.gameController.map.levelMap[row][column].getClass() == EmptyTile.class);
                        assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                        assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                        assertEquals(column *32,app.gameController.player.getX());
                        assertEquals(row *32 + 48,app.gameController.player.getY());

                    } else if (character == 'R') {
                        assertTrue(app.gameController.map.levelMap[row][column].getClass() == EmptyTile.class);
                        assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                        assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                        boolean check = false;
                        for (Enemy enemy : app.gameController.map.enemys) {
                            if (enemy.getClass() == RedEnemy.class && enemy.getX() == column *32 && enemy.getY() == row *32 + 48) {
                                check = true;
                                break;
                            }
                        }
                        assertTrue(check);
                    } else if (character == 'Y') {
                        assertTrue(app.gameController.map.levelMap[row][column].getClass() == EmptyTile.class);
                        assertEquals(column * 32, app.gameController.map.levelMap[row][column].getX());
                        assertEquals(row * 32 + 64, app.gameController.map.levelMap[row][column].getY());
                        boolean check = false;
                        for (Enemy enemy : app.gameController.map.enemys) {
                            if (enemy.getClass() == YellowEnemy.class && enemy.getX() == column *32 && enemy.getY() == row *32 + 48) {
                                check = true;
                                break;
                            }
                        }
                        assertTrue(check);
                    }
                }
                column++;
            }
            assertEquals(15, column);
            column = 0;
            row++;
        }

        assertEquals(13, row);
        scanner.close();



        // Verify the new state of the program with assertions



    }
}
