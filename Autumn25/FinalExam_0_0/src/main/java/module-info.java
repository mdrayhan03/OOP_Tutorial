module mainpkg.finalexam_0_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.finalexam_0_0 to javafx.fxml;
    exports mainpkg.finalexam_0_0;
}