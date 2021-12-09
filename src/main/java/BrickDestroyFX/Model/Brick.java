package BrickDestroyFX.Model;

import BrickDestroyFX.Model.Ball;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

import java.util.Random;

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

    protected abstract Shape makeBrickFace(Point2D pos,Dimension2D size); //abstract method to makeBrickface,Used by Brick

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

    public Point2D getPoint(){
        return pos;
    }

    public double getX(){
        return pos.getX();
    }

    public double getY(){
        return pos.getY();
    }

    public Dimension2D getSize(){
        return size;
    }

    public double getWidth(){
        return size.getWidth();
    }

    public double getHeight(){
        return size.getHeight();
    }

    public abstract Path getpath();

    public Shape getBrickFace() {
        return brickFace;
    }
}