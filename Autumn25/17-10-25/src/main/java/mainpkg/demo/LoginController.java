package mainpkg.demo;

import javafx.scene.control.* ;
import javafx.event.* ;

import java.util.ArrayList;
import java.util.Objects;

public class LoginController
{
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private TextField idTF;

    ArrayList<Student> studentArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
//        Student student = new Student("1234", "asdf") ;
//        studentArrayList.add(student) ;

        studentArrayList.add(new Student("1234", "asdf")) ;
        studentArrayList.add(new Student("1235", "asdf")) ;
        studentArrayList.add(new Student("1236", "asdf")) ;
        studentArrayList.add(new Student("1237", "asdf")) ;
        studentArrayList.add(new Student("1238", "asdf")) ;
    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) {
        String id = idTF.getText() ;
        String password = passwordPF.getText() ;

        for (Student student : studentArrayList) {
            if (student.login(id, password)) {
                outputL.setText("Login Successful.");
                break;
            }
        }
    }
}