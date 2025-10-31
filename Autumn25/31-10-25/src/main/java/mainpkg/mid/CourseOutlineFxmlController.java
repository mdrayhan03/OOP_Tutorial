package mainpkg.mid;

import javafx.scene.control.* ;
import javafx.event.* ;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class CourseOutlineFxmlController
{
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> semesterTC;
    @javafx.fxml.FXML
    private TextField creditFTF;
    @javafx.fxml.FXML
    private TextField creditTF;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, Integer> creditTC;
    @javafx.fxml.FXML
    private TextArea desTA;
    @javafx.fxml.FXML
    private TableView<CourseOutline> courseOutlineTV;
    @javafx.fxml.FXML
    private TextField pre3TF;
    @javafx.fxml.FXML
    private TextField pre2TF;
    @javafx.fxml.FXML
    private TextField pre1TF;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> titleTC;
    @javafx.fxml.FXML
    private ComboBox<String> semesterCB;
    @javafx.fxml.FXML
    private TextField yearTF;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> idTC;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, Integer> yearTC;
    @javafx.fxml.FXML
    private Label semesterWiseL;
    @javafx.fxml.FXML
    private TextField idtF;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private ComboBox<String> semesterFCB;

    ArrayList<CourseOutline> courseOutlineArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        semesterCB.getItems().addAll("Autumn", "Summer", "Spring") ;
        semesterFCB.getItems().addAll("Autumn", "Summer", "Spring") ;

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        creditTC.setCellValueFactory(new PropertyValueFactory<>("credit"));
        semesterTC.setCellValueFactory(new PropertyValueFactory<>("semester"));
        yearTC.setCellValueFactory(new PropertyValueFactory<>("year"));
    }

    @javafx.fxml.FXML
    public void validateAddOA(ActionEvent actionEvent) {
        String id, title, pre1, pre2, pre3, semester, des ;
        int year, credit ;

        id = idtF.getText() ;
        title = titleTF.getText() ;
        pre1 = pre1TF.getText() ;
        pre2 = pre2TF.getText() ;
        pre3 = pre3TF.getText() ;
        semester = semesterCB.getValue() ;
        year = Integer.parseInt(yearTF.getText()) ;
        credit = Integer.parseInt(creditTF.getText()) ;
        des = desTA.getText() ;

        Alert alert = new Alert(Alert.AlertType.ERROR) ;
        alert.setTitle("Vaildation Error");


        if (pre1.isBlank() || pre1.equals("None")) {
            if (!pre2.isBlank() || !pre2.equals("None") || !pre3.isBlank() || !pre3.equals("None")) {
                alert.setContentText("If pre1 in none pre2 & pre3 must be none");
                alert.showAndWait() ;
                return;
            }
        }
        else if (!pre1.isBlank() || !pre1.equals("None")) {
            if (pre2.isBlank() || pre2.equals("None")) {
                if (!pre3.isBlank() || !pre3.equals("None")) {
                    alert.setContentText("If pre2 in none pre3 must be none");
                    alert.showAndWait() ;
                    return;
                }
            }
        }

        if (year > LocalDate.now().getYear()) {
            alert.setContentText("Year can't be future");
            alert.showAndWait() ;
            return;
        }

        CourseOutline courseOutline = new CourseOutline(id, title, pre1, pre2, pre3, semester, des, credit, year) ;
        courseOutlineArrayList.add(courseOutline) ;
    }

    @javafx.fxml.FXML
    public void semesterWiseCourseOutlineOA(ActionEvent actionEvent) {
        int autumn = 0 ;
        int summer = 0 ;
        int spring = 0 ;

        for (CourseOutline courseOutline: courseOutlineTV.getItems()) {
            if (Objects.equals(courseOutline.getSemester(), "Autumn")) {
                autumn += 1 ;
            }
            else if (Objects.equals(courseOutline.getSemester(), "Summer")) {
                summer += 1 ;
            }
            else if (Objects.equals(courseOutline.getSemester(), "Spring")) {
                spring += 1 ;
            }
        }

        semesterWiseL.setText(
                        "Autumn: " + autumn + "\n" +
                        "Summer: " + summer + "\n" +
                        "Spring: " + spring
        );
    }

    @javafx.fxml.FXML
    public void filterLoadOA(ActionEvent actionEvent) {
        courseOutlineTV.getItems().clear();
        String semester = semesterFCB.getValue() ;
        if (semester == null && creditFTF.getText().isBlank()) {
            courseOutlineTV.getItems().addAll(courseOutlineArrayList) ;
            return;
        }

        int credit = Integer.parseInt(creditFTF.getText()) ;

        for (CourseOutline courseOutline: courseOutlineArrayList) {
            if (Objects.equals(courseOutline.getSemester(), semester) && courseOutline.getCredit() == credit) {
                courseOutlineTV.getItems().add((courseOutline)) ;
            }
        }
    }
}