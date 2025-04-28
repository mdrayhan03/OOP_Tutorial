package mainpkg.finalsp25;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

public class DataProcessingAndFilterOutputViewSec4Controller
{
    @javafx.fxml.FXML
    private TableColumn<JobApplication, String> toString;
    @javafx.fxml.FXML
    private ComboBox<Integer> experienceCB;
    @javafx.fxml.FXML
    private ComboBox<String> desiCB;
    @javafx.fxml.FXML
    private TableView<JobApplication> tableTV;

    ArrayList<JobApplication> jobApplicationArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        desiCB.getItems().addAll("Staff", "Lecturer A", "Faculty") ;
        experienceCB.getItems().addAll(0, 1, 2, 3, 4, 5, 6);

        toString.setCellValueFactory(new PropertyValueFactory<>("showDetails"));

//        jobApplicationArrayList = this.readJobApplication() ;
    }

    @javafx.fxml.FXML
    public void loadOA(ActionEvent actionEvent) {
        String designation = desiCB.getValue() ;
        int experience = experienceCB.getValue() ;

        jobApplicationArrayList = this.readJobApplication() ;

        tableTV.getItems().clear();
        for (JobApplication jobApplication: jobApplicationArrayList) {
            if(Objects.equals(jobApplication.getDesignation(), designation) && jobApplication.getExperience() >= experience) {
//                DummyJob dummyJob = new DummyJob(jobApplication.toString()) ;
                tableTV.getItems().add(jobApplication) ;
            }
        }


    }

    public ArrayList<JobApplication> readJobApplication() {
        ArrayList<JobApplication> jobApplicationArrayList = new ArrayList<>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("JobApplication.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            JobApplication jobApplication;
            try{
                while(true){
                    jobApplication = (JobApplication) ois.readObject();
                    jobApplicationArrayList.add(jobApplication) ;
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
        return jobApplicationArrayList ;
    }
}