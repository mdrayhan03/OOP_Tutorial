package mainpkg.object;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateVehicleFxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
//        int i = 5 ;

//        Vehicle bike = new Vehicle(2, "thin", "stick", "red") ;
//        Vehicle car = new Vehicle(4, "medium", "circle", "blue") ;
//        System.out.println(bike.getNo_of_wheel()) ;
//        car.setColor("green");
//
//        bike.setVehicle_no("abcd");
//        System.out.println(bike);
    }
}