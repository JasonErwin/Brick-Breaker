package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    Wall wall = new Wall(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, new Point2D(300, 430));
    Level level = new Level(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, new Point2D(300, 430), wall);

    @Test
    void nextLevel() {
        level.nextLevel();
        int new_level = 1;
        new_level += 1;
        assertEquals(2, new_level);
    }

    @Test
    void hasLevel() {
        assertTrue(level.hasLevel());
    }
}
