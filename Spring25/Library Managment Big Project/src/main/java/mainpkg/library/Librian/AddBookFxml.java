package mainpkg.library.Librian;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AddBookFxml
{

    @javafx.fxml.FXML
    private TextField bookTitleTF;
    @javafx.fxml.FXML
    private TableView bookTV;
    @javafx.fxml.FXML
    private TableColumn aNTC;
    @javafx.fxml.FXML
    private TextField aNTF;
    @javafx.fxml.FXML
    private TableColumn availableTC;
    @javafx.fxml.FXML
    private TableColumn titleTC;
    @javafx.fxml.FXML
    private TextField desTF;
    @javafx.fxml.FXML
    private TextField totalCopyTF;
    @javafx.fxml.FXML
    private DatePicker pubDP;
    @javafx.fxml.FXML
    private TableColumn idTC;
    @javafx.fxml.FXML
    private TableColumn tCTC;
    @javafx.fxml.FXML
    private TableColumn aDTC;

    Librian user ;

    public void setter(String title) {
        bookTitleTF.setText(title);
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addNewBookOA(ActionEvent actionEvent) {
        String title, authorName, description ;
        int totalCopy ;
        LocalDate pubDate ;

        title = bookTitleTF.getText() ;
        authorName = aNTF.getText() ;
        description = desTF.getText() ;
        totalCopy = Integer.parseInt(totalCopyTF.getText()) ;
        pubDate = pubDP.getValue() ;

        user.addBook(title, authorName, description, pubDate, totalCopy) ;
    }
}