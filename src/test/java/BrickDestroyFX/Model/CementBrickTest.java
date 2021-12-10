package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CementBrickTest {

    CementBrick cementBrick= new CementBrick(new Point2D(25,80),new Dimension2D(50,50));


    @Test
    void repair(){
        cementBrick.repair();
        assertFalse(cementBrick.isBroken());
    }

}
