package mainpkg.demo;

public class FACULTY extends USER {
    private int room ;
    private String edu ;


    public FACULTY(int id, String name, String pN, String pass , int room , String edu) {
        super(id, name, pN, pass);
        this.room = room ;
        this.edu = edu ;
    }

    public boolean changeRoom(int oldRoom , int newRoom) {
        boolean b = false ;

        if (oldRoom == this.getRoom()) {
            this.setRoom(newRoom) ;
            b = true ;
        }
        return b ;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    @Override
    public String toString() {
        return "FACULTY{" +
                "room=" + room +
                ", edu='" + edu + '\'' +
                '}';
    }
}
