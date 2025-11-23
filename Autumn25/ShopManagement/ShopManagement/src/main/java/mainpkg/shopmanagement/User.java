package mainpkg.shopmanagement;

import java.util.Objects;

public class User {
    private String id, name, email, pN, password ;

    public User(String id, String name, String email, String pN, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pN = pN;
        this.password = password;
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

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pN='" + pN + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

//    public abstract String generateID() {
//
//    }

    public User login(String id, String password) {
        if (Objects.equals(this.getId(), id) && Objects.equals(this.getPassword(), password)) {
            return this ;
        }
        else {
            return null ;
        }
    }

    public boolean resetPassword(String oldPassword, String newPassword) {
        if (Objects.equals(this.getPassword(), oldPassword)) {
            this.setPassword(newPassword);
            return true ;
        }
        return false ;
    }

}
