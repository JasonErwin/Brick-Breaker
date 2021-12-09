package BrickDestroyFX.Model;


/**
 * This class involves the game baord model.
 */
public class GameBoardModel {


    private String input;
    private String message;

    /**
     * returns check
     * @return check set at false
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
     * define gamebaord model properties
     */
    public GameBoardModel() {
        message = "";
        input = "";
        run = false;
        check = false;
    }

    /**
     * get message to be sent to other class
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set message to be displayed
     * @param message what to be displayed
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * retrieve input
     * @return input to gameboard view/controller
     */
    public String getInput() {
        return input;
    }

    /**
     * set input ;
     * @param input to gameboardview and controller
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * retrun runs as a boolean
     * @return run to gameboard controller
     */
    public boolean isRun() {
        return run;
    }

    /**
     * set run in boolean form
     * @param run whether the game is running now
     */
    public void setRun(boolean run) {
        this.run = run;
    }

    /**
     * set the game to either pause or not
     * @param check whether the game is pause
     */
    public void setCheck(boolean check) {
        this.check = check;
    }

}
