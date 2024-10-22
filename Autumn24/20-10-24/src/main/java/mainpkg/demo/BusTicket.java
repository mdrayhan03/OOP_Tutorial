package mainpkg.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
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
    private Label showInfoLabel;
    @javafx.fxml.FXML
    private TextField checkTNTF;
    @javafx.fxml.FXML
    private ComboBox<String> checkTicketCB;

    ObservableList<Ticket> ticketObservableArray = FXCollections.observableArrayList() ;
    ObservableList<String> ticketNoObservableArray = FXCollections.observableArrayList() ;

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
            ticketObservableArray.add(ticket) ;
            ticketNoObservableArray.add(ticket.getTicket_no()) ;

            checkTicketCB.setItems(ticketNoObservableArray) ;

            System.out.println(ticketObservableArray) ;

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

    @javafx.fxml.FXML
    public void checkButtonOA(ActionEvent actionEvent) {
        String check_ticket_no ;
        check_ticket_no = checkTNTF.getText() ;

        if(check_ticket_no.length() == 9) {
            for (Ticket t : ticketObservableArray) {
                if (Objects.equals(t.getTicket_no(), check_ticket_no)) {
                    showInfoLabel.setText(t.toString());
                    break;
                }
                else {
                    showInfoLabel.setText("No Ticket found.");
                }
            }
        }
        else {
            showInfoLabel.setText("Ticket No error.");
        }
    }

    @javafx.fxml.FXML
    public void comboboxOA(ActionEvent actionEvent) {
        String check_ticket_no ;
        check_ticket_no = checkTicketCB.getValue() ;

        if(check_ticket_no.length() == 9) {
            for (Ticket t : ticketObservableArray) {
                if (Objects.equals(t.getTicket_no(), check_ticket_no)) {
                    showInfoLabel.setText(t.toString());
                    break;
                }
                else {
                    showInfoLabel.setText("No Ticket found.");
                }
            }
        }
        else {
            showInfoLabel.setText("Ticket No error.");
        }
    }

    @javafx.fxml.FXML
    public void statusUpdateOA(ActionEvent actionEvent) {
        String check_ticket_no ;
        check_ticket_no = checkTicketCB.getValue() ;

        if(check_ticket_no.length() == 9) {
            for (Ticket t : ticketObservableArray) {
                if (Objects.equals(t.getTicket_no(), check_ticket_no)) {
                    t.setStatus("Done");
                    break;
                } else {
                    showInfoLabel.setText("No Ticket found.");
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void deleteDataOA(ActionEvent actionEvent) {
        String check_ticket_no ;
        check_ticket_no = checkTicketCB.getValue() ;

        if(check_ticket_no.length() == 9) {
            for (Ticket t : ticketObservableArray) {
                if (Objects.equals(t.getTicket_no(), check_ticket_no)) {
                    ticketObservableArray.remove(t) ;
                    ticketNoObservableArray.remove(t.getTicket_no());
                    break;
                } else {
                    showInfoLabel.setText("No Ticket found.");
                }
            }
        }
        System.out.println(ticketObservableArray);
    }
}