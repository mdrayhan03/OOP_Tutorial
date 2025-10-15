package mainpkg.demo;

import java.time.LocalDate;

public class Student {
    String id, name, email, phoneNo, major;
    LocalDate dob;

    public Student(String id, String name, String email, String phoneNo, String major, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.major = major;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return
                "ID=" + id + '\n' +
                "Name=" + name + '\n' +
                "Email=" + email + '\n' +
                "Phone No=" + phoneNo + '\n' +
                "Major='" + major + '\n' +
                "DoB=" + dob
                ;
    }

    public boolean check() {
        if (this.dob.isBefore(LocalDate.now())) {
            return true ;
        }
        else {
            return false ;
        }
    }
}
