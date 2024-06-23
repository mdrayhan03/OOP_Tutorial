package mainpkg.demo;

public class DummyTable {
    String bookName , author , publisher , pn ;
    int id , page ;

    public DummyTable(String bookName, String author, String publisher, String pn, int id, int page) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.pn = pn;
        this.id = id;
        this.page = page;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "DummyTable{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pn='" + pn + '\'' +
                ", id=" + id +
                ", page=" + page +
                '}';
    }
}
