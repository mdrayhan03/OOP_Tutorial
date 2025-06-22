package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Objects;

public class StudentFxmlController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private Label alertL;
    @javafx.fxml.FXML
    private CheckBox scholarshipChB;
    @javafx.fxml.FXML
    private TextField scholarshipTF;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private ComboBox<String> deptCB;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Student, Boolean> hasScholarShipTC;
    @javafx.fxml.FXML
    private TableColumn<Student, String> passwordTC;
    @javafx.fxml.FXML
    private TableColumn<Student, String> emailTC;
    @javafx.fxml.FXML
    private TableColumn<Student, String> pNTC;
    @javafx.fxml.FXML
    private TableView<Student> studentTV;
    @javafx.fxml.FXML
    private TableColumn<Student, String> idTC;
    @javafx.fxml.FXML
    private TableColumn<Student, String> deptTC;
    @javafx.fxml.FXML
    private TableColumn<Student, Float> scholarshipTC;

    ArrayList<Student> studentArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        deptCB.getItems().addAll("CSE", "EEE", "CS", "CE", "ENV", "MIS", "BBA") ;

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        pNTC.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("email"));
        deptTC.setCellValueFactory(new PropertyValueFactory<>("dept"));
        passwordTC.setCellValueFactory(new PropertyValueFactory<>("password"));
        hasScholarShipTC.setCellValueFactory(new PropertyValueFactory<>("hasScholarship"));
        scholarshipTC.setCellValueFactory(new PropertyValueFactory<>("scholarship"));
    }

    @javafx.fxml.FXML
    public void createStudentOA(ActionEvent actionEvent) {
        String id, name, pN, email, dept, password ;
        boolean hasScholarship, flag = true ;
        float scholarship ;

        id = idTF.getText() ;
        if (id.length() != 7) {
            flag = false ;
            alertL.setText("ID is not valid");
        }

        name = nameTF.getText() ;
        if (name.isEmpty()) {
            flag = false ;
            alertL.setText("Name can not be empty");
        }

        pN = pNTF.getText() ;
        email = emailTF.getText() ;
        dept = deptCB.getValue() ;
        password = passwordPF.getText() ;

        if (scholarshipChB.isSelected()) {
            hasScholarship = true ;
            scholarship = Float.parseFloat(scholarshipTF.getText()) / 100 ;
        }
        else {
            hasScholarship = false ;
            scholarship = 0f ;
        }

        for (Student student : studentArrayList) {
            if (Objects.equals(student.getId(), id)) {
                flag = false ;
                alertL.setText("ID already exist") ;
                break ;
            }
        }

        if (flag) {
            Student student = new Student(id, name, pN, email, dept, password, hasScholarship, scholarship);
            studentArrayList.add(student);

            studentTV.getItems().clear();
            for (Student stud : studentArrayList) {
                studentTV.getItems().add(stud) ;
            }

            alertL.setText("Student creation successful.");
            System.out.println(studentArrayList);
            idTF.clear();
            nameTF.clear();
            pNTF.clear();
            emailTF.clear();
            passwordPF.clear();
            deptCB.setValue("");
            scholarshipTF.clear();
            scholarshipChB.setSelected(false);
        }
    }

    @javafx.fxml.FXML
    public void showStudentsOA(ActionEvent actionEvent) {
        studentTV.getItems().clear();
        for (Student student : studentArrayList) {
            studentTV.getItems().add(student) ;
        }
    }
}