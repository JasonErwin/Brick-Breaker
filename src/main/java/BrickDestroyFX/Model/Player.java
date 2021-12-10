package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Player Properties
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
     * Define Player Property
     * @param ballPoint x and y coordinates of the ball
     * @param width width of player model
     * @param height height of player model
     * @param container shape of player model
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


    private Rectangle makeRectangle(int width, int height) {
        Point2D p = new Point2D((int) (ballPoint.getX() - (width / 2)), (int) ballPoint.getY());
        return new Rectangle(p.getX(), p.getY(), width, height);
    } // method to draw a new rectangle.

    /**
     * check impact with ball
     * @param b ball
     * @return ball position based on playerFace
     */
    public boolean impact(Ball b) {
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown());
    } // boolean method to check whether the rectangle is touched by the ball. , getPosition Method from ball.

    /**
     * Move method for player
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
     * Move left method for player
     */
    public void moveLeft() {
        moveAmount = -DEF_MOVE_AMOUNT;
    } //player move left method

    /**
     * Move right method for player
     */
    public void movRight() {
        moveAmount = DEF_MOVE_AMOUNT;
    } //player move right method

    /**
     * Stop method for player
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
     *  Method to move to a certai point of player
     * @param p x and y coordinates to be moved to
     */
    public void moveTo(Point2D p) {
        ballPoint = p;
        playerFace.setX(ballPoint.getX() - (int) playerFace.getWidth() / 2);
        playerFace.setY(ballPoint.getY());
    }

    public void setMoveAmount(int moveAmount) {
        this.moveAmount = moveAmount;
    }

    public int getMoveAmount() {
        return moveAmount;
    }

    /**
     * Method to get player x coordinates
     * @return player x coordinates
     */
    public double getX() {
        return playerFace.getX();
    }

    /**
     * Retrieve player Y position
     * @return  player Y position
     */
    public double getY() {
        return playerFace.getY();
    }

    /**
     * Retrieve Player Height
     * @return player Height
     */
    public double getHeight() {
        return playerFace.getHeight();
    }

    /**
     * Retrieve player width
     * @return player width
     */
    public double getWidth() {
        return playerFace.getWidth();
    }
}

