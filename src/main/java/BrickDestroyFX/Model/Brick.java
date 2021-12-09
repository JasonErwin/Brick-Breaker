package BrickDestroyFX.Model;

import BrickDestroyFX.Model.Ball;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

import java.util.Random;


/**
 * This class deals with the brick properties.
 */
abstract public class Brick {
    public static final int MIN_CRACK = 1;
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;

    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;

    private static Random rnd;
    private Point2D pos;
    private Dimension2D size;
    private String name;

    Shape brickFace;

    private Color border;
    private Color inner;

    private int fullStrength;
    private int strength;

    private boolean broken;

    /**
     * this constructor instantiates the properties of brick
     * @param name name of the brick.
     * @param pos coordinates of the brick.
     * @param size size of the brick.
     * @param border border color of the brick.
     * @param inner inner color of the brick.
     * @param strength toughness of the brick.
     */
    public Brick(String name, Point2D pos, Dimension2D size, Color border, Color inner, int strength){
       this.pos=pos;
       this.size=size;
        rnd = new Random();
        broken = false;
        this.name = name;
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;

    }// constructor to instantiate brick properties when called

    /**
     * This protected abstract method makes a brickFace.
     * @param pos x and y coordinates of the brick.
     * @param size brick's size
     * @return BrickFace
     */
    protected abstract Shape makeBrickFace(Point2D pos,Dimension2D size); //abstract method to makeBrickface,Used by Brick

    /**
     * This method checks whether is there impact with the ball.
     * @param point position of the bric
     * @param dir direction the ball impacts the brick
     * @return whether ball impacts with bricks
     */
    public  boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;
        impact();
        return  broken;
    } //method to check Brick's Impact, used in Wall Class

    /**
     * This public abstract method is to get the brick
     * @return brick . Used by game Board.
     */
    public abstract Shape getBrick(); //abstract method to get brick, Used by Game board

    /**
     * This method returns the brick border color.
     * @return brick border color
     */
    public Color getBorderColor(){
        return  border;
    } // getter for border color, used by GameBoard

    /**
     * This method return the brick inner color
     * @return inner color of brick
     */
    public Color getInnerColor(){
        return inner;
    } // getter for inner color , used by GameBoard

    /**
     * This method deals with ball and brick impacts
     * @param b ball
     * @return
     */
    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.getRight()))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.getLeft()))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.getUp()))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.getDown()))
            out = UP_IMPACT;
        return out;
    } //method to find Ball Impact with brick , used by WAll Class

    /**
     * This method returns broken if it is true.
     * @return broken.
     */
    public final boolean isBroken(){
        return broken;
    } // method to return broken, Used by CementBrick, GameBoard , SteelBrick

    /**
     * This method repairs the cementbrick.
     */
    public void repair() {
        broken = false;
        strength = fullStrength;
    } //mehthod to restore brick to its original state, used by CementBrick

    /**
     * This method deals with what happens when the ball impacts with the brick
     */
    public void impact(){
        strength--;
        broken = (strength == 0);
    } // impact method to  destroy cement brick , used bt CementBrick Class

    /**
     * This method gets the brick's x and y coordinates.
     * @return bricks position in x and y coordinates
     */
    public Point2D getPoint(){
        return pos;
    }

    /**
     * This method gets the bricks x coordinates
     * @return brick's x coordinates
     */
    public double getX(){
        return pos.getX();
    }

    /**
     * This method get the bricks y coordinate
     * @return brick y coordinates
     */
    public double getY(){
        return pos.getY();
    }

    /**
     * This method gets the brick's size
     * @return brick's size
     */
    public Dimension2D getSize(){
        return size;
    }

    /**
     * This method get's the bricks width
     * @return brick's width
     */
    public double getWidth(){
        return size.getWidth();
    }

    /**
     * this method gets the bricks'height
     * @return height of the brick.
     */
    public double getHeight(){
        return size.getHeight();
    }

    /**
     * This abstract method gets the path
     * @return path.
     */
    public abstract Path getpath();

    /**
     * This methods get the brickface.
     * @return brickface of the Brick.
     */
    public Shape getBrickFace() {
        return brickFace;
    }
}