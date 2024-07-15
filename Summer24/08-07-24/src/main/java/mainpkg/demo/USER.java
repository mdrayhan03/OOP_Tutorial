package mainpkg.demo;

import java.util.Random;

public class USER {
    private int id ;
    private String name , pN ,pass ;

    public USER(int id_ , String name, String pN, String pass) {
        this.id = this.generateID(id_);
        this.name = name;
        this.pN = pN;
        this.pass = pass;
    }

    public int generateID(int id_) {
        Random r = new Random() ;
        int id = id_ + r.nextInt(8999) ;
        this.setId(id);
        return id ;

    }

    public boolean login(int id , String pass) {
        boolean b = false ;

        if (id == this.getId() && pass == this.getPass()) {
            b = true ;
        }

        return  b ;
    }

    public boolean changePass(String oldPass , String newPass) {
        boolean b = false ;

        if (oldPass == this.getPass()) {
            this.setPass(newPass) ;
            b = true ;
        }

        return b ;
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

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "USER{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pN='" + pN + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
