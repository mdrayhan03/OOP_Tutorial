module mainpkg.demo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.demo2 to javafx.fxml;
    exports mainpkg.demo2;
}