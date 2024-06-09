package mainpkg.demo;

import java.util.Random;

public class Adult extends Member{
    int id ;
    public Adult(String name, String type, String phoneNo, String doj) {
        super(name, type, phoneNo, doj);
        this.id = this.generateID() ;
    }

    public int generateID() {
        int id ;

        Random r = new Random() ;
        id = 5500000 + r.nextInt(8999999) ;

        return id ;
    }
}
