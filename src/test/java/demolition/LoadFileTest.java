package demolition;

import org.junit.jupiter.api.Test;

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
        
        // Call draw to update the program.
        app.draw();

        // Call keyPressed() or similar

        // Call draw again to move onto the next frame
        app.draw();

        // Verify the new state of the program with assertions

    }
}
