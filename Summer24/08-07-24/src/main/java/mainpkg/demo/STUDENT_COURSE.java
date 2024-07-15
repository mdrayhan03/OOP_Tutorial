package mainpkg.demo;

public class STUDENT_COURSE {
    private int id , studID , fcID ;

    public STUDENT_COURSE(int studID, int fcID) {
        this.studID = studID;
        this.fcID = fcID;
    }

    public int generateID() {
        return this.getFcID() + this.getStudID() ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public int getFcID() {
        return fcID;
    }

    public void setFcID(int fcID) {
        this.fcID = fcID;
    }

    @Override
    public String toString() {
        return "STUDENT_COURSE{" +
                "id=" + id +
                ", studID=" + studID +
                ", fcID=" + fcID +
                '}';
    }
}
