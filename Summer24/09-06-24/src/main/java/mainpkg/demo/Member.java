package mainpkg.demo;

import java.util.ArrayList;
import java.util.Random;

public class Member {
    String name , type , phoneNo , doj , bio;
    int memberID ;
    ArrayList<Book> bookArrayList ;

    public Member(String name, String type, String phoneNo, String doj) {
        this.name = name;
        this.type = type;
        this.phoneNo = phoneNo;
        this.doj = doj;
        this.memberID = this.generateID();
        this.bookArrayList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }


    public int getMemberID() {
        return this.memberID;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(Book book) {
        this.bookArrayList.add(book);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = "Membership Bio";
    }

    public int generateID() {
        int id ;

        Random r = new Random() ;
        id = 1000000 + r.nextInt(8999999) ;

        return id ;
    }
}
