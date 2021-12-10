package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrackTest {

    CementBrick cementBrick = new CementBrick(new Point2D(30, 30), new Dimension2D(40, 20));
    Crack crack = new Crack(1, 35);

    @Test
    void draw() {
        crack.makeCrack(new Point2D(0, 0), new Point2D(50, 50));
        crack.draw();
        assertNotNull(crack);
    }

    @Test
    void reset() {
        crack.reset();
        assertFalse(cementBrick.isBroken());
    }


    @Test
    void makeCrack() {
        crack.makeCrack(new Point2D(0, 0), new Point2D(50, 50));
        crack.draw();
        assertNotNull(crack);
    }

}
