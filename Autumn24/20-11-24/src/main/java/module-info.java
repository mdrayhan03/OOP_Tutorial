module mainpkg.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.demo to javafx.fxml;
    exports mainpkg.demo;
}