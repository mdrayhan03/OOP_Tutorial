module mainpkg.mid {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.mid to javafx.fxml;
    exports mainpkg.mid;
}