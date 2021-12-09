package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * Steel Brick Class
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
     * define steel brick properties
     * @param point x and y coordinates
     * @param size length and height
     */
    public SteelBrick(Point2D point, Dimension2D size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, STEEL_STRENGTH);
        rnd = new Random();
        brickFace = super.getBrickFace();
    } // constructor to instantiate SteelBrick properties when it is called

    /**
     * This method creates a steel brick
     * @param pos x and y coordinates of the brick.
     * @param size brick's size
     * @return newly created steel brick
     */
    @Override
    protected Shape makeBrickFace(Point2D pos, Dimension2D size) {
        return new Rectangle(pos.getX(), pos.getY(), size.getWidth(), size.getHeight());
    } // used abstract method provided by brick

    /**
     * Get's steelbrick brickface
     * @return brickface
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    } // used abstract method provided by brick

    /**
     * check impact with ball and steelbrick
     * @param point position of the brick
     * @param dir direction the ball impacts the brick
     * @return whether balls impacts with steelbrick
     */
    public boolean setImpact(Point2D point, int dir) {
        if (super.isBroken())
            return false;
        impact();
        return super.isBroken();
    } //check whether SteelBrick has impact with Ball.

    /**
     * impact with ball method
     */
    public void impact() {
        if (rnd.nextDouble() < STEEL_PROBABILITY) {
            super.impact();
        }
    }// impact method to check whether to destroy steel brick

    /**
     * Crack animation method
     * @return null as no crack animation
     */
    @Override
    public Path getpath() {
        return null;
    }

}