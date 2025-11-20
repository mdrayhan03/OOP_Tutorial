package mainpkg.shopmanagement.Customer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpkg.shopmanagement.HelloApplication;

import java.io.IOException;


public class CustomerDashboardFxmlController
{
    @javafx.fxml.FXML
    private BorderPane customerDashboardBP;
    @javafx.fxml.FXML
    private Label totalBuyL;
    @javafx.fxml.FXML
    private Label greetL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signOutOA(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginFxml.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void dashboardOA(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/CustomerDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void invoiceOA(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/InvoiceFxml.fxml"));
        root = fxmlLoader.load();
        customerDashboardBP.setCenter(root);
    }

    @javafx.fxml.FXML
    public void historyOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void productOA(ActionEvent actionEvent) throws IOException {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/BuyProductFxml.fxml"));
        root = fxmlLoader.load();
        customerDashboardBP.setCenter(root);
    }
}