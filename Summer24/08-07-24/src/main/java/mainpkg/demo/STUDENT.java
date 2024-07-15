package mainpkg.demo;

import java.security.cert.Certificate;
import java.util.ArrayList;

public class STUDENT extends USER {
    private float cgpa ;
    private int credit ;
    private ArrayList<CERTIFICATE> certiArr ;
    private ArrayList<STUDENT_COURSE> couArr ;

    public STUDENT(int id, String name, String pN, String pass , ArrayList<CERTIFICATE> certiArr) {
        super(id, name, pN, pass);
        this.certiArr = certiArr ;
    }

    public boolean addCertificate(CERTIFICATE cer) {
//        boolean b = true ;
        certiArr.add(cer) ;
        return true ;
    }

    public boolean addCourse(STUDENT_COURSE cou) {
//        boolean b = true ;
        couArr.add(cou) ;
        return true ;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public ArrayList<CERTIFICATE> getCertiArr() {
        return certiArr;
    }

    public void setCertiArr(ArrayList<CERTIFICATE> certiArr) {
        this.certiArr = certiArr;
    }

    public ArrayList<STUDENT_COURSE> getCouArr() {
        return couArr;
    }

    public void setCouArr(ArrayList<STUDENT_COURSE> couArr) {
        this.couArr = couArr;
    }

    @Override
    public String toString() {
        return "STUDENT{" +
                "cgpa=" + cgpa +
                ", credit=" + credit +
                ", certiArr=" + certiArr +
                ", couArr=" + couArr +
                '}';
    }
}
