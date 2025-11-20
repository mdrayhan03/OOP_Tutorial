module mainpkg.shopmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.shopmanagement to javafx.fxml;
    opens mainpkg.shopmanagement.Admin to javafx.fxml;
    opens mainpkg.shopmanagement.Customer to javafx.fxml;

    exports mainpkg.shopmanagement;
}