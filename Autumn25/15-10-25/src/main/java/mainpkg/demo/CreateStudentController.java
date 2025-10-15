package mainpkg.demo;

import javafx.event.*;
import javafx.scene.control.* ;

import java.time.LocalDate;

public class CreateStudentController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField phoneNoTF;
    @javafx.fxml.FXML
    private DatePicker dobDP;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private ComboBox<String> majorCB;
    @javafx.fxml.FXML
    private Label errorL;

    @javafx.fxml.FXML
    public void initialize() {
        majorCB.getItems().addAll("CSE", "CS", "EEE", "BBA", "PHY") ;
//        majorCB.getItems().add("CSE") ;
//        majorCB.getItems().add("CS") ;
    }

    @javafx.fxml.FXML
    public void createStudentAccountOA(ActionEvent actionEvent) {
        String id = idTF.getText() ;
        String name = nameTF.getText() ;
        String email = emailTF.getText() ;
        String pN = phoneNoTF.getText() ;
        LocalDate dob = dobDP.getValue() ;
        String major = majorCB.getValue() ;

        boolean flag = true ;
        String error = "" ;

//        id must be 5 character
        if (id.length() != 5) {
            flag = false ;
            error += "ID must be 5 character.\n" ;
        }

//        dob must be past time
        if (dob.isAfter(LocalDate.now())) {
            flag = false ;
            error += "DoB must be past.\n" ;
        }
//        name must be

        if (name.isBlank()) {
            flag = false ;
            error += "Name can't be empty." ;
        }

        if (flag) {
            Student student = new Student(id, name, email, pN, major, dob);

            outputL.setText("Account Created Successfully.\n" + student);
            errorL.setText("No error found.");
        }
        else {
            outputL.setText("Data is not valid.");
            errorL.setText("Error found.\n" + error) ;
        }
    }
}