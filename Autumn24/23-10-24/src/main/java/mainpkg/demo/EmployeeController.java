package mainpkg.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
//import jdk.internal.access.JavaTemplateAccess;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> designationCB;
    @javafx.fxml.FXML
    private DatePicker dobDP;
    @javafx.fxml.FXML
    private TextField salaryTF;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private DatePicker dojDP;
    @javafx.fxml.FXML
    private ComboBox<Integer> idCB;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> salaryTC;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> desiTC;
    @javafx.fxml.FXML
    private TableView<Employee> employeeInforTV;
    @javafx.fxml.FXML
    private TableColumn<Employee, Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn<Employee, LocalDate> dojTC;
    @javafx.fxml.FXML
    private TextField minimumSalaryTF;
    @javafx.fxml.FXML
    private DatePicker filterDOJDP;

    ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList() ;


    @javafx.fxml.FXML
    public void initialize() {
        designationCB.getItems().addAll("Employee", "Manager", "HR", "Admin") ;

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        salaryTC.setCellValueFactory(new PropertyValueFactory<>("salary"));
        desiTC.setCellValueFactory(new PropertyValueFactory<>("designation"));
        dojTC.setCellValueFactory(new PropertyValueFactory<>("doj"));

        employeeObservableList.add(new Employee(1234, 10000, "asdf", "Employee", LocalDate.of(2024,10,24), LocalDate.of(2024,10,24))) ;
        employeeObservableList.add(new Employee(3534, 20000, "asdf", "Employee", LocalDate.of(2024,10,24), LocalDate.of(2024,10,24))) ;
        idCB.getItems().addAll(1234, 3534) ;
    }

    @javafx.fxml.FXML
    public void createEmployeeOA(ActionEvent actionEvent) {
        int id , salary;
        String name, designation ;
        LocalDate dob, doj ;
        boolean isvalid = true ;

//        id must be 4digit
        id = Integer.parseInt(idTF.getText()) ;
        if (id < 1000 || id > 9999) {
            isvalid = false ;
        }

        for (Employee employee: employeeObservableList) {
            if(employee.getId() == id) {
                isvalid = false ;
                break;
            }
        }

        name = nameTF.getText() ;
        designation = designationCB.getValue() ;
        salary = Integer.parseInt(salaryTF.getText()) ;
        dob = dobDP.getValue() ;
        doj = dojDP.getValue() ;

        if (isvalid) {
            Employee employee = new Employee(id, salary, name, designation, dob, doj) ;
            employeeObservableList.add(employee) ;
            idCB.getItems().add(employee.getId()) ;
        }
    }

    @javafx.fxml.FXML
    public void showInfoOA(ActionEvent actionEvent) {
        for (Employee employee: employeeObservableList) {
            if (idCB.getValue() == employee.getId()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Employee Alert");
                alert.setHeaderText("Employee Information");
                alert.setContentText(employee.toString());
                alert.showAndWait() ;
//                alert.show();
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void filterButtonOA(ActionEvent actionEvent) {
        employeeInforTV.getItems().clear();

//        ObservableList<Employee> filteredEmployee = FXCollections.observableArrayList();
        int minSalary ;
        if (minimumSalaryTF.getText().isEmpty()) {
            minSalary = 0 ;
        }
        else {
            minSalary = Integer.parseInt(minimumSalaryTF.getText()) ;
        }

        LocalDate filterdate = filterDOJDP.getValue() ;
        if (filterdate == null) {
            filterdate = LocalDate.of(1800,1,1) ;
        }

        for (Employee employee: employeeObservableList) {
            if (employee.getSalary() >= minSalary && filterdate.isBefore(employee.getDoj())) {
                employeeInforTV.getItems().add(employee) ;
//                filteredEmployee.add(employee) ;
            }
        }
//        employeeInforTV.setItems(filteredEmployee);
    }
}