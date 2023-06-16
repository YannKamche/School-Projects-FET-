package com.example.mailapp;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
    @FXML
    public Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    public Button signUpButton;

    @FXML

   //private ImageView Exit;

    public void loginButtonOnAction(ActionEvent event) {

        if (emailTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            //loginMessageLabel.setText("You try to login!");

            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE Email = '" + emailTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //loginMessageLabel.setText("Welcome!");
                    //createAccountForm(); Dashboard must come at this position
                    callDashboard();

                } else {
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void signUpButtonOnAction(){
        createAccountForm();

    }

    public void createAccountForm(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 474);
            registerStage.initStyle(StageStyle.UNDECORATED);
            //stage.setTitle("Your MailApp");
            registerStage.setScene(scene);
            registerStage.show();
        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
public void callDashboard(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MailDashboard.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
            registerStage.initStyle(StageStyle.UNDECORATED);
            //stage.setTitle("Your MailApp");
            registerStage.setScene(scene);
            registerStage.show();
        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}


