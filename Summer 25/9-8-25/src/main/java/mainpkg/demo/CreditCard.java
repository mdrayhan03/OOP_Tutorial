package mainpkg.demo;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class CreditCard {
    private String cardNo, holderName, gatewayName, cardType ;
    private float cardLimit ;
    private LocalDate dateOfExpiry ;

    public CreditCard(String cardNo, String holderName, String cardType, String gatewayName, float cardLimit, LocalDate dateOfExpiry) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.cardType = cardType;
        this.gatewayName = gatewayName;
        this.cardLimit = cardLimit;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public float getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(float cardLimit) {
        this.cardLimit = cardLimit;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo='" + cardNo + '\'' +
                ", holderName='" + holderName + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardLimit=" + cardLimit +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }

    public void showCardInfoToAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle("Credit Card Information") ;
        alert.setContentText(this.toString()) ;
        alert.showAndWait() ;
    }

    public boolean howManyDays() {
        boolean isLeapYear = this.getDateOfExpiry().isLeapYear() ;
        return isLeapYear ;
    }
}