package mainpkg.library.Member;

import mainpkg.library.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Member extends User implements Serializable {
    public Member(int id, String name, String email, String pN, String password, String type, String address, LocalDate dob) {
        super(id, name, email, pN, password, type, address, dob);
    }
}
