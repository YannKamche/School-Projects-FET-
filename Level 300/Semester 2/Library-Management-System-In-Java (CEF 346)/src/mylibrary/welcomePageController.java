
package mylibrary;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mylibrary.Models.Database;
import static mylibrary.Models.Database.getDatabaseConnection;

public class welcomePageController implements Initializable {
    
    @FXML
    Pane AnchorPane_Welcome;
    
    @FXML 
    TextField usernameMember;
    
    @FXML 
    Label usernameErrorMember;
    
    @FXML
    PasswordField passwordMember;
    
    @FXML 
    Label passwordErrorMember;
    
    @FXML 
    TextField usernameAdmin;
    
    @FXML 
    Label usernameErrorAdmin;
    
    @FXML
    PasswordField passwordAdmin;
    
    @FXML 
    Label passwordErrorAdmin;
    
    static public String USERNAME="";
    
    Database db = getDatabaseConnection();
    ResultSet  res;
    
    @FXML
    private void enterImage(MouseEvent event){
        
        double imageHeight = ((ImageView)event.getSource()).getFitHeight();
        double imageWidth = ((ImageView)event.getSource()).getFitWidth();
        imageHeight *= 1.2;
        imageWidth *= 1.2;
        ((ImageView)event.getSource()).setFitHeight(imageHeight);
        ((ImageView)event.getSource()).setFitWidth(imageWidth);
    }
    
    @FXML
    private void exitImage(MouseEvent event){
        
        double imageHeight = ((ImageView)event.getSource()).getFitHeight();
        double imageWidth = ((ImageView)event.getSource()).getFitWidth();
        imageHeight /= 1.2;
        imageWidth /= 1.2;
        ((ImageView)event.getSource()).setFitHeight(imageHeight);
        ((ImageView)event.getSource()).setFitWidth(imageWidth);
    }
    
    @FXML
    private void memberSignInPage(MouseEvent event)throws IOException{
        
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        double x = currentStage.getWidth();
        double y = currentStage.getHeight();
        Parent root = FXMLLoader.load(getClass().getResource("memberPages/memberSignIn.fxml"));
        Scene d = new Scene(root);
        currentStage.setScene(d);
        currentStage.setWidth(x);
        currentStage.setHeight(y);
        currentStage.show();
    }
    
    @FXML
    private void memberToHomePage(ActionEvent event) throws SQLException, IOException{
        
        String username = usernameMember.getText();
        String password = passwordMember.getText();

        
        if(!username.equals("") && !password.equals("")){
            res = db.SelectFun("select USERNAME from user where USERNAME = '"+usernameMember.getText()+"'");
            ResultSetMetaData rsmd = res.getMetaData();
            if(res.next()){
                usernameErrorMember.setText("");
                res = db.SelectFun("select USERNAME,LOGIN_PASSWORD from user where USERNAME = '"+usernameMember.getText()+"' and LOGIN_PASSWORD = '"+passwordMember.getText()+"'");
                rsmd = res.getMetaData();
                if(res.next()){
                    usernameErrorMember.setText("");
                    passwordErrorMember.setText("");
                    USERNAME=usernameMember.getText();
                    Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    double x=0.0, y=0.0;
                    if ( currentStage.getWidth() > 1196 ) x = currentStage.getWidth();
                    else x = 1196;
                    if ( currentStage.getHeight() > 910 ) y = currentStage.getHeight();
                    else y = 910;
                    Parent root = FXMLLoader.load(getClass().getResource("memberPages/memberHome.fxml"));
                    Scene d = new Scene(root);
                    currentStage.setScene(d);
                    currentStage.setWidth(x);
                    currentStage.setHeight(y);
                    currentStage.setMinWidth(1196);
                    currentStage.setMinHeight(910);
                    currentStage.show();
                }
                else{
                    passwordErrorMember.setText("The password is incorrect !");
                }
            }
            else {
                usernameErrorMember.setText("Username not found !");
                passwordErrorMember.setText("");
            }
        }
        else{
            if(username.equals("") ) usernameErrorMember.setText("You must fill in this field !");
            else usernameErrorMember.setText("");
            if(password.equals("") ) passwordErrorMember.setText("You must fill in this field !");
            else passwordErrorMember.setText("");
        }
    }
    
    
    @FXML
    private void adminSignInPage(MouseEvent event)throws IOException{
        
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        double x = currentStage.getWidth();
        double y = currentStage.getHeight();
        Parent root = FXMLLoader.load(getClass().getResource("adminPages/adminSignIn.fxml"));
        Scene d = new Scene(root);
        currentStage.setScene(d);
        currentStage.setWidth(x);
        currentStage.setHeight(y);
        currentStage.show();
    }
    
