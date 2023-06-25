/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package mylibrary;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mylibrary.Models.Database;

/**
 *
 * @author user
 */
public class MyLibrary extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.setMinWidth(1196);
        stage.setMinHeight(710);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
       Database database = Database.getDatabaseConnection();
        launch(args);
        
    }
    
}
