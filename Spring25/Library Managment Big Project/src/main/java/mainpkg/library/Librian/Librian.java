package mainpkg.library.Librian;

import mainpkg.library.Book;
import mainpkg.library.BorrowBook;
import mainpkg.library.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class Librian extends User implements Serializable {
    public Librian(int id, String name, String email, String pN, String password, String type, String address, LocalDate dob) {
        super(id, name, email, pN, password, type, address, dob);
    }

    public Book addBook(String title, String authorName, String description, LocalDate publicationDate, int totalCopy) {
        int id = 0 ;
        Random r = new Random() ;
        id += r.nextInt(1000, 9999) ;
        return new Book(id, totalCopy, title, authorName, description, publicationDate) ;
    }

    public BorrowBook borrowBookControl(BorrowBook borrowBook, String status) {
        borrowBook.setStatus(status) ;
        return borrowBook ;
    }
}
