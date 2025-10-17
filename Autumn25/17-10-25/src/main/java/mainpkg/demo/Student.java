package mainpkg.demo;

import java.util.Objects;

public class Student {
    private String id, password ;

    public Student(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean login(String id, String password) {
        if (Objects.equals(this.getId(), id) && Objects.equals(this.getPassword(), password)) {
            return true ;
        }
        else {
            return false ;
        }
    }
}
