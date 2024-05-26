/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

/**
 *
 * @author MD. Rayhan Hossain
 */
public class Person {
    String name , sem ;
    int age , id , year ;

    public Person(String name, String sem, int age, int id, int year) {
        this.name = name;
        this.sem = sem;
        this.age = age;
        this.id = id;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getSem() {
        return sem;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", sem=" + sem + ", age=" + age + ", id=" + id + ", year=" + year + '}';
    }


    
    
    
}
