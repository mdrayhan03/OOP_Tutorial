package mainpkg.midpractice;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Objects;

public class PracticeFxml
{
    @javafx.fxml.FXML
    private RadioButton labRB;
    @javafx.fxml.FXML
    private ComboBox<Integer> section1CB;
    @javafx.fxml.FXML
    private ComboBox<Integer> section2CB;
    @javafx.fxml.FXML
    private CheckBox scholarshipCheckB;
    @javafx.fxml.FXML
    private RadioButton theoryRB;
    @javafx.fxml.FXML
    private TextArea infoTA;
    @javafx.fxml.FXML
    private ComboBox<String> courseCB;
    @javafx.fxml.FXML
    private ToggleGroup tg;
    @javafx.fxml.FXML
    private TextField scholarTF;
    @javafx.fxml.FXML
    private Label creditL;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private Label totalSectionL;

    private Student tempStud ;
    private ArrayList<RegisteredCourse> registeredCourseList = new ArrayList<>() ;
    private ArrayList<Course> courseArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        courseArrayList.add(new Course("Course1", 3)) ;
        courseArrayList.add(new Course("Course2", 3)) ;
        courseArrayList.add(new Course("Course3", 3)) ;
        courseArrayList.add(new Course("Course4", 3)) ;
        courseArrayList.add(new Course("Course5", 3)) ;
        courseArrayList.add(new Course("Course6", 3)) ;
        courseArrayList.add(new Course("Course7", 3)) ;
        courseArrayList.add(new Course("Course8", 3)) ;

        for (Course course : courseArrayList) {
            courseCB.getItems().add(course.getName()) ;
        }

        for (int i = 1 ; i < 31 ; i++) {
            section1CB.getItems().add(i) ;
            section2CB.getItems().add(i) ;
        }
    }

    @javafx.fxml.FXML
    public void addCourseOA(ActionEvent actionEvent) {
        if (registeredCourseList.isEmpty()) {
            int id, rate = 0 ;
            boolean hasScl = false ;
            id = Integer.parseInt(idTF.getText()) ;
            if (scholarshipCheckB.isSelected()) {
                hasScl = true ;
                if (scholarTF.getText().isEmpty() || Integer.parseInt(scholarTF.getText()) == 0) {
                    System.out.println("Error");
                }
                else {
                    rate = Integer.parseInt(scholarTF.getText()) ;
                }
            }
            tempStud = new Student(id, rate, hasScl) ;
        }

        String name ;
        int credit, section ;
        name = courseCB.getValue() ;
        credit = Integer.parseInt(creditL.getText()) ;
        section = section1CB.getValue() ;
        RegisteredCourse registeredCourse = new RegisteredCourse(name, credit, section) ;
        registeredCourseList.add(registeredCourse) ;
    }

    @javafx.fxml.FXML
    public void registrationOA(ActionEvent actionEvent) {
        String str = "" ;
        str += tempStud.toString() ;
        str += "Registered Courses: \n" ;
        int cnt = 0 ;
        for (RegisteredCourse registeredCourse : registeredCourseList) {
            str += registeredCourse.toString() ;
            cnt += registeredCourse.getCredit() ;
        }
        str += "Total credit: " + cnt + " Bill: " + ((6000 - (6000 * tempStud.getRate() / 100)) * cnt) + "tk" ;
        if (tempStud.isHasScholarship() && (cnt >= 12 || cnt <= 18 )) {
            infoTA.setText(str);
        }
        else if (!tempStud.isHasScholarship() && (cnt >= 6 || cnt <= 18 )) {
            infoTA.setText(str);
        }
        else {
            infoTA.setText("Condition not fulfill.");
        }
    }

    @javafx.fxml.FXML
    public void creditOA(ActionEvent actionEvent) {
        String name = courseCB.getValue() ;
        for(Course course : courseArrayList) {
            if (Objects.equals(course.getName(), name)) {
                creditL.setText(Integer.toString(course.getCredit()));
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void showOA(ActionEvent actionEvent) {
        int credit = 0, section, cnt = 0 ;
        String type = "" ;
        if (theoryRB.isSelected()) {
            credit = 3 ;
            type = "Theory" ;
        } else if (labRB.isSelected()) {
            credit = 1 ;
            type = "Lab" ;
        }
        section = section2CB.getValue() ;

        for (RegisteredCourse registeredCourse : registeredCourseList) {
            if (registeredCourse.getCredit() == credit && registeredCourse.getSection() == section) {
                cnt ++ ;
            }
        }
        totalSectionL.setText("No of " + type + " courses having section-" + section + " is: " + cnt);
    }
}