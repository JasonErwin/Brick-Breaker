package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Cement Brick's Property
 */
public class CementBrick extends Brick {
    private static final String NAME = "Cement Brick";
    private static final Color DEF_INNER = Color.rgb(147, 147, 147);
    private static final Color DEF_BORDER = Color.rgb(217, 199, 175);
    private static final int CEMENT_STRENGTH = 2;

    private Crack crack;
    private Shape brickFace;
    private Path path;


    /**
     * Define cement brick properties
     * @param point x and y coordinates of cement bricks
     * @param size width and height of cement bricks
     */
    public CementBrick(Point2D point, Dimension2D size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, CEMENT_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH, DEF_STEPS);
        brickFace = super.getBrickFace();
    } //constructor to instantiate cementbrick properties when it is called

    /**
     * Generate new cement bricks
     * @param pos x and y coordinates of coment bricks
     * @param size width and height
     * @return generated cement bricks
     */
    @Override
    protected Shape makeBrickFace(Point2D pos, Dimension2D size) {
        return new Rectangle(pos.getX(), pos.getY(), size.getWidth(), size.getHeight());
    } //abstract method provided by brick, used by Brick

    /**
     * Checks impact with ball
     * @param point x and y coordinates of the brick
     * @param dir which direction
     * @return whether brick is already broken or not
     */
    @Override
    public boolean setImpact(Point2D point, int dir) {
        if (super.isBroken())
            return false;
        super.impact();
        if (!super.isBroken()) {
            crack.makeCrack(point, dir, brickFace);
            updateBrick();
            return false;
        }
        return true;
    }// check whether there is ball impact with cementbrick

    /**
     * retrive cement brick's brickface
     * @return cement brick's brickface
     */
    @Override
    public Shape getBrick() {
        return brickFace;
    } //abstract method provided by brick, used by gameboard


    private void updateBrick() {
        if (!super.isBroken()) {
            path = crack.draw();
            //gp.append(super.brickFace,false)
        }
    } //method to display crack icon.

    /**
     * Restore Cement Brick to original condition
     */
    public void repair() {
        super.repair();
        crack.reset();
        brickFace = super.getBrickFace();
    }// method to restore cement brick to its original form

    /**
     * Requires Crack Animation
     * @return path to gameControllerView
     */
    @Override
    public Path getpath() {
        return path;
    }
}