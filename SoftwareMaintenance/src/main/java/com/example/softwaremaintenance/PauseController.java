package com.example.softwaremaintenance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PauseController {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button quitButton;
    @FXML
    private Button resumeButton;
    @FXML
    private Button restartButton;

    private GameBoard gameBoard;
    private Wall wall;
    private Scene scene;
    private Stage stage;
    private GraphicsContext gc;
    private Stage currentStage;



    public void initialize(Wall wall , GameBoard gameBoard, Stage stage, GraphicsContext gc){
         this.wall=wall;
         this.gameBoard=gameBoard;
         this.stage=stage;
         this.gc=gc;
    }

    public void resume(ActionEvent event) {
        currentStage=(Stage)restartButton.getScene().getWindow();
        currentStage.close();
        stage.getScene().getRoot().setEffect(null);
    }

    public void quit(ActionEvent event){
        stage.close();
        stage.getScene().getRoot().setEffect(null);
    }

    public void restart(ActionEvent event){
        wall.ballReset();
        wall.wallReset();
        gameBoard.repaint();
        currentStage=(Stage)restartButton.getScene().getWindow();
        currentStage.close();
        stage.getScene().getRoot().setEffect(null);
    }

    public void isKeyPressed(KeyEvent keyEvent){
        if(keyEvent.getCode() == KeyCode.ESCAPE){
            currentStage=(Stage)restartButton.getScene().getWindow();
            currentStage.close();
            stage.getScene().getRoot().setEffect(null);
        }
    }
}
