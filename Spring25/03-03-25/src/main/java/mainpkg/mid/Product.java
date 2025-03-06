package mainpkg.mid;

import java.time.LocalDate;

public class Product {
    String name, id, material ;
    int quantity ;
    LocalDate deliveryDate ;

    public Product(String name, String id, String material, int quantity, LocalDate deliveryDate) {
        this.name = name;
        this.id = id;
        this.material = material;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
