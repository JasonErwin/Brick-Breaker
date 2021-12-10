package BrickDestroyFX.Model;

import BrickDestroyFX.Model.Ball;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * Define General Properties of Bricks , Will be used by Clay,Cement and Cement Bricks.
 */
abstract public class Brick {
    /**
     * Set minimum number times to crack brick at 1
     */
    public static final int MIN_CRACK = 1;
    /**
     * Crack Depth is set at 1
     */
    public static final int DEF_CRACK_DEPTH = 1;
    /**
     * Steps for bricks set at 35
     */
    public static final int DEF_STEPS = 35;

    /**
     * brick up impact set at 100
     */
    public static final int UP_IMPACT = 100;
    /**
     * Brick down impact set at 200
     */
    public static final int DOWN_IMPACT = 200;
    /**
     * brick left impact set at 300
     */
    public static final int LEFT_IMPACT = 300;
    /**
     * Brick right impact set at 400
     */
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
     * Define general properties of bricks.
     * @param name name of the brick
     * @param pos x and y coordinates of the brick
     * @param size width and height of the bricks
     * @param border brick's border color
     * @param inner brick's inner color
     * @param strength brick's strength
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
     * abstract method to create new bricks
     * @param pos x and y coordinates of teh bricks
     * @param size width and height of the bricks
     * @return new bricks created
     */
    protected abstract Shape makeBrickFace(Point2D pos,Dimension2D size); //abstract method to makeBrickface,Used by Brick

    /**
     * identify whether ball touches brick
     * @param point x and y coordinates of the brick
     * @param dir which direction
     * @return false if no impact and broken if there is impact
     */
    public  boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;
        impact();
        return  broken;
    } //method to check Brick's Impact, used in Wall Class

    /**
     * Abstract method to get Bricks
     * @return a particular Brick
     */
    public abstract Shape getBrick(); //abstract method to get brick, Used by Game board

    /**
     * Retrrieve brick border color
     * @return brick border color
     */
    public Color getBorderColor(){
        return  border;
    } // getter for border color, used by GameBoard

    /**
     * Retrieve brick inner color
     * @return brick inner color
     */
    public Color getInnerColor(){
        return inner;
    } // getter for inner color , used by GameBoard

    /**
     * Method to find impact with ball with bricks
     * @param b ball
     * @return where is the impact with ball
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
     * Retrieve broken status for bricks
     * @return broken for brick.
     */
    public final boolean isBroken(){
        return broken;
    } // method to return broken, Used by CementBrick, GameBoard , SteelBrick

    /**
     * Repairs bricks to original condition
     */
    public void repair() {
        broken = false;
        strength = fullStrength;
    } //mehthod to restore brick to its original state, used by CementBrick

    /**
     * Defines what happens to the brick after impact with ball
     */
    public void impact(){
        strength--;
        broken = (strength == 0);
    } // impact method to  destroy cement brick , used bt CementBrick Class

    /**
     * retrieve x adn y coordinates of brick
     * @return x and y coordinates of brick
     */
    public Point2D getPoint(){
        return pos;
    }

    /**
     * retrieve x coordinates of brick
     * @return x coordinates of brick
     */
    public double getX(){
        return pos.getX();
    }

    /**
     * retreive y coordinates of brick
     * @return  y coordinates of brick
     */
    public double getY(){
        return pos.getY();
    }

    /**
     * retrieve width and height of bricks
     * @return width and height of bricks
     */
    public Dimension2D getSize(){
        return size;
    }

    /**
     * retrieve width of bricks
     * @return width of bricks
     */
    public double getWidth(){
        return size.getWidth();
    }

    /**
     * retrieve brick's height
     * @return brick's height
     */
    public double getHeight(){
        return size.getHeight();
    }

    /**
     * Retrieves path
     * @return is animation crack needed.
     */
    public abstract Path getpath();

    /**
     * Retrieve brick's brickFace
     * @return brick's brickFace
     */
    public Shape getBrickFace() {
        return brickFace;
    }
}