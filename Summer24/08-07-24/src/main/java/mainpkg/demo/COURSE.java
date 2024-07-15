package mainpkg.demo;

import java.util.Random;

public class COURSE {
    private int id , credit;
    private String title ;
    private COURSE pre ;

    public COURSE(int credit, String title) {
        this.id = this.generateID();
        this.credit = credit;
        this.title = title;
    }

    public int generateID() {
        int id = 10000 ;
        Random r = new Random() ;
        id += r.nextInt(89999) ;
        return id ;
    }

    public boolean addPre(COURSE pre) {
        this.setPre(pre) ;
        return true ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public COURSE getPre() {
        return pre;
    }

    public void setPre(COURSE pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "COURSE{" +
                "id=" + id +
                ", credit=" + credit +
                ", title='" + title + '\'' +
                ", pre=" + pre +
                '}';
    }
}
