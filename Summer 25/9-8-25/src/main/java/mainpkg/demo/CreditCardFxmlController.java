package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class CreditCardFxmlController
{
    @javafx.fxml.FXML
    private DatePicker expiryDP;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayCB;
    @javafx.fxml.FXML
    private TextField holderNameTF;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> holderNameTC;
    @javafx.fxml.FXML
    private TableView<CreditCard> cardTV;
    @javafx.fxml.FXML
    private TextField limitTF;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> gatewayTC;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Float> limitTC;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayFCB;
    @javafx.fxml.FXML
    private TextField limitFTF;
    @javafx.fxml.FXML
    private Label avgL;
    @javafx.fxml.FXML
    private TextField cardNoTF;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> cardNoTC;

    ArrayList<CreditCard> cardList = new ArrayList<>() ;
    ArrayList<CreditCard> cardFList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        gatewayCB.getItems().addAll("MasterCard", "Visa") ;
        gatewayFCB.getItems().addAll("MasterCard", "Visa") ;
        typeCB.getItems().addAll("silver", "gold", "platinum", "titanium") ;

        cardNoTC.setCellValueFactory(new PropertyValueFactory<>("cardNo"));
        holderNameTC.setCellValueFactory(new PropertyValueFactory<>("holderName"));
        gatewayTC.setCellValueFactory(new PropertyValueFactory<>("gatewayName"));
        limitTC.setCellValueFactory(new PropertyValueFactory<>("cardLimit"));

    }

    @javafx.fxml.FXML
    public void validateCreateOA(ActionEvent actionEvent) {
        boolean flag = true ;
        String cardNo, holderName, gateway, type ;
        LocalDate expiry ;
        float limit ;

        cardNo = cardNoTF.getText() ;
        holderName = holderNameTC.getText() ;
        gateway = gatewayCB.getValue() ;
        type = typeCB.getValue() ;
        expiry = expiryDP.getValue() ;
        limit = Float.parseFloat(limitTF.getText()) ;

        if (cardNo.length() != 16) {
            flag = false ;
            Alert alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setTitle("Card No Error");
            alert.setContentText("Card No must be 16 digit.");
            alert.showAndWait();
        }

        if (Objects.equals(gateway, "Visa") && cardNo.charAt(0) != '4') {
            flag = false ;
            Alert alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setTitle("Card No Error");
            alert.setContentText("Card No is not correct.");
            alert.showAndWait();
        }

        if (Objects.equals(gateway, "MasterCard") && cardNo.charAt(0) != '5') {
            flag = false ;
            Alert alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setTitle("Card No Error");
            alert.setContentText("Card No is not correct.");
            alert.showAndWait();
        }

        if (flag) {
            CreditCard creditCard = new CreditCard(cardNo, holderName, type, gateway, limit, expiry) ;
            cardList.add(creditCard) ;
        }
    }

    @javafx.fxml.FXML
    public void searchLoadOA(ActionEvent actionEvent) {
        cardFList.clear() ;
        cardTV.getItems().clear() ;
        String gatewayF = gatewayFCB.getValue() ;
        float limitF = Float.parseFloat(limitFTF.getText()) ;

        for (CreditCard creditCard : cardList) {
            if (Objects.equals(creditCard.getGatewayName(), gatewayF) && creditCard.getCardLimit() >= limitF) {
                cardFList.add(creditCard) ;
            }
        }
        cardTV.getItems().addAll(cardFList) ;
    }

    @javafx.fxml.FXML
    public void showAVGOA(ActionEvent actionEvent) {
        float sum = 0 ;
        for (CreditCard creditCard : cardFList) {
            sum += creditCard.getCardLimit() ;
        }

        float avg = sum / cardFList.size() ;

        avgL.setText(Float.toString(avg)) ;
    }
}