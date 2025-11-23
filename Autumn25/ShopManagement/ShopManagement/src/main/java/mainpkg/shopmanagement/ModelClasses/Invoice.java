package mainpkg.shopmanagement.ModelClasses;

public class Invoice {
    private String invoiceID, historyID ;

    public Invoice(String invoiceID, String historyID) {
        this.invoiceID = invoiceID;
        this.historyID = historyID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getHistoryID() {
        return historyID;
    }

    public void setHistoryID(String historyID) {
        this.historyID = historyID;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID='" + invoiceID + '\'' +
                ", historyID='" + historyID + '\'' +
                '}';
    }
}
