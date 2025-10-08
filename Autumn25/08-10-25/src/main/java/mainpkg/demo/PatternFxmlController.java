package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatternFxmlController
{
    @javafx.fxml.FXML
    private TextField numberTF;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private TextField characterTF;

    @javafx.fxml.FXML
    public void initialize() {
        System.out.println("Pattern Making App");
    }

    @javafx.fxml.FXML
    public void upperRightOA(ActionEvent actionEvent) {
        int n = Integer.parseInt(numberTF.getText()) ;
        String ch = characterTF.getText() ;
        String str = "" ;

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < i + 1 ; j++) {
                str += ch ;
            }
            str += "\n" ;
        }
        outputL.setText(str) ;
    }

    @javafx.fxml.FXML
    public void lowerRightOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void upeerLeftOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void lowerLeftOA(ActionEvent actionEvent) {
    }
}