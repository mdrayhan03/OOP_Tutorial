package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class StudentCourseController
{
    @FXML
    private ComboBox<String> courseCB;
    @FXML
    private RadioButton labRB;
    @FXML
    private CheckBox scholarshipChB;
    @FXML
    private ComboBox<Integer> filterSectionCB;
    @FXML
    private TextField scholarshipTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField creditTF;
    @FXML
    private RadioButton theoryRB;
    @FXML
    private ComboBox<Integer> sectionCB;
    @FXML
    private TextArea showFilteredInfoTA;
    @FXML
    private TextArea showInfoTA;

    ToggleGroup tg = new ToggleGroup() ;
    ArrayList<Course> courseArrayList = new ArrayList<>() ;
    ArrayList<RegisteredCourse> registeredCourses = new ArrayList<>() ;
    Student tempStud ;


    @FXML
    public void initialize() {
//        if courseType == 1 Theory else if ==2 Lab
        courseArrayList.add(new Course("CSE101", 1, new ArrayList<Integer>(1)));
        courseArrayList.add(new Course("CSE101L", 2, new ArrayList<Integer>(2))) ;
        courseArrayList.add(new Course("CSE211", 1, new ArrayList<Integer>(8))) ;
        courseArrayList.add(new Course("CSE211L", 2, new ArrayList<Integer>(2))) ;
        courseArrayList.add(new Course("MAT203", 1, new ArrayList<Integer>(6))) ;
        courseArrayList.add(new Course("PHY101L", 2, new ArrayList<Integer>(2))) ;
        courseArrayList.add(new Course("PHY101", 1, new ArrayList<Integer>(30))) ;
        courseArrayList.add(new Course("PHY102L", 2, new ArrayList<Integer>(18))) ;
        courseArrayList.add(new Course("PHY102", 1, new ArrayList<Integer>(12))) ;
        courseArrayList.add(new Course("MAT104", 2, new ArrayList<Integer>(25))) ;

//        courseCB.getItems().addAll() ;
        for (Course c : courseArrayList) {
            courseCB.getItems().add(c.getCourseID()) ;
        }

        for (int i=1; i<31; i++) {
            filterSectionCB.getItems().add(i) ;
        }

        theoryRB.setToggleGroup(tg);
        labRB.setToggleGroup(tg);
    }

    @FXML
    public void showTotalNoOfCoursesButtonOnClick(ActionEvent actionEvent) {
        int type = 0, section, cnt = 0;

        section = filterSectionCB.getValue() ;

        if (theoryRB.isSelected()) {
            type = 1 ;
        } else if (labRB.isSelected()) {
            type = 2 ;
        }

        for (Course course : courseArrayList) {
            if (course.getCourseType() == type) {
                for(Integer i : course.getCourseSection()) {
                    if (i == section) {
                        cnt ++ ;
                        break;
                    }
                }
            }
        }
        String output = "No of " + type + "having section-" + section +" is: " + cnt ;
        showFilteredInfoTA.setText(output);

    }

    @FXML
    public void proceedToRegisterAndShowRegInfoButtonOnClick(ActionEvent actionEvent) {
        int studentId, scholarship, totalCredit = 0;
        boolean hasScholarship , isValid = true;

        studentId = Integer.parseInt(idTF.getText()) ;
        scholarship = Integer.parseInt(scholarshipTF.getText()) ;

        if (scholarshipChB.isSelected()) {
            hasScholarship = true ;
            if (scholarshipTF.getText().isEmpty() || scholarship == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR) ;
                alert.setHeaderText("Scholarship Error");
                alert.setContentText("If 'HasScholarship' checkbox is checked there must be number how much.");
                alert.showAndWait() ;
                isValid = false ;
            }
        }
        else {
            hasScholarship = false ;
            scholarship = 0 ;
        }

        if (isValid) {
            tempStud = new Student(studentId, scholarship, hasScholarship);
            String output = "" ;

            output += "Student ID: " + tempStud.getStudentId() + " Scholarship: " + tempStud.isHasScholarship() + "; " + tempStud.getScholarshipRate() + "%, Tuition Fee per credit: 6000tk\n" ;
            output += "Registered Courses: \n" ;

            for (RegisteredCourse registeredCourse : registeredCourses) {
                output += "Course: " + registeredCourse.getCourseId() + ", Credit: " + registeredCourse.getCourseCredit() + ", Sec: " + registeredCourse.getSection() + "\n";
                totalCredit += registeredCourse.getCourseCredit() ;
            }

            int totalAmount = (totalCredit * 6000) ;
            int scholarshipAmount = totalAmount * tempStud.getScholarshipRate() / 100 ;
            int payable = totalAmount - scholarshipAmount ;

            output += "Total credit: " + totalCredit + ". Total payable amount: " + payable + "tk." ;

            showInfoTA.setText(output) ;
            registeredCourses.clear() ;
        }
    }

    @FXML
    public void addARegisteredCourseButtonOnClick(ActionEvent actionEvent) {
        sectionCB.getItems().clear();
        String courseID;
        int credit, section ;

        courseID = courseCB.getValue() ;
        credit = Integer.parseInt(creditTF.getText()) ;

        for(Course course:courseArrayList) {
            if (course.getCourseID() == courseID) {
                sectionCB.getItems().addAll(course.getCourseSection()) ;
            }
        }

        section = sectionCB.getValue() ;

        registeredCourses.add(new RegisteredCourse(courseID, credit, section)) ;
    }
}