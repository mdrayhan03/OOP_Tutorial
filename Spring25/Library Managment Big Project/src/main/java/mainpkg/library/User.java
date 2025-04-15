package mainpkg.library;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private int id ;
    private String name, email, pN, password, type, address ;
    private LocalDate dob ;

    public User(int id, String name, String email, String pN, String password, String type, String address, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pN = pN;
        this.password = password;
        this.type = type;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pN='" + pN + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}
