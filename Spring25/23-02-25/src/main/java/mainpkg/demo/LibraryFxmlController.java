package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @javafx.fxml.FXML
    private TextArea sMLTA;
    @javafx.fxml.FXML
    private TextField sTCTF;
    @javafx.fxml.FXML
    private ComboBox<String> uBICB;
    @javafx.fxml.FXML
    private TextField sACTF;
    @javafx.fxml.FXML
    private TextField nCTF;
    @javafx.fxml.FXML
    private DatePicker sDDP;
    @javafx.fxml.FXML
    private ComboBox<String> sMICB;
    @javafx.fxml.FXML
    private TextArea sMBLTA;

    ArrayList<Member> memberArrayList = new ArrayList<>() ;
    ArrayList<Book> bookArrayList = new ArrayList<>() ;
    ArrayList<IssueBook> issueBookArrayList = new ArrayList<>() ;
    ArrayList<IssueBook> temporaryList = new ArrayList<>() ;
    int adminPassword = 1234 ;
    String bookList = "" ;
    boolean flag = true ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void giveBooksOA(ActionEvent actionEvent) {
        for (IssueBook issueBook : temporaryList) {
            IssueBook i = new IssueBook(issueBook.getMemberId(), issueBook.getBookId(), issueBook.getIssueDate(), issueBook.getReturnDate()) ;
            issueBookArrayList.add(i) ;
            for (Book book : bookArrayList) {
                if (Objects.equals(book.getId(), issueBook.getBookId())) {
                    book.setAvailableCopy(book.getAvailableCopy() - 1) ;
                    break;
                }
            }
        }
        errorL.setText("All issued books are handover.");
        temporaryList.clear() ;
        bookList = "" ;
        bLSTA.clear() ;
        mIdCB.setValue("Member ID") ;
        bICB.setValue("Book ID") ;
        mNSTF.clear() ;
        tDJTF.clear() ;
        bTSTF.clear() ;
        tCSTF.clear() ;
        aSTF.clear() ;
    }

    @javafx.fxml.FXML
    public void bIOA(ActionEvent actionEvent) {
        boolean issueFlag = true ;
        String memberID, bookID ;
        LocalDate returnDate ;

        memberID = mIdCB.getValue() ;
        bookID = bICB.getValue() ;
        returnDate = returnDP.getValue() ;

        if (returnDate.isBefore(LocalDate.now())) {
            errorL.setText("Return date is before today.");
            issueFlag = false ;
        }

        for (IssueBook issueBook : issueBookArrayList) {
            if (Objects.equals(issueBook.getBookId(), bookID) && Objects.equals(issueBook.getMemberId(), memberID)) {
                errorL.setText("Book already issued.");
                issueFlag = false ;
                break ;
            }
        }

        for (IssueBook issueBook : temporaryList) {
            if (Objects.equals(issueBook.getBookId(), bookID) && Objects.equals(issueBook.getMemberId(), memberID)) {
                errorL.setText("Book already issued.");
                issueFlag = false ;
                break ;
            }
        }

        for (Book book : bookArrayList) {
            if (Objects.equals(book.getId(), bookID)) {
                if (book.getAvailableCopy() == 0) {
                    issueFlag = false ;
                    errorL.setText("Book is not available.");
                    break ;
                }
                else {
                    break ;
                }
            }
        }
        if (issueFlag && flag) {
            IssueBook issueBook = new IssueBook(memberID, bookID, LocalDate.now(), returnDate) ;
            temporaryList.add(issueBook) ;
            bookList += "Book ID: " + bookID + "\n" ;
            bLSTA.setText(bookList);
        }
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
        flag = true ;
        String memberId = mIdCB.getValue() ;
        for (Member member : memberArrayList) {
            if (Objects.equals(member.getId(), memberId)) {
                mNSTF.setText(member.getName());
                tDJTF.setText(member.getDoj().toString());
                if(Objects.equals(member.getStatus(), "running")) {
                    errorL.setText("Member is suspended.");
                    flag = false ;
                }
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
        sMICB.getItems().clear();
        for (Member member : memberArrayList) {
            mIdCB.getItems().add(member.getId()) ;
            sMICB.getItems().add(member.getId()) ;
        }
    }

    private void updateBookIdCB() {
        bICB.getItems().clear();
        uBICB.getItems().clear();
        for (Book book : bookArrayList) {
            bICB.getItems().add(book.getId()) ;
            uBICB.getItems().add(book.getId()) ;
        }
    }

    @javafx.fxml.FXML
    public void cancelOA(ActionEvent actionEvent) {
        errorL.setText("All issued books are canceled.");
        temporaryList.clear() ;
        bookList = "" ;
        bLSTA.clear() ;
        mIdCB.setValue("Member ID") ;
        bICB.setValue("Book ID") ;
        mNSTF.clear() ;
        tDJTF.clear() ;
        bTSTF.clear() ;
        tCSTF.clear() ;
        aSTF.clear() ;
    }

    @javafx.fxml.FXML
    public void uBICBOA(ActionEvent actionEvent) {
        String bookId = uBICB.getValue() ;
        String list = "" ;
        int cnt = 0 ;
        for (IssueBook issueBook : issueBookArrayList) {
            if (Objects.equals(issueBook.getBookId(), bookId)) {
                list += "Member ID: " + issueBook.getMemberId() + "\n" ;
                cnt ++ ;
            }
        }
        list += "Total member: " + cnt ;
        sMLTA.setText(list);
        for (Book book : bookArrayList) {
            if (Objects.equals(book.getId(), bookId)) {
                sTCTF.setText(Integer.toString(book.getTotalCopy()));
                sACTF.setText(Integer.toString(book.getAvailableCopy()));
                break ;
            }
        }
    }

    @javafx.fxml.FXML
    public void aNCOA(ActionEvent actionEvent) {
        String bookId = uBICB.getValue() ;
        int newCopies = Integer.parseInt(nCTF.getText()) ;
        for (Book book : bookArrayList) {
            if (Objects.equals(book.getId(), bookId)) {
                book.setTotalCopy(book.getTotalCopy() + newCopies) ;
                book.setAvailableCopy(book.getAvailableCopy() + newCopies) ;
                break ;
            }
        }
        errorL.setText("New copies added.");
        nCTF.clear();
        for (Book book : bookArrayList) {
            if (Objects.equals(book.getId(), bookId)) {
                sTCTF.setText(Integer.toString(book.getTotalCopy()));
                sACTF.setText(Integer.toString(book.getAvailableCopy()));
                break ;
            }
        }
    }

    @javafx.fxml.FXML
    public void sMICBOA(ActionEvent actionEvent) {
        String memberId = sMICB.getValue() ;
        String list = "" ;
        int cnt = 0 ;
        for (IssueBook issueBook : issueBookArrayList) {
            if (Objects.equals(issueBook.getMemberId(), memberId)) {
                list += "Book ID: " + issueBook.getBookId() + "\n" ;
                cnt ++ ;
            }
        }
        list += "Total issued book: " + cnt ;
        sMBLTA.setText(list);
    }

    @javafx.fxml.FXML
    public void suspendOA(ActionEvent actionEvent) {
        String memberId = sMICB.getValue() ;
        LocalDate sD = sDDP.getValue() ;
        if (sD.isBefore(LocalDate.now())) {
            errorL.setText("Suspend date is before today.");
        }
        else {
            for (Member member : memberArrayList) {
                if (Objects.equals(member.getId(), memberId)) {
                    member.setStatus("running");
                    member.setSd(sD);
                    errorL.setText("Member is suspended.");
                    break;
                }
            }
        }
    }
}