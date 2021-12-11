package BrickDestroyFX.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {

    private Scene scene;
    private Stage stage;

    /**
     * Back button for High Score Scene
     * @param event on mouse clicked
     * @throws IOException exception to be called if no action can be undertaken.
     */
    public void menu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/BrickDestroyFX/main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ListView<String> highScoreNames;

    @FXML
    private ListView<String> highScorePoints;

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
                    highScoreNames.getItems().add(scoreName[0]);
                    highScorePoints.getItems().add(scoreName[1]);
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
