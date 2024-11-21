package mainpkg.demo;

public abstract class Abstract_Class {
    String name, password;

    public Abstract_Class(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void method() {}
    void imple() {
        System.out.println("s");
    }
}
