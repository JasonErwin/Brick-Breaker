package com.example.softwaremaintenance;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

abstract public class Ball {
    private Shape ballFace;

    private Point2D center;

    Point2D up  ;
    Point2D down;
    Point2D left;
    Point2D right;

    private Color border;
    private Color inner;

    private int speedX;
    private int speedY;



    private int radius;


    public Ball(Point2D center,int radiusA,int radiusB,Color inner,Color border){
        this.center = center;
        this.radius = radiusA;
        up = new Point2D(0,0);
        down = new Point2D(0,0);
        left = new Point2D(0,0);
        right = new Point2D(0,0);

//        up = new Point2D(center.getX(),center.getY()-(radiusB / 2));
//        down = new Point2D(center.getX(),center.getY()+(radiusB / 2));
//        left = new Point2D(center.getX()-(radiusA /2),center.getY());
//        right= new Point2D(center.getX()+(radiusA /2),center.getY());

        ballFace = makeBall(center,radiusA,radiusB);
        this.border = border;
        this.inner  = inner;
        speedX = 0;
        speedY = 0;
    } //constructor to instantiate elements when it is called.

    protected abstract Shape makeBall(Point2D center,int radiusA,int radiusB); //abstract class to makeBall, Used by Rubber Ball

    public void move(){
        Circle tmp ;
        center= new Point2D((center.getX() + speedX),(center.getY() + speedY));
        tmp= (Circle) ballFace;
        double radius = tmp.getRadius();

        tmp.setCenterX(getMinX());
        tmp.setCenterY(getMinY());
        tmp.setRadius(radius);
        ballFace = tmp;
        setPoints(tmp.getRadius(),tmp.getRadius());
    }//method for ball movement

    public void moveTo(Point2D p){
        center= p;
        Circle tmp ;
        tmp= (Circle) ballFace;
        double radius = tmp.getRadius();

        tmp.setCenterX(getMinX());
        tmp.setCenterY(getMinY());
        tmp.setRadius(radius);
        ballFace = tmp;
    }

    public void setSpeed(int x,int y){
        speedX = x;
        speedY = y;
    } //methods to set Ball Speed , Used by Wall Class

    public void setXSpeed(int s){
        speedX = s;
    } //setter to set the x axis speed, Used by Wall Class

    public void setYSpeed(int s){
        speedY = s;
    } //setter to set the y axis speed, Used by Wall Class

    public int getSpeedX(){
        return speedX;
    } //getter to get the x axis speed, Used by debug panel

    public int getSpeedY(){
        return speedY;
    } // getter to get the y axis speed , Used by debug panel

    public void reverseX(){
        speedX *= -1;
    } //setter to reverse the x axis , used by WAll

    public void reverseY(){
        speedY *= -1;
    } // setter to reverse the  y axis ,used by wall


    //method to allow ball to move to a certain point, Used by wall

    private void setPoints(double width,double height){
        up= new Point2D(center.getX(),center.getY()-(height / 2));
        down=new Point2D(center.getX(),center.getY()+(height / 2));
        left=new Point2D(center.getX()-(width / 2),center.getY());
        right=new Point2D(center.getX()+(width / 2),center.getY());
    } // used by ball, method to set Ball points

    public Color getBorderColor(){
        return border;
    } //getter to return border, Used by Game board

    public Color getInnerColor(){
        return inner;
    } //getter to return inner, used by game board

    public Point2D getPosition(){
        return center;
    }//getter to return center, Used by player and Wall

    public Shape getBallFace(){
        return ballFace;
    }//getter to return ballFace, Used by game Board

    public double getRadius() {
        return radius;
    }

    public double getMinX(){
        return center.getX()-radius/2;
    }

    public double getMinY(){
        return center.getY()-radius/2;
    }
}

