package mainpkg.demo;

public class ChildClass extends Parent{
    public ChildClass(String name) {
        super(name);
    }

    public void  new_method() {
        System.out.println("Parent");
    }

    public void load(int a) {
        System.out.println(a);
    }

    public void load(float a) {
        System.out.println(a);
    }
}
