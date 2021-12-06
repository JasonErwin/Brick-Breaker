module com.example.softwaremaintenance {
    requires javafx.controls;
    requires javafx.fxml;


    opens BrickDestroyFX to javafx.fxml;
    exports BrickDestroyFX;
}