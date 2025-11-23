package mainpkg.shopmanagement.ModelClasses;

import javafx.collections.ObservableList;

import java.time.LocalDate;

public class History {
    private String historyID, customerID ;
    private ObservableList<Product> products ;
    private LocalDate date ;

    public History(String historyID, String customerID, ObservableList<Product> products, LocalDate date) {
        this.historyID = historyID;
        this.customerID = customerID;
        this.products = products;
        this.date = date;
    }

    public String getHistoryID() {
        return historyID;
    }

    public void setHistoryID(String historyID) {
        this.historyID = historyID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void setProducts(ObservableList<Product> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyID='" + historyID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", products=" + products +
                ", date=" + date +
                '}';
    }
}
