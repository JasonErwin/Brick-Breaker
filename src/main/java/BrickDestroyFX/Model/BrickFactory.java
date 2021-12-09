package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

/**
 * Brick Factory Implementation
 */
public class BrickFactory {
    /**
     * Methoda that makes bricks according to its type
     * @param point x and y coordinates of the bricks
     * @param size width and height of teh bricks
     * @param type what type of bricks to be created
     * @return new brick created
     */
    public Brick makeBrick(Point2D point, Dimension2D size, String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CLAY")) {
            return new ClayBrick(point, size);
        } else if (type.equalsIgnoreCase("CEMENT")) {
            return new CementBrick(point, size);
        } else if (type.equalsIgnoreCase("STEEL")) {
            return new SteelBrick(point, size);
        }
        return null;
    }
}