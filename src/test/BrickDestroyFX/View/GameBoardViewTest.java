package BrickDestroyFX.View;

import BrickDestroyFX.Model.GameBoardModel;
import BrickDestroyFX.Model.Wall;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;
import javafx.scene.canvas.Canvas;


import static org.junit.jupiter.api.Assertions.*;

class GameBoardViewTest {
    Wall wall = new Wall(new Rectangle(0, 0, 600, 450), 30, 3, 6 / 2, new Point2D(300, 430));
    GameBoardModel gameBoardModel = new GameBoardModel();
    GameBoardView gameBoardView = new GameBoardView(gameBoardModel, wall);

    @Test
    void getWall() {
        assertEquals(wall, gameBoardView.getWall());
    }
}