package mainpkg.demo;

public class DummyClassTwo {
    private String familyName ;
    private int familyMember ;
    private float age ;
    private boolean maritalStatus ;

    public DummyClassTwo(String familyName, int familyMember, float age, boolean maritalStatus) {
        this.familyName = familyName;
        this.familyMember = familyMember;
        this.age = age;
        this.maritalStatus = maritalStatus;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(int familyMember) {
        this.familyMember = familyMember;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "DummyClassTwo{" +
                "familyName='" + familyName + '\'' +
                ", familyMember=" + familyMember +
                ", age=" + age +
                ", maritalStatus=" + maritalStatus +
                '}';
    }
}
