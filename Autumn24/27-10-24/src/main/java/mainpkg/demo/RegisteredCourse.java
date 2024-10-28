package mainpkg.demo;

public class RegisteredCourse {
    private String courseId;
    private int courseCredit, section;

    public RegisteredCourse(String courseId, int courseCredit, int section) {
        this.courseId = courseId;
        this.courseCredit = courseCredit;
        this.section = section;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "RegisteredCourse{" +
                "courseId='" + courseId + '\'' +
                ", courseCredit=" + courseCredit +
                ", section=" + section +
                '}';
    }
}
