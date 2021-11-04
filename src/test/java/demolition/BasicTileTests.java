package demolition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import demolition.Tiles.*;

public class BasicTileTests {
    BreakableTile breakableTile = new BreakableTile(0, 0);
    EmptyTile emptyTile = new EmptyTile(0, 0);
    GoalTile goalTile = new GoalTile(0, 0);
    SolidTile solidTile = new SolidTile(67, 143);

    @Test
    public void stopsExplosionsTest() {
        assertTrue(breakableTile.stopsExplosions());
        assertTrue(solidTile.stopsExplosions());

        assertFalse(emptyTile.stopsExplosions());
        assertFalse(goalTile.stopsExplosions());
    }

    @Test
    public void isBreakableTest() {
        assertTrue(breakableTile.isBreakable());
        assertTrue(emptyTile.isBreakable());
        assertTrue(goalTile.isBreakable());

        assertFalse(solidTile.isBreakable());
    }

    @Test
    public void isPassableTest() {
        assertTrue(emptyTile.isPassable());
        assertTrue(goalTile.isPassable());

        assertFalse(breakableTile.isPassable());
        assertFalse(solidTile.isPassable());
    }

    @Test
    public void getCoordinateTest() {
        assertEquals(67, solidTile.getX());
        assertEquals(143, solidTile.getY());

    }


}
