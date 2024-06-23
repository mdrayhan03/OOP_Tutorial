package mainpkg.demo;

public class Author {
    String author , publisher , pn ;

    public Author(String author, String publisher, String pn) {
        this.author = author;
        this.publisher = publisher;
        this.pn = pn;
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

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pn='" + pn + '\'' +
                '}';
    }
}
