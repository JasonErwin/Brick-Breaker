package BrickDestroyFX.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameScoreController implements Initializable {

    @FXML
    private ListView<String> gameScoreName;

    @FXML
    private ListView<String> gameScorePoint;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        BufferedReader bufferedReader;
        String[] scoreName;
        {
            try{
                bufferedReader = new BufferedReader(new FileReader("HighScore.txt"));
                String line= bufferedReader.readLine();
                while(line != null){
                    scoreName = line.split(" , ");
                    gameScoreName.getItems().add(scoreName[0]);
                    gameScorePoint.getItems().add(scoreName[1]);
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
            } catch (FileNotFoundException fileNotFoundException){
                fileNotFoundException.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
