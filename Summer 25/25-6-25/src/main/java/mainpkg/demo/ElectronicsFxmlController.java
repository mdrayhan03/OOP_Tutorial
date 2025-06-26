package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ElectronicsFxmlController
{
    @javafx.fxml.FXML
    private RadioButton mouseRB;
    @javafx.fxml.FXML
    private TextField companyNameTF;
    @javafx.fxml.FXML
    private TableColumn<ElectronicsItem, String> typeTC;
    @javafx.fxml.FXML
    private TableColumn<ElectronicsItem, LocalDate> issueDateTC;
    @javafx.fxml.FXML
    private TableView<ElectronicsItem> itemTV;
    @javafx.fxml.FXML
    private RadioButton routerRB;
    @javafx.fxml.FXML
    private DatePicker issueDateDP;
    @javafx.fxml.FXML
    private RadioButton keyboardRB;
    @javafx.fxml.FXML
    private TableColumn<ElectronicsItem, String> itemNameTC;
    @javafx.fxml.FXML
    private TableColumn<ElectronicsItem, String> companyNameTC;
    @javafx.fxml.FXML
    private TextField itemNameTF;
    @javafx.fxml.FXML
    private ToggleGroup tg;
    @javafx.fxml.FXML
    private TextField quanitityTF;
    @javafx.fxml.FXML
    private TableColumn<ElectronicsItem, Integer> quantityTC;
    @javafx.fxml.FXML
    private RadioButton monitorRB;

//    ToggleGroup toggleGroup = new ToggleGroup() ;

    ArrayList<ElectronicsItem> electronicsItems = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
//        keyboardRB.setToggleGroup(toggleGroup);
        itemNameTC.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        companyNameTC.setCellValueFactory(new PropertyValueFactory<>("company"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        issueDateTC.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    @javafx.fxml.FXML
    public void addItemOA(ActionEvent actionEvent) {
        String itemName, companyName, type = null ;
        int quantity ;
        LocalDate issueDate ;

        itemName = itemNameTF.getText() ;
        companyName = companyNameTF.getText() ;

//        for (ElectronicsItem ele : electronicsItems) {
//            if (Objects.equals(ele.getCompany(), companyName) || Objects.equals(ele.getItemName(), itemName)) {
//
//            }
//        }

        quantity = Integer.parseInt(quanitityTF.getText()) ;

        issueDate = issueDateDP.getValue() ;

        if(keyboardRB.isSelected()) {
            type = "Keyboard" ;
        } else if (monitorRB.isSelected()) {
            type = "Monitor" ;
        } else if (mouseRB.isSelected()) {
            type = "Mouse" ;
        }else if(routerRB.isSelected()) {
            type = "Router" ;
        }

        ElectronicsItem electronicsItem = new ElectronicsItem(itemName, companyName, type, issueDate, quantity) ;

        Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle("Add Item") ;
        alert.setContentText("Item has been added successfully.");
        alert.showAndWait() ;

//        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION) ;
//        alert3.setTitle("Add Item") ;
//        alert3.setContentText("Item has been added successfully.");
//        alert3.showAndWait() ;
//
//        Alert alert1 = new Alert(Alert.AlertType.WARNING) ;
//        alert1.setTitle("Add Item") ;
//        alert1.setContentText("Item has been added successfully.");
//        alert1.showAndWait() ;
//
//        Alert alert2 = new Alert(Alert.AlertType.ERROR) ;
//        alert2.setTitle("Add Item") ;
//        alert2.setContentText("Item has been added successfully.");
//        alert2.showAndWait() ;

        electronicsItems.add(electronicsItem) ;

        itemTV.getItems().clear();
//        for (ElectronicsItem ele : electronicsItems) {
//            itemTV.getItems().add(ele) ;
//        }
        itemTV.getItems().addAll(electronicsItems) ;
    }

    @javafx.fxml.FXML
    public void resetOA(ActionEvent actionEvent) {
        itemTV.getItems().clear();
    }
}