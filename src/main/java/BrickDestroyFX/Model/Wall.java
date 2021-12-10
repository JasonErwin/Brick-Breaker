package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Main Game Logic of the Game
 */
public class Wall {
    private Random rnd;
    private Rectangle area;

    Brick[] bricks;
    Ball ball;

    Player player;
    private Point2D startPoint;

    private int brickCount;



    private int score;

    int speedX;
    int speedY;

    private int ballCount;
    private boolean ballLost;


    /**
     * define game logic properties
     * @param drawArea area for level to be drawn
     * @param brickCount number of bricks
     * @param lineCount number of lines
     * @param brickDimensionRatio brickDimensionRatio
     * @param ballPos x and y coordinates of the ball
     */
    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point2D ballPos){

        this.startPoint = new Point2D(ballPos.getX(),ballPos.getY());

        ballCount = 3;
        ballLost = false;

        rnd = new Random();

        makeBall(ballPos);

        do{
            speedX = rnd.nextInt(5) - 2;
        }while(speedX == 0);
        do{
            speedY = -rnd.nextInt(3);
        }while(speedY == 0);

        ball.setSpeed(speedX,speedY);

        player = new Player(ballPos,150,10, drawArea);

        area = drawArea;


    } //when you call new wall , constructor to instantiate properties of wall. Used by gamebaord.


    /**
     * Method to make a ball
     * @param ballPos ball's x and y coordinates
     */
    public void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    } // instantiate ball


    /**
     * Move method that controls player model and ball
     */
    public void move(){
        player.move();
        ball.move();
    } //detect player and ball movements

    /**
     * Check whether ball has impacts with wall, border or player
     */
    public void findImpacts(){
        if(player.impact(ball)){
            ball.reverseY();
        }
        else if(impactWall()){
            /*for efficiency reverse is done into method impactWall
             * because for every brick program checks for horizontal and vertical impacts
             */
            brickCount--;
            increaseScore();
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

    /**
     * Method that defines what happens if ball impacts with brick
     * @return impact and next direction of the ball
     */
    public boolean impactWall(){
        for(Brick b : bricks){
            switch(b.findImpact(ball)) {
                //Vertical Impact
                case Brick.UP_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.getDown(), Crack.UP);
                case Brick.DOWN_IMPACT:
                    ball.reverseY();
                    return b.setImpact(ball.getUp(),Crack.DOWN);

                //Horizontal Impact
                case Brick.LEFT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.getRight(),Crack.RIGHT);
                case Brick.RIGHT_IMPACT:
                    ball.reverseX();
                    return b.setImpact(ball.getLeft(),Crack.LEFT);
            }
        }
        return false;
    } // detect brick collision , detects impact

    /**
     * Method to see if ball impacts with border.
     * @return true or false
     */
    public boolean impactBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    } //method that checks border collision left and right

    /**
     * retrieve brick's brickcount
     * @return brick's brickcount
     */
    public int getBrickCount(){
        return brickCount;
    } //method to get brick count

    /**
     * retrive ball count
     * @return ball count
     */
    public int getBallCount(){
        return ballCount;
    } //method to get ball count

    /**
     * Retrieve ballLost
     * @return ball lost
     */
    public boolean isBallLost(){
        return ballLost;
    } //method to get ball loss count

    /**
     * Method to reset the ball
     */
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

    /**
     * Method to reset the wall
     */
    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    } //reset wall positions, and set ball count to 3

    /**
     * Method to check is there any more balls
     * @return ballcount =0
     */
    public boolean ballEnd(){
        return ballCount == 0;
    } // when no balls left , ball count will be 0

    /**
     * Method to check is there no more bricks
     * @return brickCount will be 0
     */
    public boolean isDone(){
        return brickCount == 0;
    } // when level is done, brick number will be set to 0

    /**
     * Set ball's x speed
     * @param s ball's x speed
     */
    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    } //method to set x

    /**
     * Set ball's y speed
     * @param s ball's y speed
     */
    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    } //method to set y

    /**
     * reset ball count to 3
     */
    public void resetBallCount(){
        ballCount = 3;
    } //method to set ball to 3

    /**
     * Set Bricks based on type
     * @param bricks brick type of either cement , clay or steel
     */
    public void setBricks(Brick[] bricks) {
        this.bricks = bricks;
    }

    /**
     * Retrieve bricks
     * @return bricks
     */
    public Brick[] getBricks() {
        return bricks;
    }

    /**
     * Retrieve ball
     * @return ball
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Retrieve player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set the total number of bricks present.
     * @param brickCount number of bricks remaining
     */
    public void setBrickCount(int brickCount) {
        this.brickCount = brickCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int increaseScore(){
        return score+=10;
    }
}

