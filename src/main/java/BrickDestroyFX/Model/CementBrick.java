package BrickDestroyFX.Model;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * This method creates the cement bricks.
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
     * Instantiates the properties of cement Brick
     * @param point bricks' coordinates
     * @param size bricks' length and width
     */
    public CementBrick(Point2D point, Dimension2D size) {
        super(NAME, point, size, DEF_BORDER, DEF_INNER, CEMENT_STRENGTH);
        crack = new Crack(DEF_CRACK_DEPTH, DEF_STEPS);
        brickFace = super.getBrickFace();
    } //constructor to instantiate cementbrick properties when it is called

    /**
     * this method makes the brick face
     * @param pos x and y coordinates of the brick.
     * @param size brick's size
     * @return
     */
    @Override
    protected Shape makeBrickFace(Point2D pos, Dimension2D size) {
        return new Rectangle(pos.getX(), pos.getY(), size.getWidth(), size.getHeight());
    } //abstract method provided by brick, used by Brick

    /**
     * This method check's ball and brick's imapct
     * @param point position of the bric
     * @param dir direction the ball impacts the brick
     * @return
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
     * Gets the cementbrick's brickface
     * @return brickface to gameboard view/controller
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
     * Repairs the Brick
     */
    public void repair() {
        super.repair();
        crack.reset();
        brickFace = super.getBrickFace();
    }// method to restore cement brick to its original form

    /**
     * For Crack animation
     * @return path
     */
    @Override
    public Path getpath() {
        return path;
    }
}