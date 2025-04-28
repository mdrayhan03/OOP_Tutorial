package mainpkg.finalsp25;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class JobApplication implements Serializable {
    private int applicationNo, experience;
    private String name, designation;
    private LocalDate applicationDate;
    private boolean freshGraduate;
    private ArrayList<String> expertiseList;
    private String showDetails ;

    public JobApplication(int applicationNo, int experience, String name, String designation, LocalDate applicationDate, boolean freshGraduate, ArrayList<String> expertiseList) {
        this.applicationNo = applicationNo;
        this.experience = experience;
        this.name = name;
        this.designation = designation;
        this.applicationDate = applicationDate;
        this.freshGraduate = freshGraduate;
        this.expertiseList = expertiseList;
        this.showDetails = this.toString();
    }

    public JobApplication() {
    }

    public int getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(int applicationNo) {
        this.applicationNo = applicationNo;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public boolean isFreshGraduate() {
        return freshGraduate;
    }

    public void setFreshGraduate(boolean freshGraduate) {
        this.freshGraduate = freshGraduate;
    }

    public ArrayList<String> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(ArrayList<String> expertiseList) {
        this.expertiseList = expertiseList;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationNo=" + applicationNo +
                ", experience=" + experience +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", applicationDate=" + applicationDate +
                ", freshGraduate=" + freshGraduate +
                ", expertiseList=" + expertiseList +
                '}';
    }

    public void showApplicationDetailAsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle("Show JopApplication Information");
        alert.setContentText("ApplicaitonNo: " + this.getApplicationNo() + '\n' +
                "Name: " + this.getName() + "\n");
        alert.showAndWait();
    }

}
