package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = new Player(new Point2D(200, 175), 20, 30, new Rectangle(150, 200, 30, 40));


    @Test
    void moveLeft() {
        player.moveLeft();
        player.setMoveAmount(-10);
        assertEquals(-10, player.getMoveAmount());
    }

    @Test
    void moveRight() {
        player.movRight();
        player.setMoveAmount(10);
        assertEquals(10, player.getMoveAmount());
    }

    @Test
    void stop() {
        player.stop();
        player.setMoveAmount(0);
        assertEquals(0, player.getMoveAmount());
    }

    @Test
    void getWidth() {
        Rectangle playerFace = new Rectangle(15, 30, 45, 60);
        assertEquals(45, playerFace.getWidth());
    }

    @Test
    void getHeight() {
        Rectangle playerFace = new Rectangle(15, 30, 45, 60);
        assertEquals(60, playerFace.getHeight());
    }

    @Test
    void getX() {
        Rectangle playerFace = new Rectangle(15, 30, 45, 60);
        assertEquals(15, playerFace.getX());
    }

    @Test
    void getY() {
        Rectangle playerFace = new Rectangle(15, 30, 45, 60);
        assertEquals(30, playerFace.getY());
    }

    @Test
    void moveTo() {
        player.moveTo(new Point2D(250, 250));
        Point2D playerLocation = new Point2D(250 - (10 / 2), 250);
        assertEquals(new Point2D(245, 250), playerLocation);
    }

}
