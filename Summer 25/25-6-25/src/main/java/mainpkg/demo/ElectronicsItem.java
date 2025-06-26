package mainpkg.demo;

import java.time.LocalDate;

public class ElectronicsItem {
    private String itemName, company , type;
    private LocalDate issueDate, sellDate;
    private float discount ;
    private int quantity ;

    public ElectronicsItem(String itemName, String company, String type, LocalDate issueDate, int quantity) {
        this.itemName = itemName;
        this.company = company;
        this.type = type;
        this.issueDate = issueDate;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ElectronicsItem{" +
                "itemName='" + itemName + '\'' +
                ", company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", issueDate=" + issueDate +
                ", sellDate=" + sellDate +
                ", discount=" + discount +
                ", quantity=" + quantity +
                '}';
    }
}
