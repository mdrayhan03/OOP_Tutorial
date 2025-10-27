package mainpkg.demo;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name, email, pN, dept, bio, password ;
    private boolean isFresher ;
    private LocalDate dob ;

    public Employee(int id, String name, String email, String pN, String dept, String bio, String password, boolean isFresher, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pN = pN;
        this.dept = dept;
        this.bio = bio;
        this.password = password;
        this.isFresher = isFresher;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFresher() {
        return isFresher;
    }

    public void setFresher(boolean fresher) {
        isFresher = fresher;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pN='" + pN + '\'' +
                ", dept='" + dept + '\'' +
                ", bio='" + bio + '\'' +
                ", password='" + password + '\'' +
                ", isFresher=" + isFresher +
                ", dob=" + dob +
                '}';
    }
}
