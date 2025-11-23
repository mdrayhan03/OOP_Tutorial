package mainpkg.shopmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    public static void fullSceneWithoutController(ActionEvent actionEvent, String path) throws IOException {
        Parent root = null;
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin/AdminDashboardFxml.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(path));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public static <T> T fullSceneWithController(ActionEvent actionEvent, String path) throws IOException {
        Parent root = null;
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin/AdminDashboardFxml.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(path));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        return fxmlLoader.getController() ;
    }
}
