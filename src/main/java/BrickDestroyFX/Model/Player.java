package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Player Model Class
 */
public class Player {
    public final Color BORDER_COLOR = Color.GREEN.darker().darker();
    public final Color INNER_COLOR = Color.GREEN;

    private static final int DEF_MOVE_AMOUNT = 5;

    private final Rectangle playerFace;
    private Point2D ballPoint;
    private int moveAmount;
    private final int min;
    private final int max;
    private final int height;
    private final int width;

    /**
     * Define Player Properties
     * @param ballPoint ball's x and y coordinates
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @param container rectangle created
     */
    public Player(Point2D ballPoint, int width, int height, Rectangle container) {
        this.ballPoint = ballPoint;
        this.width = width;
        this.height = height;
        moveAmount = 0;
        playerFace = makeRectangle(width, height);
        min = (int) container.getX() + (width / 2);
        max = min + (int) container.getWidth() - width;

    } //when calling new player, constructor will instantiate player properties. Used by Wall Constructor

    /**
     * method to create player model
     * @param width  width of the player model
     * @param height height of the player model
     * @return newly created player model
     */
    private Rectangle makeRectangle(int width, int height) {
        Point2D p = new Point2D((int) (ballPoint.getX() - (width / 2)), (int) ballPoint.getY());
        return new Rectangle(p.getX(), p.getY(), width, height);
    } // method to draw a new rectangle.

    /**
     * This method checks whether ball impacts with player model.
     * @param b ball
     * @return whether ball impacts with player model
     */
    public boolean impact(Ball b) {
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown());
    } // boolean method to check whether the rectangle is touched by the ball. , getPosition Method from ball.

    /**
     * Player move method
     */
    public void move() {
        double x = ballPoint.getX() + moveAmount;
        if (x < min || x > max)
            return;
        ballPoint = new Point2D(x, ballPoint.getY());
        playerFace.setX(ballPoint.getX() - (int) playerFace.getWidth() / 2);
        playerFace.setY(ballPoint.getY());
    }

    /**
     * Move Left method
     */
    public void moveLeft() {
        moveAmount = -DEF_MOVE_AMOUNT;
    } //player move left method

    /**
     * Move Right Method
     */
    public void movRight() {
        moveAmount = DEF_MOVE_AMOUNT;
    } //player move right method

    /**
     * Player Stop method
     */
    public void stop() {
        moveAmount = 0;
    } //player stop moving method

    /**
     * Retrieve Playerface
     * @return playerface
     */
    public Shape getPlayerFace() {
        return playerFace;
    } // getter to return playerFace

    /**
     * Move to a certain point method
     * @param p x and y coordinates
     */
    public void moveTo(Point2D p) {
        ballPoint = p;
        playerFace.setX(ballPoint.getX() - (int) playerFace.getWidth() / 2);
        playerFace.setY(ballPoint.getY());
    }

    /**
     * Method to get player x coordinates
     * @return player x coordinates
     */
    public double getX() {
        return playerFace.getX();
    }

    /**
     * method to get player y coordinates
     * @return y coordinates of player
     */
    public double getY() {
        return playerFace.getY();
    }

    /**
     * method to get player height
     * @return height of player model
     */
    public double getHeight() {
        return playerFace.getHeight();
    }

    /**
     * methid to get player width
     * @return player model's width
     */
    public int getWidth() {
        return width;
    }
}

