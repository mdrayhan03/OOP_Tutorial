package mainpkg.demo;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class COMBO
{
    @javafx.fxml.FXML
    private ComboBox<String> nameComboBox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<Integer> idComboBox;
    ArrayList<Car> arr = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        arr.add(new Audi("Option 1" , 1 , "four" , "Engine" , "Flat")) ;
        arr.add(new Audi("Option 2" , 2 , "Four" , "EnginE" , "FlaT")) ;
        arr.add(new Audi("Option 3" , 3 , "Four" , "EngIne" , "FLAT")) ;

        for (Car c: arr) {
            nameComboBox.getItems().add(c.getName()) ;
            idComboBox.getItems().add(c.getId()) ;
        }
    }


    @FXML
    public void showOnMouseClick(ActionEvent actionEvent) {
        outputLabel.setText(""); ;
        String name = nameComboBox.getValue() ;
        int id = idComboBox.getValue() ;

        for(Car c: arr) {
            if (c.getId() == id && c.getName() == name) {
                outputLabel.setText(c.toString());
            }
            else {
                outputLabel.setText("Nothing Found");
            }
        }
    }
}