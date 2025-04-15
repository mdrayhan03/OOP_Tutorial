package mainpkg.library.Librian;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mainpkg.library.BorrowBook;

public class BorrowBookListFxml
{
    @javafx.fxml.FXML
    private Label bIDL;
    @javafx.fxml.FXML
    private ComboBox<Integer> bBIDCB;
    @javafx.fxml.FXML
    private TableColumn bIDTC;
    @javafx.fxml.FXML
    private TableView bBTV;
    @javafx.fxml.FXML
    private Label iDL;
    @javafx.fxml.FXML
    private TableColumn mIDTC;
    @javafx.fxml.FXML
    private TableColumn rDTC;
    @javafx.fxml.FXML
    private Label mIDL;
    @javafx.fxml.FXML
    private Label statusL;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TableColumn iDTC;
    @javafx.fxml.FXML
    private TableColumn idTC;
    @javafx.fxml.FXML
    private Label rDL;

    Librian user ;
    ObservableList<BorrowBook> borrowBookObservableList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bBIDCBOA(ActionEvent actionEvent) {
        int id = bBIDCB.getValue() ;
        for (BorrowBook borrowBook : borrowBookObservableList) {
            if (borrowBook.getId() == id) {
                bIDL.setText(Integer.toString(borrowBook.getBookID()));
                mIDL.setText(Integer.toString(borrowBook.getMemberID()));
                iDL.setText(borrowBook.getIssueDate().toString());
                rDL.setText(borrowBook.getReturnDate().toString());
                statusL.setText(borrowBook.getStatus());
                break ;
            }
        }
    }

    @javafx.fxml.FXML
    public void acceptOA(ActionEvent actionEvent) {
        int id = bBIDCB.getValue() ;
        for (BorrowBook borrowBook : borrowBookObservableList) {
            if (borrowBook.getId() == id) {
                user.borrowBookControl(borrowBook, "accept") ;
                break ;
            }
        }
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {
        int id = bBIDCB.getValue() ;
        for (BorrowBook borrowBook : borrowBookObservableList) {
            if (borrowBook.getId() == id) {
                user.borrowBookControl(borrowBook, "reject") ;
                break ;
            }
        }
    }
}