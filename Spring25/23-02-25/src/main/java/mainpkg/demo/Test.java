package mainpkg.demo;

public class Test {
    int i ;

    public Test(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Test{" +
                "i=" + i +
                '}';
    }

    public Test addFive() {
        this.i += 5 ;
        return  this ;
    }

    public Test addTen() {
        this.i += 10 ;
        return  this ;
    }

    public void subTwo() {
        this.i -= 2 ;
    }

    public void function(int x, int y, int z) {
        // (y * (x * 2 + 4)) * z ;
        this.i = (y * (x * 2 + 4)) * z;
    }

    public Test fun1(int x) {
        this.i = x * 2 + 4 ;
        return this ;
    }

    public Test fun2(int y) {
        this.i = y * this.i ;
        return this ;
    }

    public  Test fun3(int z) {
        this.i = this.i * z ;
        return this ;
    }
}
