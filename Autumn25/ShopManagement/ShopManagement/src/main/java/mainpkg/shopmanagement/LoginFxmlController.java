package mainpkg.shopmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFxmlController
{
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private TextField idTF;

    @javafx.fxml.FXML
    public void initialize() {
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
        Parent root = null;
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin/AdminDashboardFxml.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/CustomerDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

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