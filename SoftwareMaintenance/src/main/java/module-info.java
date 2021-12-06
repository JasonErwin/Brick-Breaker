module com.example.softwaremaintenance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.softwaremaintenance to javafx.fxml;
    exports com.example.softwaremaintenance;
}