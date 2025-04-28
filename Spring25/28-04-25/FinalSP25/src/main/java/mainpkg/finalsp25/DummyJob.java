package mainpkg.finalsp25;

import java.time.LocalDate;
import java.util.ArrayList;

public class DummyJob extends JobApplication {
    private String showDetails;

    public DummyJob(int applicationNo, int experience, String name, String designation, LocalDate applicationDate, boolean freshGraduate, ArrayList<String> expertiseList, String showDetails) {
        super(applicationNo, experience, name, designation, applicationDate, freshGraduate, expertiseList);
        this.showDetails = showDetails ;
    }

    public DummyJob(String showDetails) {
        this.showDetails = showDetails;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    @Override
    public String toString() {
        return "DummyJob{" +
                "showDetails='" + showDetails + '\'' +
                '}';
    }
}
