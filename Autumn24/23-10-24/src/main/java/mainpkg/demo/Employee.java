package mainpkg.demo;

import java.time.LocalDate;

public class Employee {
    private int id , salary;
    private String name, designation ;
    private LocalDate dob, doj ;

    public Employee(int id, int salary, String name, String designation, LocalDate dob, LocalDate doj) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.designation = designation;
        this.dob = dob;
        this.doj = doj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return  "id=" + id + "\n" +
                ", salary=" + salary + "\n" +
                ", name='" + name + "\n" +
                ", designation='" + designation + "\n" +
                ", dob=" + dob + "\n" +
                ", doj=" + doj + "\n" ;
    }
}
