package mainpkg.demo;

import java.time.LocalDate;

public class Member {
    String name, id ;
    LocalDate doj;

    public Member(String name, String id, LocalDate doj) {
        this.name = name;
        this.id = id;
        this.doj = doj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", doj=" + doj +
                '}';
    }
}
