package mainpkg.demo;

public class Parent {
    private String name ;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void method() {
        System.out.println("Parent");
    }
}
