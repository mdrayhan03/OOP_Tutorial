package mainpkg.demo;

public class Child extends Abstract_Class{
    String salary ;
    public Child(String name, String password, String salary) {
        super(name, password);
        this.salary = salary ;
    }

    @Override
    void method() {
        super.method();
    }

    @Override
    void imple() {
        System.out.println("child");
    }
}
