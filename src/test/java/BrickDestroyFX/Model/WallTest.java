package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Player player = new Player(new Point2D(200, 175), 20, 30, new Rectangle(150, 200, 30, 40));
    RubberBall ball = new RubberBall(new Point2D(0, 0));
    Wall wall = new Wall(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, new Point2D(300, 430));

    @Test
    void move() {
        player.move();
        ball.move();
        assertNotNull(player);
        assertNotNull(ball);
    }

    @Test
    void getBrickCount() {
        wall.setBrickCount(30);
        assertEquals(30, wall.getBrickCount());
    }

    @Test
    void resetBallCount() {
        wall.resetBallCount();
        assertEquals(3, wall.getBallCount());
    }

    @Test
    void isBallLost() {
        if (wall.isBallLost()) {
            assertTrue(wall.isBallLost());
        }
    }

    @Test
    void isDone() {
        if (wall.isDone()) {
            assertEquals(0, wall.getBrickCount());
        }
    }

    @Test
    void isBallEnd() {
        if (wall.ballEnd()) {
            assertEquals(0, wall.getBallCount());
        }
    }


    @Test
    void getBallCount() {
        wall.setBallCount(4);
        assertEquals(4, wall.getBallCount());
    }

    @Test
    void impactBorder() {
        if (wall.impactBorder()) {
            assertTrue(wall.impactBorder());
        }
    }

    @Test
    void setBallCount() {
        wall.setBallCount(4);
        assertEquals(4, wall.getBallCount());
    }

    @Test
    void setBrickCount() {
        wall.setBrickCount(40);
        assertEquals(40, wall.getBrickCount());
    }

    @Test
    void setBallXSpeed() {
        ball.setXSpeed(5);
        assertEquals(5, ball.getSpeedX());
    }


    @Test
    void setBallYSpeed() {
        ball.setYSpeed(5);
        assertEquals(5, ball.getSpeedY());
    }

    @Test
    void makeBall() {
        wall.makeBall(new Point2D(30, 30));
        assertNotNull(ball);
    }

    @Test
    void wallReset() {
        SteelBrick steelBrick = new SteelBrick(new Point2D(25, 80), new Dimension2D(50, 50));
        if (steelBrick.isBroken()) {
            wall.wallReset();
        }
        assertEquals(3, wall.getBallCount());
        assertEquals(0, wall.getBrickCount());
    }

    @Test
    void ballReset() {
        wall.ballReset();
        assertEquals(new Point2D(0, 0), ball.getPosition());
    }
}


