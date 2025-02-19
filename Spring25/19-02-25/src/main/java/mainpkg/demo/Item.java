package mainpkg.demo;

import java.time.LocalDate;

public class Item {
    String name ;
    int quantity ;
    float price ;
    LocalDate expDate ;

    public Item(String name, int quantity, float price, LocalDate expDate) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expDate=" + expDate +
                '}';
    }
}
