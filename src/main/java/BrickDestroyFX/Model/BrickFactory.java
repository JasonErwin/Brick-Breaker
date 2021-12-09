package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

/**
 * this class is the brick factory design pattern.
 */
public class BrickFactory {
    /**
     * This method creates the bricks.
     * @param point coordinate of the brick
     * @param size  length and width of the brick
     * @param type what type of brick
     * @return
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