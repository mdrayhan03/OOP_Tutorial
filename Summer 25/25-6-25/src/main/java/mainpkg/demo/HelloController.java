package mainpkg.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private ComboBox<String> comboBox ;
    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");

        Demo demo = new Demo("a", 1) ;
//        String d = demo.field1;

        demo.addition(5, 6);
        demo.addition(5.45f, 6.23f);
        demo.addition(1, 2, 3);

//        comboBox.getItems().add("s") ;

//        Chaining chaining = new Chaining(5, 6) ;
//        chaining.addI().addJ().add() ;

//        i, j, k  1. i + 5 2. i + j 3. sum - k
        Chaining chaining = new Chaining(1, 2, 3);
        chaining.m1().m2().m3();

//        (x * (x + 3)) ** 2
    }
}