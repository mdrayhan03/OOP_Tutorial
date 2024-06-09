package mainpkg.demo;

public class Student {
    String name ;

    public Student() {
        this.name = "Tanvir";
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public Student walk () {
        System.out.println(("Walking"));
        return this ;
    }

    public Student run () {
        System.out.println("Runing");
        return this;
    }

    public Student jump () {
        System.out.println("Jumping");
        return this;
    }

    public int something() {
        System.out.println("INterger");
        return 5 ;
    }

    public int something(int x) {
        System.out.println("INterger");
        return x ;
    }

    public int add (int x , int y) {
        return x + y ;
    }

    public float add (float x , float y) {
        return x + y ;
    }

}
