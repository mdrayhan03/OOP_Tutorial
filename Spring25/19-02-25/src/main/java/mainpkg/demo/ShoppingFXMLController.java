package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ShoppingFXMLController
{
    @javafx.fxml.FXML
    private TextField qtTF;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private DatePicker expDateDP;
    @javafx.fxml.FXML
    private TextField qtTakeTF;
    @javafx.fxml.FXML
    private ComboBox<String> foodNameCB;
    @javafx.fxml.FXML
    private TextField totalShowTF;
    @javafx.fxml.FXML
    private TextField customerTF;
    @javafx.fxml.FXML
    private Label errorL;
    @javafx.fxml.FXML
    private TextField priceShowTF;
    @javafx.fxml.FXML
    private TextArea invoiceShowTA;
    @javafx.fxml.FXML
    private TextField expDateShowTF;
    @javafx.fxml.FXML
    private TextField foodNameTF;

    ArrayList<Item> itemArrayList = new ArrayList<>() ;
    ArrayList<Order> orderArrayList = new ArrayList<>() ;
    boolean flag = true ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createItemOA(ActionEvent actionEvent) {
        String foodName ;
        int quantity ;
        float price ;
        LocalDate expDate ;

        foodName = foodNameTF.getText() ;
        quantity = Integer.parseInt(qtTF.getText()) ;
        price = Float.parseFloat((priceTF.getText())) ;
        expDate = expDateDP.getValue() ;

        Item foodItem = new Item(foodName, quantity, price, expDate) ;
        itemArrayList.add(foodItem) ;
        this.updateComboBox();

        foodNameTF.clear();
        qtTF.clear();
        priceTF.clear();
    }

    @javafx.fxml.FXML
    public void addToCartOA(ActionEvent actionEvent) {
        if (!this.flag) {
            errorL.setText("Can not add to cart.");
        }
        else {
            Item seletedItem = null ;
            int quantity ;
            float totalPrice ;

            String selectedFood = foodNameCB.getValue() ;
            quantity = Integer.parseInt(qtTakeTF.getText()) ;
            totalPrice = Float.parseFloat(totalShowTF.getText()) ;

            for (Item item: itemArrayList) {
                if (Objects.equals(item.getName(), selectedFood)) {
                    seletedItem = item ;
                    item.setQuantity(item.getQuantity() - quantity);
                    break;
                }
            }

            Order order = new Order(quantity, totalPrice, seletedItem) ;
            orderArrayList.add(order) ;
            foodNameCB.setValue("");
            priceShowTF.clear();
            expDateShowTF.clear();
            qtTakeTF.clear();
            totalShowTF.clear();
        }
    }

    @javafx.fxml.FXML
    public void invoiceOA(ActionEvent actionEvent) {
        String name, pN, invoice = "";
        float totalCost = 0 ;
        name = customerTF.getText() ;
        pN = pNTF.getText() ;

        invoice += "Customer Name: " + name + "\n" +
                   "Phone No: " + pN + "   Date: " + LocalDate.now().toString() + "\n" +
                   "Item Name       Price      Quantity     Total Price" + "\n"
                    ;

        for (Order order: orderArrayList) {
            invoice += order.getFood().getName() + "   " + order.getFood().getPrice() + "   " + order.getQuantity() + "   " + order.getTotalPrice() +  "\n";
            totalCost += order.getTotalPrice() ;
        }

        invoice += "-----------------------------------------------" +  "\n" ;
        invoice += "Total Cost:           " + totalCost ;

        invoiceShowTA.setText(invoice);
    }

    private void updateComboBox() {
        foodNameCB.getItems().clear();
        for (Item item : itemArrayList) {
            foodNameCB.getItems().add(item.getName()) ;
        }
    }

    @javafx.fxml.FXML
    public void showInfoCBOA(ActionEvent actionEvent) {
        String selectedFood = foodNameCB.getValue() ;

        for (Item item: itemArrayList) {
            if (Objects.equals(item.getName(), selectedFood)) {
                priceShowTF.setText(Float.toString(item.getPrice()));
                expDateShowTF.setText(item.getExpDate().toString());
                if (item.getExpDate().isBefore(LocalDate.now())) {
                    errorL.setText("Date is expired.");
                    this.flag = false ;
                }
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void totalTFOA(ActionEvent actionEvent) {
        int quantity = Integer.parseInt(qtTakeTF.getText()) ;
        String selectedFood = foodNameCB.getValue() ;
        float totalPrice ;
        for (Item item: itemArrayList) {
            if (Objects.equals(item.getName(), selectedFood)) {
                if (item.getQuantity() < quantity) {
                    errorL.setText("Not enough supply.");
                    this.flag = false ;
                    break;
                }
                totalPrice = item.getPrice() * quantity ;
                totalShowTF.setText(Float.toString(totalPrice));
                break;
            }
        }
    }
}