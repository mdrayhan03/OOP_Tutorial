package mainpkg.mid;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class PracticeFxmlController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private DatePicker ddDP;
    @javafx.fxml.FXML
    private TableColumn<Product, String> nameTC;
    @javafx.fxml.FXML
    private ComboBox<String> materialCB;
    @javafx.fxml.FXML
    private ComboBox<Integer> quantityCB;
    @javafx.fxml.FXML
    private TableColumn<Product, LocalDate> dateTC;
    @javafx.fxml.FXML
    private ComboBox<String> materialFCB;
    @javafx.fxml.FXML
    private ComboBox<Integer> quantityFCB;
    @javafx.fxml.FXML
    private TableColumn<Product, String> materialTC;
    @javafx.fxml.FXML
    private TableColumn<Product, String> idTC;
    @javafx.fxml.FXML
    private TableColumn<Product, Integer> quantityTC;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private TableView<Product> productTV;
    @javafx.fxml.FXML
    private Label errorL;

    ArrayList<Product> productArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        materialCB.getItems().addAll("Wood", "Metal", "Board", "Cloth", "Others") ;
        materialFCB.getItems().addAll("Wood", "Metal", "Board", "Cloth", "Others") ;
        quantityCB.getItems().addAll(1,2,3,4,5) ;
        for (int i = 1; i < 6; i++) {
            quantityFCB.getItems().add(i) ;
        }

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        materialTC.setCellValueFactory(new PropertyValueFactory<>("material"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
    }

    @javafx.fxml.FXML
    public void addProductOA(ActionEvent actionEvent) {
        String name = "", id = "", material = "", error = "" ;
        int quantity = 0 ;
        LocalDate dDate = null ;
        boolean flag = true ;

        if (nameTF.getText().isEmpty()) {
            flag = false ;
            error += "Name text field is empty.\n" ;
        }
        else {
            name = nameTF.getText() ;
        }

        if (idTF.getText().isEmpty()) {
            flag = false ;
            error += "ID text field is empty.\n" ;
        }
        else {
            id = idTF.getText() ;
        }

        for (Product product : productArrayList) {
            if (Objects.equals(product.getId(), id)) {
                flag = false ;
                error += "Product already exist.\n" ;
                break ;
            }
        }

        if (materialCB.getValue() == null) {
            flag = false ;
            error += "Material value is empty.\n" ;
        }
        else {
            material = materialCB.getValue() ;
        }

        if (quantityCB.getValue() == null) {
            flag = false ;
            error += "Quantity is empty.\n" ;
        }
        else {
            quantity = quantityCB.getValue() ;
        }

        if (ddDP.getValue() == null) {
            flag = false ;
            error += "Delivery date is empty.\n" ;
        }
        else if (ddDP.getValue().isBefore(LocalDate.now())) {
            flag = false ;
            error += "Delivery date is past.\n" ;
        }
        else {
            dDate = ddDP.getValue() ;
        }

        errorL.setText(error);

        if (flag) {
            Product product = new Product(name, id, material, quantity, dDate) ;
            productArrayList.add(product) ;
            errorL.setText("Product created successfully.");
            nameTF.clear();
            idTF.clear();
            materialCB.setValue("");
            productTV.getItems().clear();
            for (Product prod : productArrayList) {
                productTV.getItems().add(prod) ;
            }
        }
    }

    @javafx.fxml.FXML
    public void loadTableOA(ActionEvent actionEvent) {
        productTV.getItems().clear() ;
        String material = materialFCB.getValue() ;
        int quantity = quantityFCB.getValue() ;

        for (Product product : productArrayList) {
            if (Objects.equals(product.getMaterial(), material) && product.getQuantity() == quantity) {
                productTV.getItems().add(product) ;
            }
        }
    }
}