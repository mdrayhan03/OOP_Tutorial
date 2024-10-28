package mainpkg.demo;

public class Student {
    private int studentId, scholarshipRate;
    private boolean hasScholarship;

    public Student(int studentId, int scholarshipRate, boolean hasScholarship) {
        this.studentId = studentId;
        this.scholarshipRate = scholarshipRate;
        this.hasScholarship = hasScholarship;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getScholarshipRate() {
        return scholarshipRate;
    }

    public void setScholarshipRate(int scholarshipRate) {
        this.scholarshipRate = scholarshipRate;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", scholarshipRate=" + scholarshipRate +
                ", hasScholarship=" + hasScholarship +
                '}';
    }
}
