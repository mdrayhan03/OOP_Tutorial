package mainpkg.shopmanagement.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.shopmanagement.ModelClasses.History;
import mainpkg.shopmanagement.User;

public class Admin extends User {
    public Admin(String id, String name, String email, String pN, String password) {
        super(id, name, email, pN, password);
    }

    @Override
    public Admin login(String id, String password) {
        User user = super.login(id, password);
        if (user != null) {
            return this;
        }
        else {
            return null ;
        }
    }

    public boolean addNewProduct() {
        return true ;
    }

    public ObservableList<History> seeHistory() {
        ObservableList<History> historyObservableList = FXCollections.observableArrayList() ;
        return historyObservableList ;
    }
}
