package mainpkg.demo;

import java.time.LocalDate;

public class Book {
    String title, id, author ;
    int totalCopy, availableCopy ;
    LocalDate doj ;

    public Book(String title, String id, String author, int totalCopy, LocalDate doj) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.totalCopy = totalCopy;
        this.availableCopy = totalCopy;
        this.doj = doj;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalCopy() {
        return totalCopy;
    }

    public void setTotalCopy(int totalCopy) {
        this.totalCopy = totalCopy;
    }

    public int getAvailableCopy() {
        return availableCopy;
    }

    public void setAvailableCopy(int availableCopy) {
        this.availableCopy = availableCopy;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", totalCopy=" + totalCopy +
                ", availableCopy=" + availableCopy +
                ", doj=" + doj +
                '}';
    }
}
