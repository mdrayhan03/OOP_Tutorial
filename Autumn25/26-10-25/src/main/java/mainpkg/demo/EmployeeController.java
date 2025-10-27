package mainpkg.demo;

import javafx.scene.control.* ;
import javafx.event.* ;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class EmployeeController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextArea bioTA;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private ComboBox<String> deptCB;
    @javafx.fxml.FXML
    private Label loginMEssageL;
    @javafx.fxml.FXML
    private Label idL;
    @javafx.fxml.FXML
    private PasswordField loginPasswordPF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private Label createMessageL;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private DatePicker dobDP;
    @javafx.fxml.FXML
    private TextField loginIDTF;
    @javafx.fxml.FXML
    private CheckBox fresherChB;

    ArrayList<Employee> employeeArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        deptCB.getItems().addAll("Frontend", "Backend", "DevOps") ;
        idL.setText(Integer.toString(this.generateID()));
    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) {
        String name, email, pN, dept, bio, password ;
        int id ;
        LocalDate dob ;
        boolean isFresher ;

        id = Integer.parseInt(idL.getText()) ;
        name = nameTF.getText() ;
        email = emailTF.getText() ;
        pN = pNTF.getText() ;
        dob = dobDP.getValue() ;
        dept = deptCB.getValue() ;
        isFresher = false ;
        bio = bioTA.getText() ;
        password = passwordPF.getText() ;

        if (fresherChB.isSelected()) {
            isFresher = true ;
        }

        boolean flag = true ;

        if (name.isBlank()) {
            flag = false ;
        }

        if (email.isBlank()) {
            flag = false ;
        }

        if (bio.length() > 300) {
            flag = false ;
        }

        if (password.length() < 6) {
            flag = false ;
        }

        if (flag) {
            Employee employee = new Employee(id, name, email, pN, dept, bio, password, isFresher, dob) ;
            employeeArrayList.add(employee) ;
            createMessageL.setText("Account created successfully & Employee ID: " + id + ".");

            System.out.println(id);

            idL.setText(Integer.toString(this.generateID()));
        }
        else {
            createMessageL.setText("Sorry, Name/Email/Password is not valid.");
        }
    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) {
        int id ;
        String password ;

        id = Integer.parseInt(loginIDTF.getText()) ;
        password = loginPasswordPF.getText() ;

        if (password.length() < 6) {
            loginMEssageL.setText("Password is not valid.");
            return ;
        }

        for (Employee employee : employeeArrayList) {
            if (employee.getId() == id && Objects.equals(employee.getPassword(), password)) {
                loginMEssageL.setText("Login Successful\n" +
                        "Hi! " + employee.getName() + "\n" +
                        "Welcome to " + employee.getDept());
                return ;
            }
        }

        loginMEssageL.setText("Information is not valid\nYou can’t login sorry!");
    }

    private int generateID() {
        int id = 0 ;

        Random random = new Random() ;
        id += random.nextInt(10000000, 99999999) ;

        return id ;
    }
}