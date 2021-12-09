package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Class for rubber ball properties
 */
public class RubberBall extends Ball {
    private static final int DEF_RADIUS = 10;
    private static final Color DEF_INNER_COLOR = Color.rgb(255, 219, 88);

    private static final Color DEF_BORDER_COLOR = DEF_INNER_COLOR.darker().darker();


    /**
     * Define Rubber Ball Properties
     * @param center x and y coordinates at the center of the rubber ball.
     */
    public RubberBall(Point2D center) {
        super(center, DEF_RADIUS, DEF_RADIUS, DEF_INNER_COLOR, DEF_BORDER_COLOR);
    } // constructor to instantiate ball properties into superclass.


    /**
     * method to make the rubber ball
     * @param center x adn y coordinates of the ball
     * @param radiusA diameter of ball from top to down
     * @param radiusB diameter of ball from left tor right
     * @return new rubber ball that has been generated
     */
    @Override
    protected Shape makeBall(Point2D center, int radiusA, int radiusB) {

        double x = center.getX() - (radiusA / 2);
        double y = center.getY() - (radiusB / 2);

        return new Circle(x, y, radiusA);
    } //abstract class from ball to make ball.
}

