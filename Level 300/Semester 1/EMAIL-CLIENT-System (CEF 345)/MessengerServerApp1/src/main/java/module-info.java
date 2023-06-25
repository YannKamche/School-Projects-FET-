module com.example.messengerserverapp1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.messengerserverapp1 to javafx.fxml;
    exports com.example.messengerserverapp1;
}