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
import mainpkg.shopmanagement.Admin.AdminDashboardFxmlController;
import mainpkg.shopmanagement.Customer.Customer;
import mainpkg.shopmanagement.Customer.CustomerDashboardFxmlController;

import java.io.IOException;

public class LoginFxmlController
{
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private TextField idTF;

    ObservableList<Admin> adminObservableList = FXCollections.observableArrayList() ;
    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList() ;

    @javafx.fxml.FXML
    public void initialize() {
        adminObservableList.add(new Admin("ad001", "Admin1 Rayhan", "admin@gmail.com", "01234567890", "123456")) ;
        adminObservableList.add(new Admin("ad002", "Admin2 Rayhan", "admin@gmail.com", "01234567890", "123456")) ;
        adminObservableList.add(new Admin("ad003", "Admin3 Rayhan", "admin@gmail.com", "01234567890", "123456")) ;

        customerObservableList.add(new Customer("cs00001", "Customer1 Rayhan", "customer@gmail.com", "01234567890", "123456", "01478523690")) ;
        customerObservableList.add(new Customer("cs00002", "Customer2 Rayhan", "customer@gmail.com", "01234567890", "123456", "01478523690")) ;
        customerObservableList.add(new Customer("cs00003", "Customer3 Rayhan", "customer@gmail.com", "01234567890", "123456", "01478523690")) ;
        customerObservableList.add(new Customer("cs00004", "Customer4 Rayhan", "customer@gmail.com", "01234567890", "123456", "01478523690")) ;
        customerObservableList.add(new Customer("cs00005", "Customer5 Rayhan", "customer@gmail.com", "01234567890", "123456", "01478523690")) ;
    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAccountFxml.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) throws IOException {
        String id, password ;
        id = idTF.getText() ;
        password = passwordPF.getText() ;

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION) ;
        successAlert.setTitle("Login Successful!");

        if (id.length() == 5) {
            for (Admin admin : adminObservableList) {
                if (admin.login(id, password) != null) {
                    successAlert.setContentText("Welcome " + admin.getName()) ;
                    successAlert.showAndWait();

                    Parent root = null;
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin/AdminDashboardFxml.fxml"));
                    root = fxmlLoader.load();

                    AdminDashboardFxmlController adminDashboardFxmlController = fxmlLoader.getController() ;
                    adminDashboardFxmlController.getter(admin);

                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } else if (id.length() == 7) {
            for (Customer customer : customerObservableList) {
                if(customer.login(id, password) != null) {
                    successAlert.setContentText("Welcome " + customer.getName()) ;
                    successAlert.showAndWait();

                    Parent root = null;
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/CustomerDashboard.fxml"));
                    root = fxmlLoader.load();

                    CustomerDashboardFxmlController customerDashboardFxmlController = fxmlLoader.getController() ;
                    customerDashboardFxmlController.getter(customer);

                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }

        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR) ;
            errorAlert.setTitle("Login error!");
            errorAlert.setContentText("User not found.\nCheck id & password again.");
            errorAlert.showAndWait() ;
        }

//        if (admin) {
//            Parent root = null;
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin/AdminDashboardFxml.fxml"));
//            root = fxmlLoader.load();
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        }
//        else if (customer) {
//            Parent root = null;
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/CustomerDashboard.fxml"));
//            root = fxmlLoader.load();
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        }
    }
}