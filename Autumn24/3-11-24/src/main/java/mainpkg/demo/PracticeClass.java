package mainpkg.demo;

import java.time.LocalDate;

public class PracticeClass {
    private String string ;
    private int integer ;
    private float flt ;
    private boolean bool ;
//    private LocalDate date ;


    public PracticeClass(String string, int integer, float flt, boolean bool) {
        this.string = string;
        this.integer = integer;
        this.flt = flt;
        this.bool = bool;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public float getFlt() {
        return flt;
    }

    public void setFlt(float flt) {
        this.flt = flt;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return "PracticeClass{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                ", flt=" + flt +
                ", bool=" + bool +
                '}';
    }
}
