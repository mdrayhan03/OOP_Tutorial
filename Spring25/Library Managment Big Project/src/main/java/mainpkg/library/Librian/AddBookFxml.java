package mainpkg.library.Librian;

import javafx.scene.control.TextField;

public class AddBookFxml
{

    @javafx.fxml.FXML
    private TextField bookTitleTF;

    public void setter(String title) {
        bookTitleTF.setText(title);
    }

    @javafx.fxml.FXML
    public void initialize() {
    }}