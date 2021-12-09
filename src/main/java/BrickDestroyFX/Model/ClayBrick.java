package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Creates Claybricks
 */
public class ClayBrick extends Brick {

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = Color.rgb(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;

    /**
     * Clay brick properties
     * @param point x and y coordinates
     * @param size length and width
     */
    public ClayBrick(Point2D point, Dimension2D size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, CLAY_STRENGTH);
    }

    /**
     * make clay bricks brickface
     * @param pos x and y coordinates of the brick.
     * @param size brick's size
     * @return clay brick created
     */
    @Override
    public Shape makeBrickFace(Point2D pos, Dimension2D size) {
        return new Rectangle(pos.getX(), pos.getY(), size.getWidth(), size.getHeight());
    }// used by brick, abstract method from brick

    /**
     * get clay brick brickface
     * @return clay brick brickface
     */
    @Override
    public Shape getBrick() {
        return super.getBrickFace();
    } // abstract method provided by brick.  USed by game board.

    /**
     * Animation for Crack
     * @return null as this brick does not crack
     */
    @Override
    public Path getpath() {
        return null;
    }

}
