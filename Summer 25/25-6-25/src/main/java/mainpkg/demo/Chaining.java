package mainpkg.demo;

public class Chaining {
    private int i, j, k ;

    public Chaining(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "Chaining{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                '}';
    }

    public Chaining m1() {
        this.setI(this.getI() + 5) ;
        return this ;
    }

    public Chaining m2() {
        this.setI(this.getI() + this.getJ()) ;
        return this ;
    }

    public void m3() {
        System.out.println(this.getI() - this.getK());
    }

    public void calculate(int x){
        System.out.print(Math.pow((x*(x+3)), 2)) ;
    }

    public void calculate1() {
        this.setJ(this.getI() + 3);
    }

    public void calculate2() {
        this.setI(this.getI() * this.getJ());
    }

    public void calculate3() {
        System.out.println(Math.pow(this.getI(), 2));
    }
}
