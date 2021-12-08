module com.example.softwaremaintenance {
    requires javafx.controls;
    requires javafx.fxml;


    opens BrickDestroyFX to javafx.fxml;
    exports BrickDestroyFX;
    exports BrickDestroyFX.Controllers;
    opens BrickDestroyFX.Controllers to javafx.fxml;
    exports BrickDestroyFX.View;
    opens BrickDestroyFX.View to javafx.fxml;
    exports BrickDestroyFX.Model;
    opens BrickDestroyFX.Model to javafx.fxml;
}