    @FXML
    private void adminToHomePage(ActionEvent event)throws IOException, SQLException{
        
        String username = usernameAdmin.getText();
        String password = passwordAdmin.getText();
        
        if(!username.equals("") && !password.equals("") ){
            res = db.SelectFun("select USERNAME,IS_SUPER from user where USERNAME = '"+usernameAdmin.getText()+"' and IS_SUPER = 1");
            ResultSetMetaData rsmd = res.getMetaData();
            if(res.next()){
                usernameErrorAdmin.setText("");
                res = db.SelectFun("select USERNAME,LOGIN_PASSWORD,IS_SUPER from user where USERNAME = '"+usernameAdmin.getText()+"' and LOGIN_PASSWORD = '"+passwordAdmin.getText()+"' and IS_SUPER = 1");
                rsmd = res.getMetaData();
                if(res.next()){
                    usernameErrorAdmin.setText("");
                    passwordErrorAdmin.setText("");
                    Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    double x=0.0, y=0.0;
                    if ( currentStage.getWidth() > 1196 ) x = currentStage.getWidth();
                    else x = 1196;
                    if ( currentStage.getHeight() > 910 ) y = currentStage.getHeight();
                    else y = 910;
                    Parent root = FXMLLoader.load(getClass().getResource("adminPages/adminHome.fxml"));
                    Scene d = new Scene(root);
                    currentStage.setScene(d);
                    currentStage.setWidth(x);
                    currentStage.setHeight(y);
                    currentStage.setMinWidth(1196);
                    currentStage.setMinHeight(910);
                    currentStage.show();
                }
                else{
                    passwordErrorAdmin.setText("The password is incorrect !");
                }
            }
            else {
                usernameErrorAdmin.setText("Username not found !");
                passwordErrorAdmin.setText("");
            }
        }
        else{
            if(username.equals("")) usernameErrorAdmin.setText("You must fill in this field !");
            else usernameErrorAdmin.setText("");
            if(password.equals("")) passwordErrorAdmin.setText("You must fill in this field !");
            else passwordErrorAdmin.setText("");
        }
    }
    
    
    @FXML
    private void backToWelcome(ActionEvent event)throws IOException{
        
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        double x = currentStage.getWidth();
        double y = currentStage.getHeight();
        Parent root = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));
        Scene d = new Scene(root);
        currentStage.setScene(d);
        currentStage.setWidth(x);
        currentStage.setHeight(y);
        currentStage.show();
    }
   
    @FXML
    private void memberToRegistration(ActionEvent event)throws IOException{
        
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        double x=0.0, y=0.0;
        if ( currentStage.getWidth() > 1196 ) x = currentStage.getWidth();
        else x = 1196;
        if ( currentStage.getHeight() > 910 ) y = currentStage.getHeight();
        else y = 910;
        Parent root = FXMLLoader.load(getClass().getResource("memberPages/registration.fxml"));
        Scene d = new Scene(root);
        currentStage.setScene(d);
        currentStage.setWidth(x);
        currentStage.setHeight(y);
        currentStage.setMinWidth(1196);
        currentStage.setMinHeight(910);
        currentStage.show();
    }
    
    @FXML
    private void myHoverFunctionStart(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #823F15;"));
    }
    
    @FXML
    private void myHoverFunctionEnd(MouseEvent event){
        
       Button tempButton = ((Button)event.getSource());
       tempButton.setStyle(tempButton.getStyle().concat("-fx-background-color: #A25F35;"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
