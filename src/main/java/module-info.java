module com.example.practica {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.practica to javafx.fxml;
    exports com.example.practica;
}