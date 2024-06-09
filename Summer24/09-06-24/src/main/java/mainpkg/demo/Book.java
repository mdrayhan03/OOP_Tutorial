package mainpkg.demo;

import java.util.Random;

public class Book {
    String name , author , publication ;
    int id , total , borrowBook;

    public Book(String name, String author, String publication, int total) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.total = total;
        this.id = this.generateID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBorrowBook() {
        return borrowBook;
    }

    public void setBorrowBook() {
        this.borrowBook += 1;
    }

    private int generateID() {
        int id ;

        Random r = new Random() ;
        id = 1000 + r.nextInt(8999) ;

        return id ;
    }
}
