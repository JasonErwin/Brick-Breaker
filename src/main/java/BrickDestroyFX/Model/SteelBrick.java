package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * Class for Steel Brick Properties
 */
public class SteelBrick extends Brick {
    private static final String NAME = "Steel Brick";
    private static final Color DEF_INNER = Color.rgb(203, 203, 201);
    private static final Color DEF_BORDER = Color.BLACK;
    private static final int STEEL_STRENGTH = 1;
    private static final double STEEL_PROBABILITY = 0.4;

    private Random rnd;
    private Shape brickFace;

    /**
     * Define SteelBrick's properties
     * @param point x and y coordinate of the steel brick
     * @param size width and height
     */
    public SteelBrick(Point2D point, Dimension2D size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, STEEL_STRENGTH);
        rnd = new Random();
        brickFace = super.getBrickFace();
    } // constructor to instantiate SteelBrick properties when it is called


    /**
     * Create a new steel brick block
     * @param pos x and y coordinates
     * @param size width and heights
     * @return new steel brick that has been generated
     */
    @Override
    protected Shape makeBrickFace(Point2D pos, Dimension2D size) {
        return new Rectangle(pos.getX(), pos.getY(), size.getWidth(), size.getHeight());
    } // used abstract method provided by brick

    /**
     * retrieve brickface of steelbrick
     * @return brickface to other classes
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    } // used abstract method provided by brick

    /**
     * Check whether there is impact with ball
     * @param point x and y coordinates
     * @param dir which direction
     * @return is there impact or not
     */
    public boolean setImpact(Point2D point, int dir) {
        if (super.isBroken())
            return false;
        impact();
        return super.isBroken();
    } //check whether SteelBrick has impact with Ball.

    /**
     * Defines what will happen after impact with ball
     */
    public void impact() {
        if (rnd.nextDouble() < STEEL_PROBABILITY) {
            super.impact();
        }
    }// impact method to check whether to destroy steel brick

    /**
     * Method to set crack animation
     * @return null as no crack animation needed.
     */
    @Override
    public Path getpath() {
        return null;
    }

}