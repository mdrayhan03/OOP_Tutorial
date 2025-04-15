package mainpkg.library;

import java.time.LocalDate;

public class Book {
    private int id, totalCopy, available ;
    private String title, authorName, description ;
    private LocalDate publicationDate ;

    public Book(int id, int totalCopy, String title, String authorName, String description, LocalDate publicationDate) {
        this.id = id;
        this.totalCopy = totalCopy;
        this.title = title;
        this.authorName = authorName;
        this.description = description;
        this.publicationDate = publicationDate;
        this.available = totalCopy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalCopy() {
        return totalCopy;
    }

    public void setTotalCopy(int totalCopy) {
        this.totalCopy = totalCopy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", totalCopy=" + totalCopy +
                ", available=" + available +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
