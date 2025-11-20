package mainpkg.shopmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller
{
    @javafx.fxml.FXML
    private TextField demoTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void scene2OA(ActionEvent actionEvent) throws IOException {
        String demo = demoTF.getText();

        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene2.fxml"));
        root = fxmlLoader.load();

        Scene2Controller scene2Controller = fxmlLoader.getController() ;
        scene2Controller.setter(demo);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        Stage stage = new Stage() ;
        stage.setScene(scene);
//        stage.setTitle("Admin Page");
        stage.show();
    }
}