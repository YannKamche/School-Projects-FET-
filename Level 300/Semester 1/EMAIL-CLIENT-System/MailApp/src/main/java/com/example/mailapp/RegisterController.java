package com.example.mailapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class RegisterController {

    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label emptyFieldLabel;


    public void registerButtonOnAction(ActionEvent event) {
            if (emailTextField.getText().isBlank() || firstnameTextField.getText().isBlank() || lastnameTextField.getText().isBlank()) {
                emptyFieldLabel.setText("Some fields are empty");
            } else{
                emptyFieldLabel.setText("");

            }

        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
            //confirmPasswordLabel.setText("");

        } else {
            confirmPasswordLabel.setText("Password does not match");
        }
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerUser() {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String email = emailTextField.getText();
        String password = setPasswordField.getText();

        String insertFields = "INSERT INTO useraccounts(firstname, lastname, email, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + email + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            //registrationMessageLabel.setText("User has been registered successfully");
            confirmMessageBox();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void confirmMessageBox(){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BackToSignIn.fxml"));
                Stage registerStage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 200, 150);
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




