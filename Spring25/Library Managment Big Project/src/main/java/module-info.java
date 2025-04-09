module mainpkg.library {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.library to javafx.fxml;
    opens mainpkg.library.Librian to javafx.fxml;
    opens mainpkg.library.SoD to javafx.fxml;
    opens mainpkg.library.Member to javafx.fxml;
    exports mainpkg.library;
}