module mainpkg.object {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.object to javafx.fxml;
    exports mainpkg.object;
}