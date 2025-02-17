package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HumanFXMLController
{
    @javafx.fxml.FXML
    private ComboBox<String> eyeCB;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private TextField noLegTF;
    @javafx.fxml.FXML
    private ComboBox<String> handCB;
    @javafx.fxml.FXML
    private ComboBox<String> legCB;
    @javafx.fxml.FXML
    private TextField noEyeTF;
    @javafx.fxml.FXML
    private TextField noHandTF;

    @javafx.fxml.FXML
    public void initialize() {
        System.out.println("Initialize method") ;
        eyeCB.getItems().addAll("Black", "Blue", "Yellow", "Green") ;
        eyeCB.setValue("Black");
        handCB.getItems().addAll("Tall", "Short", "Thick", "Thin") ;
        handCB.setValue("Tall");
        legCB.getItems().addAll("Tall", "Short", "Thick", "Thin") ;
        legCB.setValue("Tall");
    }

    @javafx.fxml.FXML
    public void createHumanOA(ActionEvent actionEvent) {
        int no_of_hand, no_of_leg, no_of_eye ;
        String eye_color, hand_type, leg_type ;
        if (noEyeTF.getText().isEmpty()) {
            no_of_eye = 0 ;
        }
        else {
            no_of_eye = Integer.parseInt(noEyeTF.getText()) ;
        }
        no_of_hand = Integer.parseInt(noHandTF.getText()) ;
        no_of_leg = Integer.parseInt(noLegTF.getText()) ;
        eye_color = eyeCB.getValue() ;
        hand_type = handCB.getValue() ;
        leg_type = legCB.getValue() ;

        Human man = new Human(no_of_eye, no_of_hand, no_of_leg, eye_color, hand_type, leg_type) ;
        man.see();

        outputL.setText(man.toString());
    }
}