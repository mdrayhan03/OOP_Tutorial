package mainpkg.mid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MidExamSceneController {

    @FXML
    private TextField titleTF;

    @FXML
    private TextField authorTF;

    @FXML
    private TextField noOfTF;

    @FXML
    private ComboBox<String> typeCB;

    @FXML
    private DatePicker publicationDP;

    @FXML
    private CheckBox statusChB;

    @FXML
    private TableView<Article> articleTV;

    @FXML
    private TableColumn<Article, String> titleTC;

    @FXML
    private TableColumn<Article, String> typeTC;

    @FXML
    private TableColumn<Article, LocalDate> dateTC;

    @FXML
    private TableColumn<Article, Boolean> statusTC;

    @FXML
    private TableColumn<Article, Integer> authTC;

    @FXML
    private ComboBox<String> typeFCB;

    @FXML
    private CheckBox statusFChB;

    @FXML
    private TextField lowerTF;

    @FXML
    private TextField upperTF;

    @FXML
    private TextArea articleListTA;

    private ArrayList<Article> articleArrayList = new ArrayList<>() ;

    @FXML
    void initialize() {
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("publication"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        authTC.setCellValueFactory(new PropertyValueFactory<>("noOfAuthor"));

        typeCB.getItems().addAll("Review", "Book", "Case") ;
        typeFCB.getItems().addAll("Review", "Book", "Case") ;
    }

    @FXML
    void addNewArticleOMC(MouseEvent event) {
        String title = titleTF.getText() ;
        String author = authorTF.getText() ;
        String type = typeCB.getValue() ;
        LocalDate publication = publicationDP.getValue() ;
        boolean status = false ;
        if (statusChB.isSelected()) {
            status = true ;
        }
        int noOfAuth = Integer.parseInt(noOfTF.getText()) ;

        Article article = new Article(title, author, type, noOfAuth, status, publication) ;
        articleArrayList.add(article) ;

        articleTV.getItems().clear();
        for (Article a : articleArrayList) {
            articleTV.getItems().add(a) ;
        }
    }

    @FXML
    void searchOA(ActionEvent event) {
        articleTV.getItems().clear();
        String type = typeFCB.getValue() ;
        boolean status = false ;
        if (statusFChB.isSelected()) {
            status = true ;
        }
        for (Article article : articleArrayList) {
            if (Objects.equals(article.getType(), type) && article.isStatus() == status) {
                articleTV.getItems().add(article) ;
            }
        }
    }

    @FXML
    void showArticleWithHighestAuthorButtonMouseOnClicked(MouseEvent event) {
        int m = -1 ;
        for (Article a : articleArrayList) {
            if (a.getNoOfAuthor() > m) {
                m = a.getNoOfAuthor() ;
            }
        }

        String title = "" ;
        for (Article article : articleArrayList) {
            if (article.getNoOfAuthor() == m) {
                title += article.getTitle() + "\n" ;
            }
        }
        articleListTA.setText(title);
    }

    @FXML
    void yearOA(ActionEvent event) {
        articleTV.getItems().clear();
        int lower = Integer.parseInt(lowerTF.getText()) ;
        int upper = Integer.parseInt(upperTF.getText()) ;
        for (Article article : articleArrayList) {
            if (article.publicationYear() >= lower && article.publicationYear() <= upper) {
                articleTV.getItems().add(article) ;
            }
        }
    }

}
