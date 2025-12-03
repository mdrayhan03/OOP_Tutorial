package mainpkg.shopmanagement.ModelClasses;

public class DummyProduct {
    private String id, name, category, unit ;
    private float price ;
    private int quantity ;
    private float cost ;

    public DummyProduct(String id, String name, String category, String unit, float price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.cost = this.price * this.quantity ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "DummyProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
