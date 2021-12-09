package BrickDestroyFX.Controllers;

import BrickDestroyFX.Model.GameBoardModel;
import BrickDestroyFX.Model.Level;
import BrickDestroyFX.Model.Wall;
import BrickDestroyFX.View.GameBoardView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller Class for Main Menu
 */
public class Controller {

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    private Scene scene;
    private Stage stage;
    private Wall wall;
    private Level level;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    /**
     * Logout Button Functionality
     * @param event on mouse clicked
     */
    public void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you really want to quit?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out from Brick Destroy!");
            stage.close();
        }
    }

    /**
     * Info Button Functionality
     * @param event on mouse clicked
     * @throws IOException exception called if no action can be undertaken
     */
    public void info(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BrickDestroyFX/info.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Back Button at Instruction Page Functionality
     * @param event on mouse clicked
     * @throws IOException exception if no action can be undertaken.
     */
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BrickDestroyFX/main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Start Button Functionality
     * @param event on mouse clicked
     * @throws IOException exception if no action can be undertaken.
     */
    public void Start(ActionEvent event) throws IOException {
        wall = new Wall(new Rectangle(0, 0, DEF_WIDTH, DEF_HEIGHT), 30, 3, 6 / 2, new Point2D(300, 430));
        level = new Level(new Rectangle(0, 0, DEF_WIDTH, DEF_HEIGHT), 30, 3, 6 / 2, new Point2D(300, 430), wall);
        level.nextLevel();
        GameBoardModel gameBoardModel = new GameBoardModel();
        GameBoardView gameBoardView = new GameBoardView(gameBoardModel, wall);
        GameBoardController gameBoardController = new GameBoardController(gameBoardModel, gameBoardView, level, wall);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(gameBoardView.getScene());
    }

    /**
     * HighScore Button Functionality
     * @param event on mouse clicked
     * @throws IOException exception to be done if no action can be undertaken .
     */
    public void highscore(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BrickDestroyFX/High Score.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Back button for High Score Scene
     * @param event on mouse clicked
     * @throws IOException exception to be called if no action can be undertaken.
     */
    public void back2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BrickDestroyFX/main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
