package Brick_Destroy;

import java.awt.*;

public class BrickFactory {

    public Brick makeBrick(Point point, Dimension size, String type) {
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
    } //Factory used in Level Class.
}
