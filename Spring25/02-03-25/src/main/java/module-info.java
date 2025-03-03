module mainpkg.midpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens mainpkg.midpractice to javafx.fxml;
    exports mainpkg.midpractice;
}