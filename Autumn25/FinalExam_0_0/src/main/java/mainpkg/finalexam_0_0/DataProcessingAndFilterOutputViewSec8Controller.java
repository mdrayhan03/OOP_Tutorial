package mainpkg.finalexam_0_0;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class DataProcessingAndFilterOutputViewSec8Controller
{
    @javafx.fxml.FXML
    private TableColumn<Passport, String> nameTC;
    @javafx.fxml.FXML
    private TableView<Passport> passportTV;
    @javafx.fxml.FXML
    private TableColumn<Passport, LocalDate> issueDateTC;
    @javafx.fxml.FXML
    private ComboBox<String > passportTypeCB;
    @javafx.fxml.FXML
    private TableColumn<Passport, String> ppTypeTC;
    @javafx.fxml.FXML
    private TableColumn<Passport, LocalDate> expiryDateTC;
    @javafx.fxml.FXML
    private TableColumn<Passport, String> ppNoTC;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeCB;
    @javafx.fxml.FXML
    private TableColumn<Passport, String> zipCodeTC;

    ArrayList<Passport> passportArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        passportTypeCB.getItems().addAll("Type1", "Type2", "Type3") ;
        zipCodeCB.getItems().addAll("1111", "1112", "1113") ;

        ppNoTC.setCellValueFactory(new PropertyValueFactory<>("ppNo"));
        ppTypeTC.setCellValueFactory(new PropertyValueFactory<>("passportType"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        issueDateTC.setCellValueFactory(new PropertyValueFactory<>("dateOfIssue"));
        expiryDateTC.setCellValueFactory(new PropertyValueFactory<>("dateOfExpire"));
        zipCodeTC.setCellValueFactory(new PropertyValueFactory<>("zipCode"));

        passportArrayList = this.readPassport() ;
    }

    public ArrayList<Passport> readPassport() {
        ArrayList<Passport> passportArrayList = new ArrayList<Passport>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Passport.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Passport passport;
            try{
                while(true){
                    passport = (Passport) ois.readObject();
                    passportArrayList.add(passport) ;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("External Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return passportArrayList ;
    }

    @javafx.fxml.FXML
    public void zipCodeOA(ActionEvent actionEvent) {
        passportTV.getItems().clear() ;

        String passportType = passportTypeCB.getValue() ;
        String zipCode = zipCodeCB.getValue() ;

        for (Passport passport : passportArrayList) {
            if (Objects.equals(passport.getPassportType(), passportType) && Objects.equals(passport.getZipCode(), zipCode)) {
                passportTV.getItems().add(passport) ;
            }
        }
    }

    @javafx.fxml.FXML
    public void passportTypeOA(ActionEvent actionEvent) {
        passportTV.getItems().clear() ;

        String passportType = passportTypeCB.getValue() ;
        String zipCode = zipCodeCB.getValue() ;

        for (Passport passport : passportArrayList) {
            if (Objects.equals(passport.getPassportType(), passportType) && Objects.equals(passport.getZipCode(), zipCode)) {
                passportTV.getItems().add(passport) ;
            }
        }
    }
}