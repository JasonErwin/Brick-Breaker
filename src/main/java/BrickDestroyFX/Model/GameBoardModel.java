package BrickDestroyFX.Model;

import BrickDestroyFX.Model.Level;
import BrickDestroyFX.Model.Wall;

public class GameBoardModel {


    private String input;
    private String message;

    public boolean isCheck() {
        return check;
    }

    private boolean check;
    private boolean run;
    private Wall wall;
    private static final int DEF_WIDTH = 600;
    private static final int DEF_HEIGHT = 450;

    public GameBoardModel() {
        message = "";
        input = "";
        run = false;
        check = false;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

}
