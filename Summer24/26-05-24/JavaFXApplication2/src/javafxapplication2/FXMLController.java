/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MD. Rayhan Hossain
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField semTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private Label showOutputLabel;
    
    ArrayList<Person> personList ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        personList = new ArrayList<>() ;
        
        showOutputLabel.setText("Nothing") ;
    }    

    @FXML
    private void addPersonOnMouseClick(ActionEvent event) {
        String name , sem ;
        int id , age , year ;
        
        name = nameTextField.getText() ;
        sem = semTextField.getText() ;
        id = Integer.parseInt(idTextField.getText()) ;
        age = Integer.parseInt(ageTextField.getText()) ;
        year = Integer.parseInt(yearTextField.getText()) ;
        
        Person per = new Person(name , sem , id , age , year) ;
        personList.add(per) ;
        
        nameTextField.clear();
        semTextField.clear();
        idTextField.clear();
        ageTextField.clear();
        yearTextField.clear();
    }

    @FXML
    private void showAllOnMouseClick(ActionEvent event) {
        String output = "" ;
        
        for (Person p: personList) {
            output += p.toString() + "\n" ;
        }
        
        showOutputLabel.setText(output) ;
    }
    
}
