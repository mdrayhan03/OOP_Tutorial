package mainpkg.shopmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.stage.Stage;
import mainpkg.shopmanagement.Admin.Admin;
import mainpkg.shopmanagement.Customer.Customer;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class CreateAccountFxmlController
{
    @javafx.fxml.FXML
    private Label idL;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private TextField emergencyContactTF;

    ObservableList<Admin> adminObservableList = FXCollections.observableArrayList() ;
    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList() ;

    @javafx.fxml.FXML
    public void initialize() {
        typeCB.getItems().addAll("Admin", "Customer") ;
    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) {
        String id, name, email, pN, password, econtact, type ;

        type = typeCB.getValue() ;
        id = idL.getText() ;
        name = nameTF.getText() ;
        email = emailTF.getText() ;
        pN = pNTF.getText() ;
        password = passwordPF.getText() ;
        econtact = emergencyContactTF.getText() ;
        boolean flag = true ;
        String error = "" ;

        if(name.isBlank()) {
            flag = false ;
            error += "Name can't be empty.\n" ;
        }

        if (password.length() < 6) {
            flag = false ;
            error += "Password at least 6 character.\n" ;
        }

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION) ;
        successAlert.setTitle("Account creation successful!");

        if (flag) {
            if (Objects.equals(type, "Admin")) {
                Admin admin = new Admin(id, name, email, pN, password) ;
                adminObservableList.add(admin) ;
                successAlert.setContentText("Admin account created successfully.\n Admin id: " + admin.getId());
            } else if (Objects.equals(type, "Customer")) {
                Customer customer = new Customer(id, name, email, pN, password, econtact) ;
                customerObservableList.add(customer) ;
                successAlert.setContentText("Customer account created successfully.\n Customer id: " + customer.getId());
            }
            successAlert.showAndWait() ;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setTitle("Account creation error!") ;
            alert.setContentText(error) ;
            alert.showAndWait() ;
        }

    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginFxml.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void accountTypeCBOA(ActionEvent actionEvent) {
        String type = typeCB.getValue() ;
        String id = "" ;

        Random random = new Random() ;

        if (Objects.equals(type, "Admin")) {
            id += "ad" ;
            id += random.nextInt(100, 999) ;
            emergencyContactTF.setDisable(true);
        } else if (Objects.equals(type, "Customer")) {
            id += "cs" ;
            id += random.nextInt(10000, 99999) ;
            emergencyContactTF.setDisable(false);
        }

        idL.setText(id);
    }
}