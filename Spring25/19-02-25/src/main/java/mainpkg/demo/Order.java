package mainpkg.demo;

public class Order {
    int quantity ;
    float totalPrice ;
    Item food ;

    public Order(int quantity, float totalPrice, Item food) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Item getFood() {
        return food;
    }

    public void setFood(Item food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order{" +
                "quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", food=" + food +
                '}';
    }
}
