package mainpkg.shopmanagement.Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.shopmanagement.Admin.Admin;
import mainpkg.shopmanagement.ModelClasses.History;
import mainpkg.shopmanagement.User;

public class Customer extends User {
    private String emergencyContact ;

    public Customer(String id, String name, String email, String pN, String password, String emergencyContact) {
        super(id, name, email, pN, password);
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Override
    public Customer login(String id, String password) {
        User user = super.login(id, password);
        if (user != null) {
            return this;
        }
        else {
            return null ;
        }
    }

    public boolean buyProduct() {
        return true ;
    }

    public boolean createInvoice() {
        return true ;
    }

    public ObservableList<History> seeHistory() {
        ObservableList<History> historyObservableList = FXCollections.observableArrayList() ;
        return historyObservableList ;
    }
}
