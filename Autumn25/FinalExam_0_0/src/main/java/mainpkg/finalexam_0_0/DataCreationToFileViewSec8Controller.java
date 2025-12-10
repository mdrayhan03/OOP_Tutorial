package mainpkg.finalexam_0_0;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class DataCreationToFileViewSec8Controller
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField prevPassportNoTF;
    @javafx.fxml.FXML
    private TextField nidTF;
    @javafx.fxml.FXML
    private DatePicker expiryDateDP;
    @javafx.fxml.FXML
    private TextField passportNoTF;
    @javafx.fxml.FXML
    private ComboBox<String> passportTypeCB;
    @javafx.fxml.FXML
    private CheckBox hasPassportChB;
    @javafx.fxml.FXML
    private DatePicker issueDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeCB;

    @javafx.fxml.FXML
    public void initialize() {
        passportTypeCB.getItems().addAll("Type1", "Type2", "Type3") ;
        zipCodeCB.getItems().addAll("1111", "1112", "1113") ;
    }

    @javafx.fxml.FXML
    public void createAndSaveOA(ActionEvent actionEvent) {
        String ppNo, nId, name, zipCode, prevPassportNo, passportType ;
        LocalDate dateOfIssue, dateOfExpire ;
        boolean hasPreviousPassport ;

        ppNo = passportNoTF.getText() ;
        nId = nidTF.getText() ;
        name = nameTF.getText() ;
        zipCode = zipCodeCB.getValue() ;
        prevPassportNo = prevPassportNoTF.getText() ;
        passportType = passportTypeCB.getValue() ;
        dateOfIssue = issueDateDP.getValue() ;
        dateOfExpire = expiryDateDP.getValue() ;
        hasPreviousPassport = false ;

        if (hasPassportChB.isSelected()) {
            hasPreviousPassport = true ;
        }

        Alert errorAlert = new Alert(Alert.AlertType.ERROR) ;
        errorAlert.setTitle("Error");

        if (dateOfIssue.isAfter(dateOfExpire)) {
            errorAlert.setContentText("Issue Date is after Expiry Date.");
            errorAlert.showAndWait() ;
            return;
        }

        if (! hasPreviousPassport) {
           if (! prevPassportNo.isBlank()) {
               errorAlert.setContentText("If no previous passport than no previous passport no.");
               errorAlert.showAndWait() ;
               return;
           }
        }

        Passport passport = new Passport( ppNo,  nId,  name,  zipCode,  prevPassportNo,  passportType,  dateOfIssue,  dateOfExpire,  hasPreviousPassport) ;
        this.writePassport(passport);
    }

    @javafx.fxml.FXML
    public void gotoDataLoadingOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DataProcessingAndFilterOutputViewSec8.fxml"));
        root = fxmlLoader.load();

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Data Processing and Filter Output");
        stage.show();
    }

    public void writePassport(Passport passport) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Passport.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
//                oos = new ObjectOutputStream(fos) ;
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(passport);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}