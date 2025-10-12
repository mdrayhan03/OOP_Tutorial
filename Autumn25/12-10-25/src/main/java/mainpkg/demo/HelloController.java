package mainpkg.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Human man = new Human("long", "short", "black") ;
        Human woman = new Human("medium", "long", "brown") ;
//        man.hand_size ;
//        man.leg_size ;
//        man.eye_color ;
        System.out.println(man.getEye_color());
        System.out.println(woman.getEye_color());

        man.setEye_color("blue") ;

        System.out.println(man.getEye_color());

        System.out.println(man);

        man.walk("North");
        woman.calculate(5, 7);
    }
}