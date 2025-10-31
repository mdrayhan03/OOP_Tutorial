package mainpkg.mid;

import javafx.scene.control.Alert;

public class CourseOutline {
    private String id, title, pre1, pre2, pre3, semester, des ;
    private int credit, year ;

    public CourseOutline(String id, String title, String pre1, String pre2, String pre3, String semester, String des, int credit, int year) {
        this.id = id;
        this.title = title;
        this.pre1 = pre1;
        this.pre2 = pre2;
        this.pre3 = pre3;
        this.semester = semester;
        this.des = des;
        this.credit = credit;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPre1() {
        return pre1;
    }

    public void setPre1(String pre1) {
        this.pre1 = pre1;
    }

    public String getPre2() {
        return pre2;
    }

    public void setPre2(String pre2) {
        this.pre2 = pre2;
    }

    public String getPre3() {
        return pre3;
    }

    public void setPre3(String pre3) {
        this.pre3 = pre3;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CourseOutline{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", pre1='" + pre1 + '\'' +
                ", pre2='" + pre2 + '\'' +
                ", pre3='" + pre3 + '\'' +
                ", semester='" + semester + '\'' +
                ", des='" + des + '\'' +
                ", credit=" + credit +
                ", year=" + year +
                '}';
    }

    public void showCourseType() {
//        char type = this.getId().charAt(-1) ;
        String type = this.getId().substring(this.getId().length() - 1) ;

        if (type.equals("L")) {
            type = "Lab" ;
        }
        else {
            type = "Theory" ;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle("Course Type");
        alert.setContentText(type);
        alert.showAndWait() ;
    }
}
