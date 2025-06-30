package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class LibraryFxmlController
{
    @javafx.fxml.FXML
    private DatePicker publishedDateDP;
    @javafx.fxml.FXML
    private Label serialNoL;
    @javafx.fxml.FXML
    private TextField pageTF;
    @javafx.fxml.FXML
    private TextField totalCopyTF;
    @javafx.fxml.FXML
    private ComboBox<String> categoryCB;
    @javafx.fxml.FXML
    private TextField bookNameTF;
    @javafx.fxml.FXML
    private TextField authorNameTF;
    @javafx.fxml.FXML
    private TextField memberNameTF;
    @javafx.fxml.FXML
    private TextArea listTA;
    @javafx.fxml.FXML
    private DatePicker returnDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> bookNameCB;
    @javafx.fxml.FXML
    private Label authorNameL;
    @javafx.fxml.FXML
    private TableView<Book> bookTV;
    @javafx.fxml.FXML
    private TableColumn<Book, String> bookNameTC;
    @javafx.fxml.FXML
    private TableColumn<Book, String> categoryTC;
    @javafx.fxml.FXML
    private TextField totalCopyFilterTF;
    @javafx.fxml.FXML
    private TableColumn<Book, Integer> serialTC;
    @javafx.fxml.FXML
    private TableColumn<Book, Integer> totalCopyTC;
    @javafx.fxml.FXML
    private ComboBox<String> categoryFilterCB;

    ArrayList<Book> bookArrayList = new ArrayList<>() ;
    ArrayList<Book> borrowBookListArrayList = new ArrayList<>() ;


    @javafx.fxml.FXML
    public void initialize() {
        categoryCB.getItems().addAll("Fiction", "Horror", "Drama", "Comedy", "Academic") ;
        categoryFilterCB.getItems().addAll("Fiction", "Horror", "Drama", "Comedy", "Academic") ;

        serialTC.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        bookNameTC.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        totalCopyTC.setCellValueFactory(new PropertyValueFactory<>("totalCopy"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("Category"));

        int serial = bookArrayList.size() + 1 ;
        serialNoL.setText(Integer.toString(serial)) ;
    }

    @javafx.fxml.FXML
    public void createBookOA(ActionEvent actionEvent) {

        int serial = bookArrayList.size() + 1 ;
        serialNoL.setText(Integer.toString(serial)) ;

        String bookName = bookNameTF.getText() ;
        String authorName = authorNameTF.getText() ;
        String category = categoryCB.getValue() ;
        int totalCopy = Integer.parseInt(totalCopyTF.getText()) ;
        int page = Integer.parseInt(pageTF.getText()) ;
        LocalDate publishedDate = publishedDateDP.getValue() ;

        Book book = new Book(serial, totalCopy, page, bookName, authorName, category, publishedDate) ;
        bookArrayList.add(book) ;

        this.customAlert("Book Creation", book.toString());
        bookNameCB.getItems().add(book.getBookName()) ;

        bookTV.getItems().clear() ;
        bookTV.getItems().addAll(bookArrayList) ;

        bookNameTF.clear();
        authorNameTF.clear();
        totalCopyTF.clear();
        pageTF.clear();
        categoryCB.setValue("");

        serial = bookArrayList.size() + 1 ;
        serialNoL.setText(Integer.toString(serial)) ;
    }

    private void customAlert(String title, String context) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle(title) ;
        alert.setContentText(context) ;
        alert.showAndWait() ;
    }

    @javafx.fxml.FXML
    public void bookNameCBOA(ActionEvent actionEvent) {
        String bookName = bookNameCB.getValue() ;

        for (Book book: bookArrayList) {
            if (Objects.equals(book.getBookName(), bookName)) {
                authorNameL.setText(book.getAuthorName());
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void selectOA(ActionEvent actionEvent) {
        String bookName = bookNameCB.getValue() ;

        for (Book book: bookArrayList) {
            if (Objects.equals(book.getBookName(), bookName)) {
                borrowBookListArrayList.add(book) ;
                listTA.appendText(book.getBookName() + ", ");
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void borrowOA(ActionEvent actionEvent) {
        String memberName = memberNameTF.getText() ;
        LocalDate returnDate = returnDateDP.getValue() ;

        BorrowBooks borrowBooks = new BorrowBooks(memberName, returnDate, borrowBookListArrayList) ;

        this.customAlert("Borrow Books", borrowBooks.toString());

        memberNameTF.clear();
        listTA.clear();
        borrowBookListArrayList.clear();
    }

    @javafx.fxml.FXML
    public void resetOA(ActionEvent actionEvent) {
        bookTV.getItems().clear() ;
        bookTV.getItems().addAll(bookArrayList) ;
    }

    @javafx.fxml.FXML
    public void loadOA(ActionEvent actionEvent) {
        bookTV.getItems().clear() ;
        int totalCopy = Integer.parseInt(totalCopyFilterTF.getText()) ; // less than equal
        String category = categoryFilterCB.getValue() ;

        for (Book book: bookArrayList) {
            if (book.getTotalCopy() <= totalCopy && Objects.equals(book.getCategory(), category)) {
                bookTV.getItems().add(book) ;
            }
        }
    }
}