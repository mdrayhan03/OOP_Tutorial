module mainpkg.shopmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.shopmanagement to javafx.fxml;
    opens mainpkg.shopmanagement.Admin to javafx.fxml, javafx.base;
    opens mainpkg.shopmanagement.Customer to javafx.fxml, javafx.base;
    opens mainpkg.shopmanagement.ModelClasses to javafx.fxml, javafx.base;

    exports mainpkg.shopmanagement;
}