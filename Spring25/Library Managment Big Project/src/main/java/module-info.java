module mainpkg.library {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.library to javafx.fxml;
    exports mainpkg.library;
}