module com.example.mailapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.mailapp to javafx.fxml;
    exports com.example.mailapp;
}