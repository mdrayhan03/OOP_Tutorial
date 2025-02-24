package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class LibraryFxmlController
{
    @javafx.fxml.FXML
    private TextField mNSTF;
    @javafx.fxml.FXML
    private TextField memberNameTF;
    @javafx.fxml.FXML
    private TextField bookIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> mIdCB;
    @javafx.fxml.FXML
    private TextField aSTF;
    @javafx.fxml.FXML
    private ComboBox<String> bICB;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private TextField tDJTF;
    @javafx.fxml.FXML
    private DatePicker returnDP;
    @javafx.fxml.FXML
    private DatePicker memberDojDP;
    @javafx.fxml.FXML
    private DatePicker bookDojDP;
    @javafx.fxml.FXML
    private TextField tCSTF;
    @javafx.fxml.FXML
    private TextField tcTF;
    @javafx.fxml.FXML
    private PasswordField adminPass2PF;
    @javafx.fxml.FXML
    private PasswordField adminPass1PF;
    @javafx.fxml.FXML
    private TextField bookTitleTF;
    @javafx.fxml.FXML
    private TextField authorNameTF;
    @javafx.fxml.FXML
    private TextArea bLSTA;
    @javafx.fxml.FXML
    private TextField bTSTF;
    @javafx.fxml.FXML
    private Label errorL;

    ArrayList<Member> memberArrayList = new ArrayList<>() ;
    ArrayList<Book> bookArrayList = new ArrayList<>() ;
    ArrayList<IssueBook> issueBookArrayList = new ArrayList<>() ;
    int adminPassword = 1234 ;     ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void giveBooksOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bIOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addBookOA(ActionEvent actionEvent) {
        boolean bookFlag = true ;
        String bookId, title, author;
        int totalCopy, adminPass ;
        LocalDate doj ;

        bookId = bookIdTF.getText() ;
        title = bookTitleTF.getText() ;
        author = authorNameTF.getText() ;
        totalCopy = Integer.parseInt(tcTF.getText()) ;
        adminPass = Integer.parseInt(adminPass2PF.getText()) ;
        doj = bookDojDP.getValue() ;

        for (Book book : bookArrayList) {
            if (Objects.equals(book.getId(), bookId)) {
                errorL.setText("Book already exist");
                bookFlag = false ;
                break;
            }
        }
        if (adminPass != adminPassword) {
            errorL.setText("Password doesn't match");
            bookFlag = false ;
        }

        if (bookFlag) {
            Book book = new Book(title, bookId, author, totalCopy, doj) ;
            bookArrayList.add(book) ;
            this.updateBookIdCB();
            errorL.setText("New Book added.");
            bookIdTF.clear();
            bookTitleTF.clear();
            authorNameTF.clear();
            tcTF.clear();
        }
    }

    @javafx.fxml.FXML
    public void createMemberOA(ActionEvent actionEvent) {
        boolean memberFlag = true ;
        String memberName, memberId;
        LocalDate doj ;
        int adminpass ;
        memberName = memberNameTF.getText() ;
        memberId = memberIdTF.getText() ;
        doj = memberDojDP.getValue() ;
        adminpass = Integer.parseInt(adminPass1PF.getText()) ;

        for (Member member : memberArrayList) {
            if (Objects.equals(member.getId(), memberId)) {
                errorL.setText("Member already exist");
                memberFlag = false ;
                break;
            }
        }
        if (adminpass != adminPassword) {
            errorL.setText("Password doesn't match");
            memberFlag = false ;
        }

        if (memberFlag) {
            Member member = new Member(memberName, memberId, doj) ;
            memberArrayList.add(member) ;
            this.updateMemberIdCB();
            errorL.setText("New Member added.");
            memberIdTF.clear();
            memberNameTF.clear();
        }

    }

    @javafx.fxml.FXML
    public void mIdCBOA(ActionEvent actionEvent) {
        String memberId = mIdCB.getValue() ;
        for (Member member : memberArrayList) {
            if (Objects.equals(member.getId(), memberId)) {
                mNSTF.setText(member.getName());
                tDJTF.setText(member.getDoj().toString());
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void bIdCBOA(ActionEvent actionEvent) {
        String bookId = bICB.getValue() ;
        for (Book book : bookArrayList) {
            if (Objects.equals(book.getId(), bookId)) {
                bTSTF.setText(book.getTitle());
                tCSTF.setText(Integer.toString(book.getTotalCopy()));
                aSTF.setText(Integer.toString(book.getAvailableCopy()));
                break ;
            }
        }
    }

    private void updateMemberIdCB() {
        mIdCB.getItems().clear();
        for (Member member : memberArrayList) {
            mIdCB.getItems().add(member.getId()) ;
        }
    }

    private void updateBookIdCB() {
        mIdCB.getItems().clear();
        for (Book book : bookArrayList) {
            bICB.getItems().add(book.getId()) ;
        }
    }
}