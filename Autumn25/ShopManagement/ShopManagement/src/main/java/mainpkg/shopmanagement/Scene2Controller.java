package mainpkg.shopmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller
{
    @javafx.fxml.FXML
    private Label demoL;
//    String demo ;

    public void setter(String demo) {
//        this.demo = demo ;
        demoL.setText(demo);
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void scene1OA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene1.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        Stage stage = new Stage() ;
        stage.setScene(scene);
//        stage.setTitle("Admin Page");
        stage.show();
    }
}