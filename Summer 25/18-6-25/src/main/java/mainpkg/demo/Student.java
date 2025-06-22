package mainpkg.demo;

public class Student {
    String id, name, phone, email, dept, password ;
    boolean hasScholarship ;
    float scholarship, cgpa ;
    int creditComplete ;

    public Student(String id, String name, String phone, String email, String dept, String password, boolean hasScholarship, float scholarship) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dept = dept;
        this.password = password;
        this.hasScholarship = hasScholarship;
        this.scholarship = scholarship;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getCreditComplete() {
        return creditComplete;
    }

    public void setCreditComplete(int creditComplete) {
        this.creditComplete = creditComplete;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", password='" + password + '\'' +
                ", hasScholarship=" + hasScholarship +
                ", scholarship=" + scholarship +
                ", cgpa=" + cgpa +
                ", creditComplete=" + creditComplete +
                '}';
    }

//    todo
//    courseRegistration
//    checkCourses
//    gradeCheck
//    billPay
//    billDownload
//    withDrawCourse
//    transcriptDownload
}
