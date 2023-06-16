module com.example.messengerclientapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.messengerclientapp to javafx.fxml;
    exports com.example.messengerclientapp;
}