package mainpkg.library;

import java.time.LocalDate;

public class BorrowBook {
    private int id, memberID, bookID ;
    private LocalDate issueDate, returnDate ;
    private String status ;

    public BorrowBook(int id, int memberID, int bookID, LocalDate issueDate, LocalDate returnDate, String status) {
        this.id = id;
        this.memberID = memberID;
        this.bookID = bookID;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "id=" + id +
                ", memberID=" + memberID +
                ", bookID=" + bookID +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}
