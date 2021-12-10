package BrickDestroyFX.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardModelTest {

    GameBoardModel gameBoardModel = new GameBoardModel();


    @Test
    void isCheck() {
        assertEquals(false, gameBoardModel.isCheck());
    }

    @Test
    void getMessage() {
        assertEquals("", gameBoardModel.getMessage());
    }

    @Test
    void setMessage() {
        gameBoardModel.setMessage("Hello");
        assertEquals("Hello", gameBoardModel.getMessage());
    }

    @Test
    void getInput() {
        assertEquals("", gameBoardModel.getInput());
    }

    @Test
    void setInput() {
        gameBoardModel.setInput("W");
        assertEquals("W", gameBoardModel.getInput());
    }

    @Test
    void isRun() {
        assertEquals(false, gameBoardModel.isRun());
    }

    @Test
    void setRun() {
        gameBoardModel.setRun(true);
        assertEquals(true, gameBoardModel.isRun());
    }

    @Test
    void setCheck() {
        gameBoardModel.setCheck(true);
        assertEquals(true, gameBoardModel.isCheck());
    }
}
