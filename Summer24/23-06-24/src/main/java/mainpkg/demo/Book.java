package mainpkg.demo;

public class Book {
    String bookName ;
    int page , id ;

    public Book(String bookName, int page, int id) {
        this.bookName = bookName;
        this.page = page;
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", page=" + page +
                ", id=" + id +
                '}';
    }
}
