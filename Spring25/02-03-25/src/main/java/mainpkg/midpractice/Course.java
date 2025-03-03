package mainpkg.midpractice;

public class Course {
    String name ;
    int credit ;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
