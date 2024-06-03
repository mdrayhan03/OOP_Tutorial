package mainpkg.demo2;

public class Bowler extends Player{
    String pType , eco , wicket , bF ;


    public Bowler(String name, String dob, String doj, int age, String pType, String eco, String wicket, String bF, String pass) {
        super(name, dob, doj, age, pass);
        this.pType = pType;
        this.eco = eco;
        this.wicket = wicket;
        this.bF = bF;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getEco() {
        return eco;
    }

    public void setEco(String eco) {
        this.eco = eco;
    }

    public String getWicket() {
        return wicket;
    }

    public void setWicket(String wicket) {
        this.wicket = wicket;
    }

    public String getbF() {
        return bF;
    }

    public void setbF(String bF) {
        this.bF = bF;
    }

    @Override
    public String toString() {
        return
                "Name = " + name + '\n' +
                "DOB = " + dob + '\n' +
                "DOJ = " + doj + '\n' +
                "Age = " + age + '\n' +
                "Player Type = " + pType + '\n' +
                "ECO = " + eco + '\n' +
                "Wicket = " + wicket + '\n' +
                "Best Figure = " + bF ;
    }
}
