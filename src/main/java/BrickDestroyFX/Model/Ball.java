package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Abstract properties of a ball
 */
abstract public class Ball {
    private Shape ballFace;

    private Point2D center;

    Point2D up;
    Point2D down;
    Point2D left;
    Point2D right;

    private Color border;
    private Color inner;

    private int speedX;
    private int speedY;

    private int radius;


    /**
     * Define ball properties
     * @param center x and y coordinates at the center of the ball
     * @param radiusA diameter from the top to bottom of the all
     * @param radiusB diameter from left to right of the ball
     * @param inner ball inner color
     * @param border ball border color
     */
    public Ball(Point2D center, int radiusA, int radiusB, Color inner, Color border) {
        this.center = center;
        this.radius = radiusA;
        up = new Point2D(0, 0);
        down = new Point2D(0, 0);
        left = new Point2D(0, 0);
        right = new Point2D(0, 0);

        ballFace = makeBall(center, radiusA, radiusB);
        this.border = border;
        this.inner = inner;
        speedX = 0;
        speedY = 0;
    } //constructor to instantiate elements when it is called.

    /**
     * Create a ball
     * @param center x and y coordinates of ball at the center point.
     * @param radiusA diameter from the top to bottom of the ball
     * @param radiusB diametr from the left to right of the ball
     * @return new created ball
     */
    protected abstract Shape makeBall(Point2D center, int radiusA, int radiusB); //abstract class to makeBall, Used by Rubber Ball

    /**
     * Method that controls the ball's movement
     */
    public void move() {
        Circle tmp;
        center = new Point2D((center.getX() + speedX), (center.getY() + speedY));
        tmp = (Circle) ballFace;
        double radius = tmp.getRadius();

        tmp.setCenterX(getMinX());
        tmp.setCenterY(getMinY());
        tmp.setRadius(radius);
        ballFace = tmp;
        setPoints(tmp.getRadius(), tmp.getRadius());
    }//method for ball movement

    /**
     * Move ball to a certain point
     * @param p x and y coordinates to move too
     */
    public void moveTo(Point2D p) {
        center = p;
        Circle tmp;
        tmp = (Circle) ballFace;
        double radius = tmp.getRadius();

        tmp.setCenterX(getMinX());
        tmp.setCenterY(getMinY());
        tmp.setRadius(radius);
        ballFace = tmp;
    }

    /**
     * set the speed of the x and y axis of the ball
     * @param x x-axis of the ball
     * @param y y-axis of the ball
     */
    public void setSpeed(int x, int y) {
        speedX = x;
        speedY = y;
    } //methods to set Ball Speed , Used by Wall Class

    /**
     * set ball's x speed
     * @param s ball's x speed
     */
    public void setXSpeed(int s) {
        speedX = s;
    } //setter to set the x axis speed, Used by Wall Class

    /**
     * set ball's y speed
     * @param s ball's y speed
     */
    public void setYSpeed(int s) {
        speedY = s;
    } //setter to set the y axis speed, Used by Wall Class

    /**
     * retrieve ball's X Speed
     * @return ball's X Speed
     */
    public int getSpeedX() {
        return speedX;
    } //getter to get the x axis speed, Used by debug panel

    /**
     *  Retreive ball's Y Speed
     * @return ball's Y Speed
     */
    public int getSpeedY() {
        return speedY;
    } // getter to get the y axis speed , Used by debug panel

    /**
     * Reserve the X axis direction
     */
    public void reverseX() {
        speedX *= -1;
    } //setter to reverse the x axis , used by WAll

    /**
     * Reverse Y Axis Direction
     */
    public void reverseY() {
        speedY *= -1;
    } // setter to reverse the  y axis ,used by wall

    private void setPoints(double width, double height) {
        up = new Point2D(center.getX(), center.getY() - (height / 2));
        down = new Point2D(center.getX(), center.getY() + (height / 2));
        left = new Point2D(center.getX() - (width / 2), center.getY());
        right = new Point2D(center.getX() + (width / 2), center.getY());
    } // used by ball, method to set Ball points

    /**
     * Retrieve BorderColor
     * @return ball border color
     */
    public Color getBorderColor() {
        return border;
    } //getter to return border, Used by Game board

    /**
     * Retrieve Ball inner color
     * @return ball inner color
     */
    public Color getInnerColor() {
        return inner;
    } //getter to return inner, used by game board

    /**
     * Retrieve ball center x and y coordinates
     * @return ball center x and y coordinates
     */
    public Point2D getPosition() {
        return center;
    }//getter to return center, Used by player and Wall

    /**
     * Retrieve ball's ballFace
     * @return ball's ballFace
     */
    public Shape getBallFace() {
        return ballFace;
    }//getter to return ballFace, Used by game Board

    /**
     * Retrieve ball's radius
     * @return ball's radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Retrieve Smallest X coordinates of ball
     * @return Smallest X coordinates of ball
     */
    public double getMinX() {
        return center.getX() - radius / 2;
    }

    /**
     * Retrieve Smallest Y coordinates of ball
     * @return Smallest Y coordinates of ball
     */
    public double getMinY() {
        return center.getY() - radius / 2;
    }

    /**
     * Retrieve down coordinates of ball
     * @return down coordinates of ball
     */
    public Point2D getDown() {
        return down;
    }

    /**
     * Retrieve center coordinates of ball
     * @return center coordinates of ball
     */
    public Point2D getCenter() {
        return center;
    }

    /**
     * Retrieve up coordinates of ball
     * @return up coordinates of ball
     */
    public Point2D getUp() {
        return up;
    }

    /**
     * Retrieve left coordinates of ball
     * @return left coordinates of ball
     */
    public Point2D getLeft() {
        return left;
    }

    /**
     * Retrieve right coordinates of ball
     * @return right coordinates of ball
     */
    public Point2D getRight() {
        return right;
    }

}

