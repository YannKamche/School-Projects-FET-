package com.example.mailapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.stage.StageStyle;
import java.io.IOException;

public class SignInController {

    @FXML
    public Button signInButton;


    public void signInButtonOnAction(ActionEvent event) {
        SignInPage();
        Stage stage = (Stage) signInButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
    }

    public void SignInPage() {

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 400);
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