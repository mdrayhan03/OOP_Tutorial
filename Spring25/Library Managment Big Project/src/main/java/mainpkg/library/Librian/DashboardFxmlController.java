package mainpkg.library.Librian;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpkg.library.HelloApplication;

import java.io.IOException;

public class DashboardFxmlController
{
    @javafx.fxml.FXML
    private Label emailL;
    @javafx.fxml.FXML
    private Label nameL;
    @javafx.fxml.FXML
    private Label pNL;
    @javafx.fxml.FXML
    private BorderPane librianBP;

    String id ;
    String password ;

    public void getter() {

    }

    public void setter(String id, String password) {
        this.id = id ;
        this.password = password ;
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addBookButtonOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Librian/AddBookFxml.fxml"));
        root = fxmlLoader.load();
        AddBookFxml ac = fxmlLoader.getController() ;
        ac.setter("Book Title");
        librianBP.setCenter(root);
    }

    @javafx.fxml.FXML
    public void borrowBookButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addMemberButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addSodButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dashboardButonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signoutOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginFxml.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
}