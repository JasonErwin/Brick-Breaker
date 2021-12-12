package BrickDestroyFX.Controllers;

import BrickDestroyFX.Model.Level;
import BrickDestroyFX.Model.Wall;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for Debug Panel
 */
public class DebugController implements Initializable {

    @FXML
    private Slider xSlider;

    @FXML
    private Slider ySlider;


    private Wall wall;
    private Level level;
    private int newX;
    private int newY;

    /**
     * Initialize Debug Panel Properties
     * @param wall game logic
     * @param level level generation
     */
    public void initializeDebug(Wall wall, Level level) {
        this.wall = wall;
        this.level = level;
    }

    /**
     * Reset button function in debug panel
     * @param event on mouse clicked
     */
    public void reset(ActionEvent event) {
        wall.resetBallCount();
    }

    /**
     * Skip Level button on Debug Panel
     * @param event on mouse clicked
     */
    public void skip(ActionEvent event) {
        if (level.hasLevel()) {
            level.nextLevel();
        }
    }

    /**
     * Initialize and  set values from slider to x and y speed for ball
     * @param arg0 uniform resource locator
     * @param arg1 contains locale-specific objects
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        xSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                newX = (int) xSlider.getValue();
                wall.setBallXSpeed(newX);
            }

        });
        ySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                newY = (int) ySlider.getValue();
                wall.setBallYSpeed(newY);
            }
        });
    }

}