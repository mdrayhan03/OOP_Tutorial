module mainpkg.shopmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.shopmanagement to javafx.fxml;
    exports mainpkg.shopmanagement;
}