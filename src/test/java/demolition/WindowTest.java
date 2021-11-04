package demolition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    @Test
    public void heightTest() {
        assertEquals(480, App.HEIGHT);
    }

    @Test
    public void widthTest() {
        assertEquals(480, App.WIDTH);
    }

    @Test
    public void framerateTest() {
        assertEquals(60, App.FPS);
    }
}
