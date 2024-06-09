package mainpkg.demo;

import java.util.Random;

public class Children extends Member{
    int id ;
    public Children(String name, String type, String phoneNo, String doj) {
        super(name, type, phoneNo, doj);
        this.id = this.generateID() ;
    }

    public int generateID() {
        int id ;

        Random r = new Random() ;
        id = 2200000 + r.nextInt(8999999) ;

        return id ;
    }
}
