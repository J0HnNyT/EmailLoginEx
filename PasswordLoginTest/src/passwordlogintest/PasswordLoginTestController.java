package passwordlogintest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PasswordLoginTestController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private TextField UserNameTextField;

    @FXML
    void loginButtonPressed(ActionEvent event) {
        
        isEmailValid(UserNameTextField.getText());
        isPasswordValid(PasswordTextField.getText());
        
        System.out.println(UserNameTextField.getText());
        System.out.println(PasswordTextField.getText());
        UserNameTextField.clear();
        PasswordTextField.clear();

    }//End Password Controller class.
    
    public boolean isEmailValid(String email){
        Pattern p = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com");
        Matcher m = p.matcher(email);
        
        if (m.find() && m.group().equals(email)){
            System.out.println("Login Accepted: " + email);
            return true;
        }
        else{
            Alert loginAlert = new Alert(AlertType.WARNING);
            loginAlert.setTitle("Invalid User Name!");
            loginAlert.setHeaderText(null);
            loginAlert.setContentText("That User Name is Not Valid. Please Try Again.");
            loginAlert.showAndWait();
        return false;
        }       
    }//End isEmailValid method;
    
    public boolean isPasswordValid(String password){
        Pattern p = Pattern.compile
        ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&+=])(?=\\S+$).{8,}$");
        Matcher m = p.matcher(password);
        if(m.find() && m.group().equals(password)){
            System.out.println("User Password Accepted: " + password);
            return true;
        }
        else{
            Alert passwordAlert = new Alert(AlertType.WARNING);
            passwordAlert.setTitle("Invalid Password!");
            passwordAlert.setHeaderText(null);
            passwordAlert.setContentText("The Password Entered is Incorrect. Please Try Again.");
            passwordAlert.showAndWait();
        return false;
        }
    }

}
