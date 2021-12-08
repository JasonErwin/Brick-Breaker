package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public class BrickFactory {
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