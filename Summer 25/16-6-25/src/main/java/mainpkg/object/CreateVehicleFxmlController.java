package mainpkg.object;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateVehicleFxmlController
{
    @javafx.fxml.FXML
    private ComboBox<String> typeOfWheelCB;
    @javafx.fxml.FXML
    private ComboBox<String> typeOfHandleCB;
    @javafx.fxml.FXML
    private TextField noOfWheelTF;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private ComboBox<String> colorCB;

    @javafx.fxml.FXML
    public void initialize() {
        typeOfWheelCB.getItems().addAll("Thin", "Thick", "Big", "Small") ;
        typeOfHandleCB.getItems().addAll("Stick", "Small Circle", "Medium Circle") ;
        colorCB.getItems().addAll("Red", "Green", "Blue") ;
    }

    @javafx.fxml.FXML
    public void createVehicleOA(ActionEvent actionEvent) {
        int noOfWheel = Integer.parseInt(noOfWheelTF.getText()) ;
        String typeOfWheel = typeOfWheelCB.getValue() ;
        String typeOfHandle = typeOfHandleCB.getValue() ;
        String color = colorCB.getValue() ;

        Vehicle vehicle = new Vehicle(noOfWheel, typeOfWheel, typeOfHandle, color) ;

        outputL.setText(vehicle.toString()) ;
    }
}