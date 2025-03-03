package mainpkg.midpractice;

public class RegisteredCourse {
    private String id ;
    private int credit, section ;

    public RegisteredCourse(String id, int credit, int section) {
        this.id = id;
        this.credit = credit;
        this.section = section;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Course: " + this.getId() + " Credit: " + this.getCredit() + " Section: " + this.getSection() + "\n" ;
    }
}
