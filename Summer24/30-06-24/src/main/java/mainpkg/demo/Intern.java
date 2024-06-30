package mainpkg.demo;

public class Intern {
    private int id ;
    private String interName , uniName , status ;

    public Intern(int id, String interName, String uniName, String status) {
        this.id = id;
        this.interName = interName;
        this.uniName = uniName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterName() {
        return interName;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "id=" + id +
                ", interName='" + interName + '\'' +
                ", uniName='" + uniName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
