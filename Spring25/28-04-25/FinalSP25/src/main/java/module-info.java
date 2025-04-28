module mainpkg.finalsp25 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.finalsp25 to javafx.fxml;
    exports mainpkg.finalsp25;
}