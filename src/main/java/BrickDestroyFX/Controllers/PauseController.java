package BrickDestroyFX.Controllers;


import BrickDestroyFX.Model.GameBoardModel;
import BrickDestroyFX.View.GameBoardView;
import BrickDestroyFX.Model.Wall;
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


    private Wall wall;
    private Scene scene;
    private Stage stage;
    private GraphicsContext gc;
    private Stage currentStage;


    public void initialize(Wall wall, Stage stage, GraphicsContext gc) {
        this.wall = wall;
        this.stage = stage;
        this.gc = gc;
    }

    public void resume(ActionEvent event) {
        currentStage = (Stage) restartButton.getScene().getWindow();
        currentStage.close();
        stage.getScene().getRoot().setEffect(null);
    }

    public void quit(ActionEvent event) {
        stage.close();
        stage.getScene().getRoot().setEffect(null);
    }

    public void restart(ActionEvent event) {
        GameBoardModel gameBoardModel = new GameBoardModel();
        GameBoardView gameBoardView = new GameBoardView(gameBoardModel, wall);
        wall.ballReset();
        wall.wallReset();
        gameBoardView.repaint();
        currentStage = (Stage) restartButton.getScene().getWindow();
        currentStage.close();
        stage.getScene().getRoot().setEffect(null);
    }

    public void isKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ESCAPE) {
            currentStage = (Stage) restartButton.getScene().getWindow();
            currentStage.close();
            stage.getScene().getRoot().setEffect(null);
        }
    }
}
