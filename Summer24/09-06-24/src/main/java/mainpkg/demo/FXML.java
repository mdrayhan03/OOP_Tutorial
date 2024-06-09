package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class FXML
{
    @javafx.fxml.FXML
    private Label memberNameLabel;
    @javafx.fxml.FXML
    private Label publicationLabel;
    @javafx.fxml.FXML
    private ComboBox<Integer> memberComboBox;
    @javafx.fxml.FXML
    private Label tbLabel;
    @javafx.fxml.FXML
    private RadioButton childrenRadioButton;
    @javafx.fxml.FXML
    private CheckBox yesCheckBox;
    @javafx.fxml.FXML
    private Label authorNameLabel;
    @javafx.fxml.FXML
    private Label totalMemberLabel;
    @javafx.fxml.FXML
    private Label tbBookLabel;
    @javafx.fxml.FXML
    private Label bookNameLabel;
    @javafx.fxml.FXML
    private RadioButton adultRadioButton;
    @javafx.fxml.FXML
    private Label memberTypeLabel;
    @javafx.fxml.FXML
    private Label tcLabel;
    @javafx.fxml.FXML
    private ComboBox<Integer> bookComboBox;

    ArrayList<Children> childrenArrayList = new ArrayList<>() ;
    ArrayList<Adult> adultArrayList = new ArrayList<>() ;
    ArrayList<Book> bookArrayList = new ArrayList<>() ;

    ToggleGroup tg = new ToggleGroup() ;

    Member selectedMember ;
    Book selectedBook ;

    @javafx.fxml.FXML
    public void initialize() {
        childrenArrayList.add(new Children("Shafiq" , "Children" , "1233244" , "01-01-2000" ));
        childrenArrayList.add(new Children("Tanvir" , "Children" , "1233244" , "01-01-2000" ));
        childrenArrayList.add(new Children("Hridoy" , "Children" , "1233244" , "01-01-2000" ));

        adultArrayList.add(new Adult("Shohag" , "Adult" , "1234545" , "01-03-2020"));
        adultArrayList.add(new Adult("Mehedi" , "Adult" , "1233434" , "01-01-2022"));

        bookArrayList.add(new Book("Book1" , "Author1" , "Publication1" , 10));
        bookArrayList.add(new Book("Book2" , "Author3" , "Publication2" , 10));
        bookArrayList.add(new Book("Book3" , "Author2" , "Publication1" , 10));

        childrenRadioButton.setToggleGroup(tg);
        adultRadioButton.setToggleGroup(tg);

        for (Children c : childrenArrayList) {
            memberComboBox.getItems().add(c.getMemberID()) ;
        }

        for (Adult a : adultArrayList) {
            memberComboBox.getItems().add(a.getMemberID()) ;
        }

        for (Book b : bookArrayList) {
            bookComboBox.getItems().add(b.getId()) ;
        }


    }

    @javafx.fxml.FXML
    public void borrowBookOnAction(ActionEvent actionEvent) {
        selectedBook.setBorrowBook();
        selectedMember.setBookArrayList(selectedBook);

        tbBookLabel.setText(Integer.toString(selectedMember.getBookArrayList().size()));
        tbLabel.setText(Integer.toString(selectedBook.getBorrowBook()));
    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        String rb = "" ;
        boolean checkbox;

        if (childrenRadioButton.isSelected()) {
            rb = "Children" ;
        }
        else if (adultRadioButton.isSelected()) {
            rb = "Adult" ;
        }

        checkbox = yesCheckBox.isSelected() ;
        System.out.println(checkbox);

        int total = 0 ;

        if (rb == "Children") {
            if (yesCheckBox.isSelected()) {
                for (Children c : childrenArrayList) {
                    if (c.getBookArrayList().size() <= 3) {
                        total ++ ;
                    }
                }
                totalMemberLabel.setText(Integer.toString(total));
            }
            else {
                totalMemberLabel.setText(Integer.toString(childrenArrayList.size()));
            }
        }

        if (rb == "Adult") {
            if (yesCheckBox.isSelected()) {
                for (Adult c : adultArrayList) {
                    if (c.getBookArrayList().size() <= 3) {
                        total ++ ;
                    }
                }
                totalMemberLabel.setText(Integer.toString(total));
            }
            else {
                totalMemberLabel.setText(Integer.toString(adultArrayList.size()));
            }
        }

    }

    @javafx.fxml.FXML
    public void bookOnClick(ActionEvent actionEvent) {
        int bookId ;

        bookId = bookComboBox.getValue() ;

        for (Book b : bookArrayList) {
            if (bookId == b.getId()) {
                selectedBook = b ;
                bookNameLabel.setText(b.getName());
                authorNameLabel.setText(b.getAuthor());
                publicationLabel.setText(b.getPublication());
                tcLabel.setText(Integer.toString(b.getTotal()));
                tbLabel.setText(Integer.toString(b.getBorrowBook()));
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void memberShipOnClick(ActionEvent actionEvent) {
        int memberID ;
//        String memberType ;

        memberID = memberComboBox.getValue() ;
        for (Children c : childrenArrayList) {
            if (memberID == c.getMemberID()) {
                selectedMember = c ;
                memberNameLabel.setText(c.getName());
                memberTypeLabel.setText(c.getType());
                tbBookLabel.setText(Integer.toString(c.getBookArrayList().size()));
                break;
            }
        }

        for (Adult a : adultArrayList) {
            if (memberID == a.getMemberID()) {
                selectedMember = a ;
                System.out.println(a.getName());
                memberNameLabel.setText(a.getName());
                memberTypeLabel.setText(a.getType());
                tbBookLabel.setText(Integer.toString(a.getBookArrayList().size()));
                break;
            }
        }
    }
}