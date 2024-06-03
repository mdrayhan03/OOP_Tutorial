package mainpkg.demo2;

public class Batsman extends Player{

    String pType , SR , f_s , HS ;

    public Batsman(String name, String dob, String doj, int age, String pType, String SR, String f_s, String HS, String pass) {
        super(name, dob, doj, age, pass);
        this.pType = pType;
        this.SR = SR;
        this.f_s = f_s;
        this.HS = HS;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getSR() {
        return SR;
    }

    public void setSR(String SR) {
        this.SR = SR;
    }

    public String getF_s() {
        return f_s;
    }

    public void setF_s(String f_s) {
        this.f_s = f_s;
    }

    public String getHS() {
        return HS;
    }

    public void setHS(String HS) {
        this.HS = HS;
    }

    @Override
    public String toString() {
        return
                "Name = " + name + '\n' +
                "DOB = " + dob + '\n' +
                "DOJ = " + doj + '\n' +
                "Age = " + age + '\n' +
                "Player Type = " + pType + '\n' +
                "SR = " + SR + '\n' +
                "4s/6s = " + f_s + '\n' +
                "HS = " + HS ;
    }
}
