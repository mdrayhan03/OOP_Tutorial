package mainpkg.demo;

public class Demo {
    private String field1 ;
    private int field2 ;

    public Demo(String field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                '}';
    }

    public void method() {
        System.out.println("Child class");
    }

    public void addition(int i, int j) {
        System.out.println(i + j);
    }

    public void addition(float i, float j) {
        System.out.println(i + j);
    }

    public void addition(int i, int j, int k) {
        System.out.println(i + j + k);
    }

}
