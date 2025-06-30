package mainpkg.demo;

import java.time.LocalDate;

public class Book {
    private int serialNo, totalCopy, page ;
    private String bookName, authorName, category ;
    private LocalDate publishedDate, issueDate ;

    public Book(int serialNo, int totalCopy, int page, String bookName, String authorName, String category, LocalDate publishedDate) {
        this.serialNo = serialNo;
        this.totalCopy = totalCopy;
        this.page = page;
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.publishedDate = publishedDate;
        this.issueDate = LocalDate.now();
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getTotalCopy() {
        return totalCopy;
    }

    public void setTotalCopy(int totalCopy) {
        this.totalCopy = totalCopy;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return
                "SerialNo=" + serialNo + '\n' +
                "TotalCopy=" + totalCopy + '\n' +
                "Page=" + page + '\n' +
                "BookName=" + bookName + '\n' +
                "AuthorName=" + authorName + '\n' +
                "Category=" + category + '\n' +
                "PublishedDate=" + publishedDate + '\n' +
                "IssueDate=" + issueDate
                ;
    }
}
