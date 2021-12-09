package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Creates rubber ball
 */
public class RubberBall extends Ball {
    private static final int DEF_RADIUS = 10;
    private static final Color DEF_INNER_COLOR = Color.rgb(255, 219, 88);

    private static final Color DEF_BORDER_COLOR = DEF_INNER_COLOR.darker().darker();

    /**
     * constructor to define rubber ball
     * @param center x and y coordinate of the ball
     */
    public RubberBall(Point2D center) {
        super(center, DEF_RADIUS, DEF_RADIUS, DEF_INNER_COLOR, DEF_BORDER_COLOR);
    } // constructor to instantiate ball properties into superclass.

    /**
     * Makes a ball
     * @param center coordinates of the Ball at the center.
     * @param radiusA ball radius from the top to bottom..
     * @param radiusB ball radius from left to right.
     * @return newly created ball
     */
    @Override
    protected Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - (radiusA / 2);
        double y = center.getY() - (radiusB / 2);

        return new Circle(x, y, radiusA);
    } //abstract class from ball to make ball.
}

