package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class BusTicket
{
    @javafx.fxml.FXML
    private ComboBox<String> fromCB;
    @javafx.fxml.FXML
    private TextField uidTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private TextField issueDateTF;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> toCB;
    @javafx.fxml.FXML
    private ComboBox<String> vipCB;
    @javafx.fxml.FXML
    private TextField exp_dateTF;
    @javafx.fxml.FXML
    private TextField seatNoTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> genderCB;
    @javafx.fxml.FXML
    private ComboBox<String> preGCB;
    @javafx.fxml.FXML
    private TextField statusTF;

    @javafx.fxml.FXML
    public void initialize() {
//        genderCB.getItems().add("Male") ;
//        genderCB.getItems().add("Female") ;
//        genderCB.getItems().add("Others") ;
//        genderCB.setItems();

        genderCB.getItems().addAll("Male", "Female", "Others") ;
        genderCB.setValue("--Select--");
        preGCB.getItems().addAll("Male", "Female", "Others", "Any") ;
        preGCB.setValue("--Select--");
        fromCB.getItems().addAll("Dhaka", "Khulna", "Rajshahi", "Rangpur", "Barishal", "Sylhet", "Chittagong") ;
        fromCB.setValue("--Select--");
        toCB.getItems().addAll("Dhaka", "Khulna", "Rajshahi", "Rangpur", "Barishal", "Sylhet", "Chittagong") ;
        toCB.setValue("--Select--");
        vipCB.getItems().addAll("Yes", "No") ;
        vipCB.setValue("--Select--");

    }

    @javafx.fxml.FXML
    public void createTicketOA(ActionEvent actionEvent) {
        String name , pN, email, gender, preG, from, to, vip, seat_no ;
        String validationText = "" ;

        boolean isValid = true ;

        name = customerNameTF.getText() ;
        if (name.isEmpty()) {
            isValid = false ;
            validationText += "Name invalid. " ;
        }

        pN = pNTF.getText() ;
        if (pN.length() != 11) {
            isValid = false ;
            validationText += "Phone No invalid. " ;
        }

        email = emailTF.getText() ;
        gender = genderCB.getValue() ;
        preG = preGCB.getValue() ;

        from = fromCB.getValue() ;
        to = toCB.getValue() ;
        if (Objects.equals(from, to)) {
            isValid = false ;
            validationText += "Destination invalid. " ;
        }

        vip = vipCB.getValue() ;
        seat_no = seatNoTF.getText() ;

        if (isValid) {
            Ticket ticket = new Ticket(name, pN, email, gender, preG, vip, from, to, seat_no) ;

            ticket.generate_ticket_no() ;
            ticket.dates() ;

            uidTF.setText(ticket.getTicket_no()) ;
            statusTF.setText(ticket.getStatus()) ;
            exp_dateTF.setText(ticket.getExp_date()) ;
            issueDateTF.setText(ticket.getIssue_date()) ;
            outputLabel.setText("Ticket creation successful.");
        }
        else {
            outputLabel.setText(validationText + "Ticket creation unsuccessful.");
        }
    }

    @javafx.fxml.FXML
    public void infoClearOA(ActionEvent actionEvent) {
        uidTF.clear() ;
        customerNameTF.clear();
        pNTF.clear();
        emailTF.clear();
        seatNoTF.clear();
        exp_dateTF.clear();
        issueDateTF.clear();
        statusTF.clear();
        genderCB.setValue("--Select--");
        preGCB.setValue("--Select--");
        fromCB.setValue("--Select--");
        toCB.setValue("--Select--");
        vipCB.setValue("--Select--");
        outputLabel.setText("");
    }
}