package mainpkg.shopmanagement.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.shopmanagement.ModelClasses.Product;

import java.util.Random;

public class AddNewProductFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<Product, Float> priceTC;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private ComboBox<String> unitCB;
    @javafx.fxml.FXML
    private TableColumn<Product, String> nameTC;
    @javafx.fxml.FXML
    private TextField qtyTF;
    @javafx.fxml.FXML
    private TableColumn<Product, String> categoryTC;
    @javafx.fxml.FXML
    private TableColumn<Product, Integer> qtyTC;
    @javafx.fxml.FXML
    private Label idL;
    @javafx.fxml.FXML
    private TableColumn<Product, String> unitTC;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCB;
    @javafx.fxml.FXML
    private TableColumn<Product, String> idTC;
    @javafx.fxml.FXML
    private TableView<Product> productTV;

    Random random = new Random() ;
    ObservableList<Product> productObservableList = FXCollections.observableArrayList() ;

    @javafx.fxml.FXML
    public void initialize() {
        unitCB.getItems().addAll("kg", "Piece", "Packet") ;
        categoryCB.getItems().addAll("Bakery", "Grocery", "Fruit") ;

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitTC.setCellValueFactory(new PropertyValueFactory<>("unit"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        qtyTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        String id = Integer.toString(random.nextInt(100000, 999999)) ;
        idL.setText(id);
    }

    @javafx.fxml.FXML
    public void addNewProductOA(ActionEvent actionEvent) {
        String id, name, category, unit ;
        int qty ;
        float price ;

        id = idL.getText() ;
        name = nameTF.getText() ;
        category = categoryCB.getValue() ;
        unit = unitCB.getValue() ;
        price = Float.parseFloat(priceTF.getText()) ;
        qty = Integer.parseInt(qtyTF.getText()) ;

        Product product = new Product(id, name, category, unit, price, qty) ;

        productObservableList.add(product) ;

        productTV.setItems(productObservableList) ;
    }
}