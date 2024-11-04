package mainpkg.demo;

public class DummyTableClass {
    private String name, familyName ;
    private int id ;
    private float age, salary ;
    private boolean maritalStatus ;

    public DummyTableClass(String name, String familyName, int id, float age, float salary, boolean maritalStatus) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "DummyTableClass{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", maritalStatus=" + maritalStatus +
                '}';
    }
}
