package mainpkg.demo;

public class Student {
    String name , course ;
    int id , sec ;

    public Student(String name, String course, int id, int sec) {
        this.name = name;
        this.course = course;
        this.id = id;
        this.sec = sec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
}
