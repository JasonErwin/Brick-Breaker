package BrickDestroyFX.Model;

import BrickDestroyFX.Model.Level;
import BrickDestroyFX.Model.Wall;

/**
 * Game Board Model Properties
 */
public class GameBoardModel {


    private String input;
    private String message;

    /**
     * Retrieve check
     * @return check
     */
    public boolean isCheck() {
        return check;
    }

    private boolean check;
    private boolean run;
    private Wall wall;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    /**
     * Define Game Board Model Properties
     */
    public GameBoardModel() {
        message = "";
        input = "";
        run = false;
        check = false;
    }

    /**
     * Retrieve Message
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set a message to be displayed during gameplay
     * @param message what to be displayed during gameplay
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retrieve input
     * @return input
     */
    public String getInput() {
        return input;
    }

    /**
     * Set input of key pressed
     * @param input is something being pressed
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Retreive run
     * @return run
     */
    public boolean isRun() {
        return run;
    }

    /**
     * Set run
     * @param run is the game running
     */
    public void setRun(boolean run) {
        this.run = run;
    }

    /**
     * Set Check
     * @param check is the game pause or not
     */
    public void setCheck(boolean check) {
        this.check = check;
    }

}
