package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class NewTableFxml
{
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> autTC;
    @javafx.fxml.FXML
    private TextField pnTF;
    @javafx.fxml.FXML
    private TextField pageTF;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> pubTC;
    @javafx.fxml.FXML
    private TextField pubTF;
    @javafx.fxml.FXML
    private TextField bnTF;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> bnTC;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> pageTC;
    @javafx.fxml.FXML
    private TextField bidTF;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> pnTC;
    @javafx.fxml.FXML
    private TableView<DummyTable> infoTV;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> idTC;
    @javafx.fxml.FXML
    private TextField autTF;

    ArrayList<DummyTable> dummyarr = new ArrayList<>() ;
    ArrayList<Book> bookarr = new ArrayList<>() ;
    ArrayList<Author> authorarr = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        idTC.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        bnTC.setCellValueFactory(new PropertyValueFactory<>("bookName")) ;
        pageTC.setCellValueFactory(new PropertyValueFactory<>("page")) ;
        autTC.setCellValueFactory(new PropertyValueFactory<>("author")) ;
        pubTC.setCellValueFactory(new PropertyValueFactory<>("publisher")) ;
        pnTC.setCellValueFactory(new PropertyValueFactory<>("pn")) ;
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        for (DummyTable b :dummyarr) {
            System.out.println(b.getBookName());
            infoTV.getItems().add(b) ;
        }
        System.out.println(bookarr);
        System.out.println(authorarr);
    }

    @javafx.fxml.FXML
    public void addOnAction(ActionEvent actionEvent) {
        bookarr.add(new Book(bnTF.getText(),Integer.parseInt(pageTF.getText()),Integer.parseInt(bidTF.getText())));
        authorarr.add(new Author(autTF.getText(),pubTF.getText(),pnTF.getText()));
        dummyarr.add(new DummyTable(bnTF.getText(),pubTF.getText(),autTF.getText(),pnTF.getText(),Integer.parseInt(pageTF.getText()),Integer.parseInt(bidTF.getText()))) ;
    }
}