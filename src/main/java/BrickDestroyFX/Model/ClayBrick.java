package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Clay Brick properties
 */
public class ClayBrick extends Brick {

    private static final String NAME = "Clay Brick";
    private static final Color DEF_INNER = Color.rgb(178, 34, 34).darker();
    private static final Color DEF_BORDER = Color.GRAY;
    private static final int CLAY_STRENGTH = 1;

    /**
     * Define ClayBrick Properties
     * @param point x and y coordinates of the clay brick
     * @param size width and height of the clay brick
     */
    public ClayBrick(Point2D point, Dimension2D size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, CLAY_STRENGTH);
    }

    /**
     * generate new clay bricks
     * @param pos x and y coordinates of clay bricks
     * @param size width and height of clay bricks
     * @return generated clay bricks
     */
    @Override
    public Shape makeBrickFace(Point2D pos, Dimension2D size) {
        return new Rectangle(pos.getX(), pos.getY(), size.getWidth(), size.getHeight());
    }// used by brick, abstract method from brick


    /**
     * retrieve clay brick's brickface
     * @return clay bricks's brickface
     */
    @Override
    public Shape getBrick() {
        return super.getBrickFace();
    } // abstract method provided by brick.  USed by game board.

    /**
     * Method to draw crack animation
     * @return null as no crack animation.
     */
    @Override
    public Path getpath() {
        return null;
    }

}
