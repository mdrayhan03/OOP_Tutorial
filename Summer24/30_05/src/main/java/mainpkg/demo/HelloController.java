package mainpkg.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

//        Audi ad = new Audi("wheel" , "engine" , "tire" , "f") ;
//        Audi a = new Audi("wheel" , "engine" , "tire" , "f") ;

    }
}