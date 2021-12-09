package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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

    public boolean impact(Ball b) {
        return playerFace.contains(b.getPosition()) && playerFace.contains(b.getDown());
    } // boolean method to check whether the rectangle is touched by the ball. , getPosition Method from ball.

    public void move() {
        double x = ballPoint.getX() + moveAmount;
        if (x < min || x > max)
            return;
        ballPoint = new Point2D(x, ballPoint.getY());
        playerFace.setX(ballPoint.getX() - (int) playerFace.getWidth() / 2);
        playerFace.setY(ballPoint.getY());
    }

    public void moveLeft() {
        moveAmount = -DEF_MOVE_AMOUNT;
    } //player move left method

    public void movRight() {
        moveAmount = DEF_MOVE_AMOUNT;
    } //player move right method

    public void stop() {
        moveAmount = 0;
    } //player stop moving method

    public Shape getPlayerFace() {
        return playerFace;
    } // getter to return playerFace

    public void moveTo(Point2D p) {
        ballPoint = p;
        playerFace.setX(ballPoint.getX() - (int) playerFace.getWidth() / 2);
        playerFace.setY(ballPoint.getY());
    }

    public double getX() {
        return playerFace.getX();
    }

    public double getY() {
        return playerFace.getY();
    }

    public double getHeight() {
        return playerFace.getHeight();
    }

    public int getWidth() {
        return width;
    }
}

