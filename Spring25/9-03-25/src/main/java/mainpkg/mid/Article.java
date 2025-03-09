package mainpkg.mid;

import java.time.LocalDate;

public class Article {
    String title, author, type ;
    int noOfAuthor ;
    boolean status ;
    LocalDate publication ;

    public Article(String title, String author, String type, int noOfAuthor, boolean status, LocalDate publication) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.noOfAuthor = noOfAuthor;
        this.status = status;
        this.publication = publication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfAuthor() {
        return noOfAuthor;
    }

    public void setNoOfAuthor(int noOfAuthor) {
        this.noOfAuthor = noOfAuthor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", noOfAuthor=" + noOfAuthor +
                ", status=" + status +
                ", publication=" + publication +
                '}';
    }

    public int publicationYear() {
        return this.publication.getYear() ;
    }
}
