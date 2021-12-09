package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * This abstract class is to define the ball's properties
 *
 * @author Loo Yang Shen Jason
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
     * This constructor instantiate the properties of ball.
     * @param center coordinates of ball now.
     * @param radiusA radius from top to bottom.
     * @param radiusB radius from left to right.
     * @param inner ball's inner color.
     * @param border ball's outer color.
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
     * This protected abstract method creates a ball.
     * @param center coordinates of the Ball at the center.
     * @param radiusA ball radius from the top to bottom..
     * @param radiusB ball radius from left to right.
     * @return a created ball.
     */
    protected abstract Shape makeBall(Point2D center, int radiusA, int radiusB); //abstract class to makeBall, Used by Rubber Ball

    /**
     * This method is to define the ball's movement
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
     * This method is defines the movement of the ball to a certain point.
     * @param p The X and Y coordinates of where the ball will travel to.
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
     * this method is to set the Ball's speed.
     * @param x defines the speed on the x-axis.
     * @param y defines the speed on the y-axis.
     */
    public void setSpeed(int x, int y) {
        speedX = x;
        speedY = y;
    } //methods to set Ball Speed , Used by Wall Class

    /**
     * this method sets the X-axis spped.
     * @param s defines speed of the ball on the x-axis.
     */
    public void setXSpeed(int s) {
        speedX = s;
    } //setter to set the x axis speed, Used by Wall Class

    /**
     * this method sets the Y-axis spped.
     * @param s defines speed of the ball on the Y-axis.
     *
     */
    public void setYSpeed(int s) {
        speedY = s;
    } //setter to set the y axis speed, Used by Wall Class

    /**
     * This method gets the X-axis speed.
     * @return X axis speed to move method in ball
     */
    public int getSpeedX() {
        return speedX;
    } //getter to get the x axis speed, Used by debug panel

    /**
     * This methods the y-axis speed
     * @return y axis speed to move method in ball
     */
    public int getSpeedY() {
        return speedY;
    } // getter to get the y axis speed , Used by debug panel

    /**
     * This method negates the X axis speed.
     */
    public void reverseX() {
        speedX *= -1;
    } //setter to reverse the x axis , used by WAll

    /**
     * This method negates the y axis speed.
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
     * This method gets the ball's BorderColor.
     * @return border colour.
     */
    public Color getBorderColor() {
        return border;
    } //getter to return border, Used by Game board

    /**
     * This method gets the ball's inner color.
     * @return the inner color
     */
    public Color getInnerColor() {
        return inner;
    } //getter to return inner, used by game board

    /**
     * This method gets the ball's current position.
     * @return x and y coordinates.
     */
    public Point2D getPosition() {
        return center;
    }//getter to return center, Used by player and Wall

    /**
     * This method get the ballFace.
     * @return ballFace to moveTo(Point2D) method and Move().
     */
    public Shape getBallFace() {
        return ballFace;
    }//getter to return ballFace, Used by game Board

    /**
     * This method is to get the radius
     * @return radius to getMinX() and getMinY()
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This method gets the smallest x coordinate of the ball.
     * @return smallest x coordinate to move() and moveTo(Point2d) method.
     */
    public double getMinX() {
        return center.getX() - radius / 2;
    }

    /**
     * This method gets the smallest y coordinate of the ball.
     * @return smallest y coordinate to move() and moveTo(Point2d) method.
     */
    public double getMinY() {
        return center.getY() - radius / 2;
    }

    /**
     * This method return down .
     * @return down coordinates of the ball.
     */
    public Point2D getDown() {
        return down;
    }

    /**
     * This method return center.
     * @return center coordinates of the ball.
     */
    public Point2D getCenter() {
        return center;
    }

    /**
     * This method returns the Up coordinates
     * @return up coordinates of the ball
     */
    public Point2D getUp() {
        return up;
    }

    /**
     * this method returns the left coordinates.
     * @return left coordinates of the ball.
     */
    public Point2D getLeft() {
        return left;
    }

    /**
     * This method returns the right coordinates of the ball.
     * @return right coordinates of the ball.
     */
    public Point2D getRight() {
        return right;
    }

}

