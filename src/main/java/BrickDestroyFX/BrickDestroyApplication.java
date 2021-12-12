package BrickDestroyFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main Class to Load  Brick Destroy
 */
    public class BrickDestroyApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Image image=new Image(getClass().getResourceAsStream("images.png"));
            stage.getIcons().add(image);
            stage.setTitle("Brick Destroy");
            stage.setScene(scene);
            stage.show();
        }

    /**
     * Method to run the application
     * @param args arguments
     */
    public static void main(String[] args) {
            launch();
        }
    }

