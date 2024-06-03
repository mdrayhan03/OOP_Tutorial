package mainpkg.demo2;

public class Player {
    String name , dob , doj , pass;
    int age ;

    public Player(String name, String dob, String doj, int age , String pass) {
        this.name = name;
        this.dob = dob;
        this.doj = doj;
        this.age = age;
        this.pass = pass ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
