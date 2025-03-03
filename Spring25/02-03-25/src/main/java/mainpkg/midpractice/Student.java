package mainpkg.midpractice;

public class Student {
    private int id, rate ;
    private boolean hasScholarship ;

    public Student(int id, int rate, boolean hasScholarship) {
        this.id = id;
        this.rate = rate;
        this.hasScholarship = hasScholarship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    @Override
    public String toString() {
        return "Student ID: " + this.getId() + " Has Scholarship: " + this.isHasScholarship() + "; " + this.getRate() + "% Tuition Fee per credit: " + (6000 - (6000 * this.getRate() / 100)) + " tk\n" ;
    }
}
