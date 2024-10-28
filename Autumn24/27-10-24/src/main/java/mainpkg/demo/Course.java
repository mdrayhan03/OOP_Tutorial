package mainpkg.demo;

import java.util.ArrayList;

public class Course {
    private String courseID;
    private int courseType;
    private ArrayList<Integer> courseSection;

    public Course(String courseID, int courseType, ArrayList<Integer> courseSection) {
        this.courseID = courseID;
        this.courseType = courseType;
        this.courseSection = courseSection;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public void setCourseSection(ArrayList<Integer> courseSection) {
        this.courseSection = courseSection;
    }

    public ArrayList<Integer> getCourseSection() {
        return courseSection;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseType=" + courseType +
                ", courseSection=" + courseSection +
                '}';
    }
}
