package mainpkg.demo;

import java.util.Date;
import java.util.Random;

public class CERTIFICATE {
    private int cerID ;
    private String title , inst ;
    private float cgpa ;
    private int passYear ;

    public CERTIFICATE(String title, String inst, float cgpa, int passYear) {
        this.title = title;
        this.inst = inst;
        this.cgpa = cgpa;
        this.passYear = passYear;
    }

    public int generateID() {
        int id = 100 ;

        Random r = new Random() ;
        id += r.nextInt(899) ;

        return id ;
    }

    public int getCerID() {
        return cerID;
    }

    public void setCerID(int cerID) {
        this.cerID = cerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public int getPassYear() {
        return passYear;
    }

    public void setPassYear(int passYear) {
        this.passYear = passYear;
    }

    @Override
    public String toString() {
        return "CERTIFICATE{" +
                "cerID=" + cerID +
                ", title='" + title + '\'' +
                ", inst='" + inst + '\'' +
                ", passYear=" + passYear +
                '}';
    }
}
