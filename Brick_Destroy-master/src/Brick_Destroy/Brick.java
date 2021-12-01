package Brick_Destroy;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Created by filippo on 04/09/16.
 *
 */
abstract public class Brick  {

    public static final int MIN_CRACK = 1;
    public static final int DEF_CRACK_DEPTH = 1;
    public static final int DEF_STEPS = 35;


    public static final int UP_IMPACT = 100;
    public static final int DOWN_IMPACT = 200;
    public static final int LEFT_IMPACT = 300;
    public static final int RIGHT_IMPACT = 400;





    private static Random rnd;

    private String name;
    Shape brickFace;

    private Color border;
    private Color inner;

    private int fullStrength;
    private int strength;

    private boolean broken;


    public Brick(String name, Point pos,Dimension size,Color border,Color inner,int strength){
        rnd = new Random();
        broken = false;
        this.name = name;
        brickFace = makeBrickFace(pos,size);
        this.border = border;
        this.inner = inner;
        this.fullStrength = this.strength = strength;

    }// constructor to instantiate brick properties when called

    protected abstract Shape makeBrickFace(Point pos,Dimension size); //abstract method to makeBrickface,Used by Brick

    public  boolean setImpact(Point2D point , int dir){
        if(broken)
            return false;
        impact();
        return  broken;
    } //method to check Brick's Impact, used in Wall Class

    public abstract Shape getBrick(); //abstract method to get brick, Used by Game board

    public Color getBorderColor(){
        return  border;
    } // getter for border color, used by GameBoard

    public Color getInnerColor(){
        return inner;
    } // getter for inner color , used by GameBoard


    public final int findImpact(Ball b){
        if(broken)
            return 0;
        int out  = 0;
        if(brickFace.contains(b.right))
            out = LEFT_IMPACT;
        else if(brickFace.contains(b.left))
            out = RIGHT_IMPACT;
        else if(brickFace.contains(b.up))
            out = DOWN_IMPACT;
        else if(brickFace.contains(b.down))
            out = UP_IMPACT;
        return out;
    } //method to find Ball Impact with brick , used by WAll Class

    public final boolean isBroken(){
        return broken;
    } // method to return broken, Used by CementBrick, GameBoard , SteelBrick

    public void repair() {
        broken = false;
        strength = fullStrength;
    } //mehthod to restore brick to its original state, used by CementBrick

    public void impact(){
        strength--;
        broken = (strength == 0);
    } // impact method to  destroy cement brick , used bt CementBrick Class

}