package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Objects;

public class Login
{
    @FXML
    private TextField idTextField;
    @FXML
    private Label showLabel;
    @FXML
    private PasswordField passwordPasswordField;

    ArrayList<User> userArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        userArrayList.add(new User(1234567, "asdfghjk1")) ;
        userArrayList.add(new User(1234568, "asdfghjk2")) ;
        userArrayList.add(new User(1234569, "asdfghjk3")) ;
        userArrayList.add(new User(1234560, "asdfghjk4")) ;
        userArrayList.add(new User(1234525, "asdfghjk5")) ;
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) {
        showLabel.setText("");
        int verified = 0 ;
        int id = Integer.parseInt(idTextField.getText()) ;
        String password = passwordPasswordField.getText() ;

        for (User u : userArrayList) {
            if (u.getId() == id && Objects.equals(u.getPassword(), password)) {
                verified = 1 ;
                break;
            }
        }

        if (verified == 1) {
            showLabel.setText("Login Successful");
        }
        else {
            showLabel.setText("Login Unsuccessful");
        }
    }
}