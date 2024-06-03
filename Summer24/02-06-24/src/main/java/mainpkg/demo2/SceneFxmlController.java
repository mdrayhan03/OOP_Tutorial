package mainpkg.demo2;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class SceneFxmlController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> comboBox;

    ArrayList<Batsman> batArrayList ;
    ArrayList<Bowler> bowlArrayList ;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private PasswordField passTextField;

    @javafx.fxml.FXML
    public void initialize() {
        batArrayList = new ArrayList<>() ;
        bowlArrayList = new ArrayList<>() ;
        batArrayList.add(new Batsman("Shafiq" , "1-1-2000" , "5-2-2020" , 24 , "Batsman" , "100" , "50/20" , "110" , "1234")) ;
        bowlArrayList.add(new Bowler("Alam" , "1-1-2000" , "10-3-2022" , 24 , "Bowler" , "7.30" , "40" , "4/15" , "1234")) ;

        comboBox.getItems().addAll("Batsman" , "Bowler") ;

    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) {
        String name , pass ,pType;
        name = nameTextField.getText() ;
        pass = passTextField.getText() ;
        pType = comboBox.getValue() ;

        if (pType == "Batsman") {
            for (Batsman bat : batArrayList) {
                outputLabel.setText(bat.toString());
            }
        }
        else if (pType == "Bowler") {
            for (Bowler bat : bowlArrayList) {
                outputLabel.setText(bat.toString());
            }
        }
    }
}