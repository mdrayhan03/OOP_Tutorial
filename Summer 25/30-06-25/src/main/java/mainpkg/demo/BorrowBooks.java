package mainpkg.demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class BorrowBooks {
    private String memberName ;
    private LocalDate issueDate, returnDate ;
    private ArrayList<Book> bookArrayList ;

    public BorrowBooks(String memberName, LocalDate returnDate, ArrayList<Book> bookArrayList) {
        this.memberName = memberName;
        this.issueDate = LocalDate.now();
        this.returnDate = returnDate;
        this.bookArrayList = bookArrayList;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    @Override
    public String toString() {
        return
                "MemberName=" + memberName + '\n' +
                "IssueDate=" + issueDate + '\n' +
                "ReturnDate=" + returnDate + '\n' +
                "BookArrayList=" + bookArrayList
                ;
    }

    public int totalBorrowedBook() {
        return this.bookArrayList.size() ;
    }
}
