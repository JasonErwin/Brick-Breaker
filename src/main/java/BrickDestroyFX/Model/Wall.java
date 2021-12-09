package BrickDestroyFX.Model;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * define game logic
 */
public class Wall {
    private Random rnd;
    private Rectangle area;

    Brick[] bricks;
    Ball ball;

    Player player;
    private Point2D startPoint;

    private int brickCount;
    private int ballCount;
    private boolean ballLost;

    /**
     * Define Wall Property
     * @param drawArea drawing Area
     * @param brickCount number of bricks
     * @param lineCount number of lines
     * @param brickDimensionRatio brick dimension ratio
     * @param ballPos brick current location
     */
    public Wall(Rectangle drawArea, int brickCount, int lineCount, double brickDimensionRatio, Point2D ballPos){

        this.startPoint = new Point2D(ballPos.getX(),ballPos.getY());

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

        player = new Player(ballPos,150,10, drawArea);

        area = drawArea;


    } //when you call new wall , constructor to instantiate properties of wall. Used by gamebaord.


    /**
     * method to make a new ball
     * @param ballPos x and y coordinate of ball.
     */
    public void makeBall(Point2D ballPos){
        ball = new RubberBall(ballPos);
    } // instantiate ball


    /**
     * move the player and ball method
     */
    public void move(){
        player.move();
        ball.move();
    } //detect player and ball movements

    /**
     * ball impacts with either border or player model.
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
     * ball and wall impact
     * @return set the impact of the ball with brick
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
     * touches border
     * @return reflects from border
     */
    public boolean impactBorder(){
        Point2D p = ball.getPosition();
        return ((p.getX() < area.getX()) ||(p.getX() > (area.getX() + area.getWidth())));
    } //method that checks border collision left and right

    /**
     * get brickcount
     * @return number of bricks
     */
    public int getBrickCount(){
        return brickCount;
    } //method to get brick count

    /**
     * get ball count
     * @return number of ball
     */
    public int getBallCount(){
        return ballCount;
    } //method to get ball count

    /**
     * check if ball is out of bound
     * @return ballLost
     */
    public boolean isBallLost(){
        return ballLost;
    } //method to get ball loss count

    /**
     * reset the ball
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
     * reset the wall
     */
    public void wallReset(){
        for(Brick b : bricks)
            b.repair();
        brickCount = bricks.length;
        ballCount = 3;
    } //reset wall positions, and set ball count to 3

    /**
     * is ther any balls?
     * @return 0 as no more balls
     */
    public boolean ballEnd(){
        return ballCount == 0;
    } // when no balls left , ball count will be 0

    /**
     * is level completed
     * @return 0 bricks left/
     */
    public boolean isDone(){
        return brickCount == 0;
    } // when level is done, brick number will be set to 0

    /**
     * set ball x speed
     * @param s speed of ball on the x axis.
     */
    public void setBallXSpeed(int s){
        ball.setXSpeed(s);
    } //method to set x

    /**
     * set ball y speed
     * @param s ball y axis speed
     */
    public void setBallYSpeed(int s){
        ball.setYSpeed(s);
    } //method to set y

    /**
     * reset ball count
     */
    public void resetBallCount(){
        ballCount = 3;
    } //method to set ball to 3

    /**
     * Set bricks
     * @param bricks which brick.
     */
    public void setBricks(Brick[] bricks) {
        this.bricks = bricks;
    }

    /**
     * GetBricks
     * @return bricks
     */
    public Brick[] getBricks() {
        return bricks;
    }

    /**
     * Get ball
     * @return ball
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * get Player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * set brickcount
     * @param brickCount number of bricks remaining
     */
    public void setBrickCount(int brickCount) {
        this.brickCount = brickCount;
    }
}

