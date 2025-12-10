package mainpkg.finalexam_0_0;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.time.LocalDate;

public class Passport implements Serializable {
    private String ppNo, nId, name, zipCode, prevPassportNo, passportType ;
    private LocalDate dateOfIssue, dateOfExpire ;
    private boolean hasPreviousPassport ;

    public Passport(String ppNo, String nId, String name, String zipCode, String prevPassportNo, String passportType, LocalDate dateOfIssue, LocalDate dateOfExpire, boolean hasPreviousPassport) {
        this.ppNo = ppNo;
        this.nId = nId;
        this.name = name;
        this.zipCode = zipCode;
        this.prevPassportNo = prevPassportNo;
        this.passportType = passportType;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpire = dateOfExpire;
        this.hasPreviousPassport = hasPreviousPassport;
    }

    public String getPpNo() {
        return ppNo;
    }

    public void setPpNo(String ppNo) {
        this.ppNo = ppNo;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPrevPassportNo() {
        return prevPassportNo;
    }

    public void setPrevPassportNo(String prevPassportNo) {
        this.prevPassportNo = prevPassportNo;
    }

    public String getPassportType() {
        return passportType;
    }

    public void setPassportType(String passportType) {
        this.passportType = passportType;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(LocalDate dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public boolean isHasPreviousPassport() {
        return hasPreviousPassport;
    }

    public void setHasPreviousPassport(boolean hasPreviousPassport) {
        this.hasPreviousPassport = hasPreviousPassport;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "ppNo='" + ppNo + '\'' +
                ", nId='" + nId + '\'' +
                ", name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", prevPassportNo='" + prevPassportNo + '\'' +
                ", passportType='" + passportType + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfExpire=" + dateOfExpire +
                ", hasPreviousPassport=" + hasPreviousPassport +
                '}';
    }

    public void showPassportAsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle("Passport Info");
        alert.setContentText(this.toString());
        alert.showAndWait();
    }
}
