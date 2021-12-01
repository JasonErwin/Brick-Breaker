/*
 *  Brick Destroy - A simple Arcade video game
 *   Copyright (C) 2017  Filippo Ranza
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//usage = who use this method.
//implementation =  definitions of the function in code
package Brick_Destroy;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Wall {

    private Random rnd;
    private Rectangle area;


    public void setBricks(Brick[] bricks) {
        this.bricks = bricks;
    }

    public Brick[] getBricks() {
        return bricks;
    }

    Brick[] bricks;
    Ball ball;
    Player player;

    private Point startPoint;

    public void setBrickCount(int brickCount) {
        this.brickCount = brickCount;
    }

    private int brickCount;
    private int ballCount;
    private boolean ballLost;


    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point ballPos){

        this.startPoint = new Point(ballPos);

        ballCount = 3;
        ballLost = false;

        rnd = new Random();

        makeBall(ballPos);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);

        player = new Player((Point) ballPos.clone(),150,10, drawArea);

        area = drawArea;


    } //when you call new wall , constructor to instantiate properties of wall. Used by gamebaord.





    private void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    } // instantiate ball



    public void move(){
        player.move();
        ball.move();
    } //detect player and ball movements

    public void findImpacts(){
        if(player.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
            * because for every brick program checks for horizontal and vertical impacts
            */
            brickCount--;
        }
        else if(impactBorder()) {
            ball.reverseX();
        }
        else if(ball.getPosition().getY() < area.getY()){
            ball.reverseY();
        }
        else if(ball.getPosition().getY() > area.getY() + area.getHeight()){
            ballCount--;
            ballLost = true;
        }
    } //detect ball collision

    private boolean impactWall(){
        for(Brick b : bricks){
            switch(b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.down, Crack.UP);
                case Brick.DOWN_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.up,Crack.DOWN);

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.right,Crack.RIGHT);
                case Brick.RIGHT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.left,Crack.LEFT);
            }
        }
        return false;
    } // detect brick collision , detects impact

    private boolean impactBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    } //method that checks border collision left and right

    public int getBrickCount(){
        return brickCount;
    } //method to get brick count

    public int getBallCount(){
        return ballCount;
    } //method to get ball count

    public boolean isBallLost(){
        return ballLost;
    } //method to get ball loss count

    public void ballReset(){
        player.moveTo(startPoint);
        ball.moveTo(startPoint);
        int speedX,speedY;
        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);
        ballLost = false;
    } // when reset set back player rectangle and ball to initial postion, set speed of x and y, ball lost should be 0

    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    } //reset wall positions, and set ball count to 3

    public boolean ballEnd(){
        return ballCount == 0;
    } // when no balls left , ball count will be 0

    public boolean isDone(){
        return brickCount == 0;
    } // when level is done, brick number will be set to 0


    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    } //method to set x

    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    } //method to set y

    public void resetBallCount(){
        ballCount = 3;
    } //method to set ball to 3

     //implementation = to check method description
    //usage =to see where method is used
}
