package mainpkg.demo;

import java.time.LocalDate;

public class Member {
    String name, id , status;
    LocalDate doj , sd;

    public Member(String name, String id, LocalDate doj) {
        this.name = name;
        this.id = id;
        this.doj = doj;
        this.status = "done" ;
    }
// if suspend status = running
// if not suspend status = done
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

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public LocalDate getSd() {return sd;}

    public void setSd(LocalDate sd) {this.sd = sd;}

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", doj=" + doj +
                ", sd=" + sd +
                '}';
    }
}
