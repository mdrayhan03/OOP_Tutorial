package mainpkg.shopmanagement.Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.scene.control.cell.PropertyValueFactory;
import mainpkg.shopmanagement.ModelClasses.DummyProduct;
import mainpkg.shopmanagement.ModelClasses.Product;

import java.util.Objects;

public class BuyProductFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<Product, Float> priceTC;
    @javafx.fxml.FXML
    private TableColumn<DummyProduct, String> cUnitTC;
    @javafx.fxml.FXML
    private TableColumn<Product, String> nameTC;
    @javafx.fxml.FXML
    private TextField qtyTF;
    @javafx.fxml.FXML
    private TableColumn<Product, String> productIDTC;
    @javafx.fxml.FXML
    private TableColumn<Product, String> categoryTC;
    @javafx.fxml.FXML
    private Label unitL;
    @javafx.fxml.FXML
    private TableColumn<DummyProduct, Float> cPriceTC;
    @javafx.fxml.FXML
    private TableColumn<DummyProduct, Float> cCostTC;
    @javafx.fxml.FXML
    private TableColumn<DummyProduct, String> cNameTC;
    @javafx.fxml.FXML
    private TableColumn<Product, String> unitTC;
    @javafx.fxml.FXML
    private Label priceL;
    @javafx.fxml.FXML
    private TableColumn<DummyProduct, String> cProductIDTC;
    @javafx.fxml.FXML
    private ComboBox<String> productIDCB;
    @javafx.fxml.FXML
    private TableColumn<DummyProduct, Integer> cQtyTC;
    @javafx.fxml.FXML
    private Label nameL;
    @javafx.fxml.FXML
    private Label categoryL;
    @javafx.fxml.FXML
    private TableView<DummyProduct> cartTV;
    @javafx.fxml.FXML
    private TableView<Product> productTV;

    ObservableList<Product> productObservableList = FXCollections.observableArrayList() ;
    ObservableList<DummyProduct> dummyProductObservableList = FXCollections.observableArrayList() ;
    @javafx.fxml.FXML
    private Label totalCostL;

    @javafx.fxml.FXML
    public void initialize() {

        productObservableList.add(new Product("111111", "Rice", "Grocery", "kg", 120f, 100)) ;
        productObservableList.add(new Product("222222", "Potato", "Grocery", "kg", 120f, 100)) ;
        productObservableList.add(new Product("333333", "Mango", "Fruit", "kg", 120f, 100)) ;
        productObservableList.add(new Product("444444", "Banana", "Fruit", "kg", 120f, 100)) ;
        productObservableList.add(new Product("555555", "Bread", "Bakery", "kg", 120f, 100)) ;

        productIDTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        unitTC.setCellValueFactory(new PropertyValueFactory<>("unit"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));

        cProductIDTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        cNameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        cUnitTC.setCellValueFactory(new PropertyValueFactory<>("unit"));
        cPriceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        cQtyTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cCostTC.setCellValueFactory(new PropertyValueFactory<>("cost"));

        for (Product product: productObservableList) {
            productIDCB.getItems().add(product.getId()) ;
        }

        productTV.setItems(productObservableList);

    }

    @javafx.fxml.FXML
    public void buyAllOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addToCartOA(ActionEvent actionEvent) {
        String id = productIDCB.getValue() ;

        for (Product product : productObservableList) {
            if (Objects.equals(product.getId(), id)) {
                DummyProduct dummyProduct = new DummyProduct(id, product.getName(), product.getCategory(), product.getUnit(), product.getPrice(), Integer.parseInt(qtyTF.getText())) ;
                dummyProductObservableList.add(dummyProduct) ;

                break;
            }
        }
        cartTV.setItems(dummyProductObservableList);

        float totalCost = 0 ;

        for (DummyProduct dummyProduct : dummyProductObservableList) {
            totalCost += dummyProduct.getCost() ;
        }

        totalCostL.setText(Float.toString(totalCost));
    }

    @javafx.fxml.FXML
    public void productIDCBOA(ActionEvent actionEvent) {
        String id = productIDCB.getValue() ;

        for (Product product : productObservableList) {
            if (Objects.equals(product.getId(), id)) {
                nameL.setText(product.getName());
                categoryL.setText(product.getCategory());
                priceL.setText(Float.toString(product.getPrice()));
                unitL.setText(product.getUnit());

                break ;
            }
        }
    }
}