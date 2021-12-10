package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SteelBrickTest {

    SteelBrick steelBrick = new SteelBrick(new Point2D(25, 80), new Dimension2D(50, 50));

    @Test
    void impact() {
        Random rand = new Random();
        double STEEL_PROBABILITY = 0.3;
        if (rand.nextDouble() < STEEL_PROBABILITY) {
            assertFalse(steelBrick.isBroken());
        }
    }

}
