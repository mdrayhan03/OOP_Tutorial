package mainpkg.demo;

public class DummyClassOne {
    private String name ;
    private int id ;
    private float salary ;
    private boolean status ;

    public DummyClassOne(String name, int id, float salary, boolean status) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DummyClassOne{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
