package mainpkg.finalsp25;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class DataCreationToFileViewSce4Controller
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField expertiseTF;
    @javafx.fxml.FXML
    private DatePicker applicationDP;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private ComboBox<Integer> experienceCB;
    @javafx.fxml.FXML
    private CheckBox graduateChB;
    @javafx.fxml.FXML
    private ComboBox<String> desiCB;

    ArrayList<String> expertiseList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        desiCB.getItems().addAll("Staff", "Lecturer A", "Faculty") ;
        experienceCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6);
    }

    @javafx.fxml.FXML
    public void addExpertiseOA(ActionEvent actionEvent) {
        String expertise = expertiseTF.getText();
        expertiseList.add(expertise) ;
    }

    @javafx.fxml.FXML
    public void nextOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DataProcessingAndFilterOutputViewSec4.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Scene2");
        stage.show();
    }

    @javafx.fxml.FXML
    public void appenOA(ActionEvent actionEvent) {
        int id = Integer.parseInt(idTF.getText()) ;
        String name = nameTF.getText() ;
        String designation = desiCB.getValue() ;
        LocalDate applicationDate = applicationDP.getValue() ;
        boolean fresher = false ;
        if (graduateChB.isSelected()) {
            fresher = true ;
        }
        int experience = experienceCB.getValue() ;

        if (applicationDate.isAfter(LocalDate.now())) {
            System.out.println("Date is not valid");
            return;
        }

        if (experience <= 0) {
            experience = 0 ;
        }

        if (expertiseList.isEmpty()) {
            expertiseList = null ;
        }

        JobApplication jobApplication = new JobApplication(id, experience, name, designation, applicationDate, fresher, expertiseList) ;
        this.writeJobApplication(jobApplication);
        expertiseList.clear();
    }

    public void writeJobApplication(JobApplication jobApplication) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("JobApplication.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
//                oos = new ObjectOutputStream(fos) ;
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(jobApplication);

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

//    @FXML
//    private void saveToBin() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("monitors.bin")))) {
//            oos.writeObject(new java.util.ArrayList<>(monitorList));
//            showAlert("Saved successfully.");
//        } catch (Exception e) {
//            showAlert("Failed to save: " + e.getMessage());
//        }
//    }
}