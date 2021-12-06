package BrickDestroyFX;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameBoard {
    private Wall wall;
    private Ball ball;
    private String input = "";
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;
    private Level level;
    private Brick brick;
    private String message;
    private Stage currentStage;
    private boolean check;
    private boolean run;

    Canvas canvas;
    GraphicsContext gc;
    public GameBoard(){
        message = "";
        check=false;
        run=false;
        wall = new Wall(new Rectangle(0,0,DEF_WIDTH,DEF_HEIGHT),30,3,6/2,new Point2D(300,430));
        level =new Level(new Rectangle(0,0,DEF_WIDTH,DEF_HEIGHT),30,3,6/2,new Point2D(300,430),wall);
        level.nextLevel();
        canvas= new Canvas(600,450);
        gc= canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        isKeyPressed(canvas);
        isKeyReleased(canvas);
        paint(gc,wall);
    }

    AnimationTimer animationTimer= new AnimationTimer()
    {
        @Override
        public void handle(long currentNanoTime){
            paint(gc,wall);

            wall.move();
            wall.findImpacts();
            message = String.format("Bricks: %d Balls %d",wall.getBrickCount(),wall.getBallCount());
            gc.fillText(message,250,225);

            if(input.equalsIgnoreCase("A")){
                wall.player.moveLeft();
            }
            else if (input.equalsIgnoreCase("D")){
                wall.player.movRight();
            }
            else{
                wall.player.stop();
            }

            if(wall.isBallLost()){
                if(wall.ballEnd()){
                    wall.wallReset();
                    message = "Game over";
                }
                wall.ballReset();
                animationTimer.stop();
            }
            else if(wall.isDone()){
                if(level.hasLevel()){
                    message = "Go to Next Level";
                    animationTimer.stop();
                    wall.ballReset();
                    wall.wallReset();
                    level.nextLevel();
                }
                else{
                    message = "ALL WALLS DESTROYED";
                    animationTimer.stop();
                }
            }
            repaint();
        }
    };

    public void paint(GraphicsContext gc , Wall wall){
        gc.clearRect(0,0,600,450);

        gc.fillText(message,250,225);

        drawBall(wall.ball,gc);

        for(Brick b : wall.bricks)
            if(!b.isBroken()) {
                drawBrick(b,gc);
                drawPath(b.getpath(),gc);
            }

        drawPlayer(wall.player,gc);

    } //draw level after pressing start

    private void drawPlayer(Player p,GraphicsContext gc){
        gc.setFill(p.INNER_COLOR); //color inner
        gc.fillRect(p.getX(),p.getY(),p.getWidth(),p.getHeight()); //draw inner
        gc.setStroke(p.BORDER_COLOR);
        gc.strokeRect(p.getX(),p.getY(),p.getWidth(),p.getHeight());
    }

    private void drawBall(Ball ball, GraphicsContext gc){
        gc.setFill(ball.getInnerColor());
        gc.fillOval(ball.getMinX(),ball.getMinY(),ball.getRadius(), ball.getRadius());
        gc.setStroke(ball.getBorderColor());
        gc.strokeOval(ball.getMinX(),ball.getMinY(),ball.getRadius(), ball.getRadius());
    }

    private void drawBrick(Brick brick, GraphicsContext gc){
        gc.setFill(brick.getInnerColor());
        gc.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        gc.setStroke(brick.getBorderColor());
        gc.strokeRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    } //method to draw the border and inside of the bricks


    public Canvas getCanvas() {
        return canvas;
    }


    public void isKeyPressed(Canvas canvas){
        canvas.setOnKeyPressed(e -> {
            if(e.getCode() ==KeyCode.A) {
                input = "A";
            }
            else if (e.getCode() ==KeyCode.D){
                input = "D";
            }
            else if (e.getCode() == KeyCode.SPACE) {
                if (run == false){
                    run=true;
                    animationTimer.start();
                } else{
                    if (check == false) {
                        animationTimer.stop();
                        check = true;
                    } else {
                        animationTimer.start();
                        check = false;
                    }
                }
            }
            else if (e.getCode() == KeyCode.ESCAPE){
                currentStage=(Stage)((Node)e.getSource()).getScene().getWindow();
                animationTimer.stop();
                check =true;
                currentStage.getScene().getRoot().setEffect(new GaussianBlur());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pausemenu.fxml"));
                Stage newStage = new Stage(StageStyle.TRANSPARENT);
                newStage.initOwner(currentStage);
                newStage.initModality(Modality.APPLICATION_MODAL);
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    newStage.setScene(scene);
                    newStage.show();
                    PauseController pauseController= fxmlLoader.getController();
                    pauseController.initialize(wall,this,currentStage,gc);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if(e.getCode() == KeyCode.F1){
                    if(e.isShiftDown() && e.isAltDown())
                    currentStage=(Stage)((Node)e.getSource()).getScene().getWindow();
                    animationTimer.stop();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("debug.fxml"));
                    Stage newStage = new Stage();
                    newStage.initOwner(currentStage);
                    newStage.initModality(Modality.APPLICATION_MODAL);
                    try {
                        Scene scene = new Scene(fxmlLoader.load());
                        newStage.setScene(scene);
                        newStage.show();
                        DebugController debugController= fxmlLoader.getController();
                        debugController.initializeDebug(wall,this,level);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        });
    }

    public void isKeyReleased(Canvas canvas){
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
            input = "";
            }
        });
    }

    public void repaint(){
        paint(gc,wall);
    }

    private void drawPath(Path path, GraphicsContext graphicsContext) {
        if (path != null && !path.getElements().isEmpty()) {

            graphicsContext.beginPath();
            String s1 = path.getElements().get(0).toString();
            String value = s1.replaceAll("[a-zA-Z]","").replaceAll("[=]","").replaceAll("[\\[-\\]]","").replaceAll("[ ]","");
            String[] splitString = value.split(",");

            double leftString = Double.parseDouble(splitString[0]);
            double rightString = Double.parseDouble(splitString[1]);
            graphicsContext.moveTo(leftString, rightString);

            for (int i = 1; i < 35; i++) {
                String s2 = path.getElements().get(i).toString();
                String value2 = s2.replaceAll("[a-zA-Z]","").replaceAll("[=]","").replaceAll("[\\[-\\]]","").replaceAll("[ ]","");
                String[] splitString2 = value2.split(",");
                double leftString2 = Double.parseDouble(splitString2[0]);
                double rightString2 = Double.parseDouble(splitString2[1]);
                graphicsContext.lineTo(leftString2, rightString2);
            }
            graphicsContext.fill();
            graphicsContext.closePath();
            graphicsContext.stroke();
        }
    }
    public Scene getScene(){
        return new Scene(new Pane(canvas));
    }
}
