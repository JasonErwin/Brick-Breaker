package BrickDestroyFX.View;

import BrickDestroyFX.Model.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;

/**
 * Act as View for Game Board in MVC
 */
public class GameBoardView {

    private GameBoardModel gameBoardModel;
    Canvas canvas;


    private GraphicsContext gc;
    private Wall wall;

    /**
     * Define GameBoardView Properties
     * @param gameBoardModel GameBoardModel from mvc
     * @param wall Game Logic
     */
    public GameBoardView(GameBoardModel gameBoardModel, Wall wall) {
        this.wall = wall;
        this.gameBoardModel = gameBoardModel;
        canvas = new Canvas(600, 450);
        gc = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);

    }

    /**
     * Method for painting the canvas
     * @param gc Graphics Context
     * @param wall game logic
     */
    public void paint(GraphicsContext gc, Wall wall) {
        gc.clearRect(0, 0, 600, 450);

        gc.fillText(gameBoardModel.getMessage(), 250, 225);

        drawBall(wall.getBall(), gc);

        for (Brick b : wall.getBricks())
            if (!b.isBroken()) {
                drawBrick(b, gc);
                drawPath(b.getpath(), gc);
            }

        drawPlayer(wall.getPlayer(), gc);

    } //draw level after pressing start

    private void drawPlayer(Player p, GraphicsContext gc) {
        gc.setFill(p.INNER_COLOR); //color inner
        gc.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight()); //draw inner
        gc.setStroke(p.BORDER_COLOR);
        gc.strokeRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
    }

    private void drawBall(Ball ball, GraphicsContext gc) {
        gc.setFill(ball.getInnerColor());
        gc.fillOval(ball.getMinX(), ball.getMinY(), ball.getRadius(), ball.getRadius());
        gc.setStroke(ball.getBorderColor());
        gc.strokeOval(ball.getMinX(), ball.getMinY(), ball.getRadius(), ball.getRadius());
    }

    private void drawBrick(Brick brick, GraphicsContext gc) {
        gc.setFill(brick.getInnerColor());
        gc.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        gc.setStroke(brick.getBorderColor());
        gc.strokeRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
    } //method to draw the border and inside of the bricks


    /**
     * retrieve Canvas
     * @return canvas to be passed to controller
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Method to repaint the canvas
     */
    public void repaint() {
        paint(gc, wall);
    }

    private void drawPath(Path path, GraphicsContext graphicsContext) {
        if (path != null && !path.getElements().isEmpty()) {

            graphicsContext.beginPath();
            String s1 = path.getElements().get(0).toString();
            String value = s1.replaceAll("[a-zA-Z]", "").replaceAll("[=]", "").replaceAll("[\\[-\\]]", "").replaceAll("[ ]", "");
            String[] splitString = value.split(",");

            double leftString = Double.parseDouble(splitString[0]);
            double rightString = Double.parseDouble(splitString[1]);
            graphicsContext.moveTo(leftString, rightString);

            for (int i = 1; i < 35; i++) {
                String s2 = path.getElements().get(i).toString();
                String value2 = s2.replaceAll("[a-zA-Z]", "").replaceAll("[=]", "").replaceAll("[\\[-\\]]", "").replaceAll("[ ]", "");
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

    /**
     * Method the retrieve the scene
     * @return Scene to controller
     */
    public Scene getScene() {
        return new Scene(new Pane(canvas));
    }

    /**
     * Retrieve GraphicsContext
     * @return GrpagicsContext to controller
     */
    public GraphicsContext getGc() {
        return gc;
    }

    /**
     * retrieve wall
     * @return wall to controller
     */
    public Wall getWall() {
        return wall;
    }
}
