package mainpkg.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        Test test = new Test() ;
//        String n = test.name ;
        Student student = new Student("1234", "1234") ;

        System.out.println(student.getPassword());
    }
}