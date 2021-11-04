package demolition;

import demolition.moveables.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class BasicPlayerTest {

    @Test
    public void initPlayer() {
        Player player = new Player(12, 23, 5);
        assertEquals(12, player.getX());
        assertEquals(23, player.getY());
        assertEquals(5, player.lives);
    }
}
