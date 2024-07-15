package mainpkg.demo;

public class FACULTY_COURSE {
    private int fcID , facultyID , courseID , sec;
    private String day , time ;

    public FACULTY_COURSE(int facultyID, int courseID, int sec, String day, String time) {
        this.facultyID = facultyID;
        this.courseID = courseID;
        this.sec = sec;
        this.day = day;
        this.time = time;
        this.fcID = this.generateID() ;
    }

    public int generateID() {
        int id ;
        id = this.getCourseID() + this.getFacultyID() ;
        return id ;
    }

    public int getFcID() {
        return fcID;
    }

    public void setFcID(int fcID) {
        this.fcID = fcID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FACULTY_COURSE{" +
                "fcID=" + fcID +
                ", facultyID=" + facultyID +
                ", courseID=" + courseID +
                ", sec=" + sec +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
