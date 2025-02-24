package mainpkg.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    ComboBox<String> cb = new ComboBox<>() ;

    @FXML
    protected void onHelloButtonClick() {
        Test test = new Test(4) ;
        test.function(2, 3, 4);
        test.fun1(2).fun2(3).fun3(4) ;
        System.out.println(test.getI());
    }
}