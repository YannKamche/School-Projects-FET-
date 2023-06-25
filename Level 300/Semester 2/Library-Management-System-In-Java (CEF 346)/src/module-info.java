module Library.Management.System {
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    requires java.xml;
    requires javafx.controls;
    requires gson;
    requires mysql.connector.j;

    opens mylibrary.adminPages to javafx.fxml;
    opens mylibrary.memberPages to javafx.fxml;
    exports mylibrary;
    opens mylibrary to javafx.fxml;
}
