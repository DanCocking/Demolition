package demolition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import demolition.Tiles.*;
import demolition.moveables.*;


public class CheckDefaultMapToAppMapHelper {


    public static void checkMap(String path, App app) {
        File file = new File(path);
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
    }
}
