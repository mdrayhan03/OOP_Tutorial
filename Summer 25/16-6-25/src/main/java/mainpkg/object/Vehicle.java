package mainpkg.object;

public class Vehicle {
    int no_of_wheel ;
    String type_of_wheel ;
    String type_of_handle ;
    String color ;
    String vehicle_no ;

    public Vehicle(int no_of_wheel, String type_of_wheel, String type_of_handle, String color) {
        this.no_of_wheel = no_of_wheel;
        this.type_of_wheel = type_of_wheel;
        this.type_of_handle = type_of_handle;
        this.color = color;
    }

    public int getNo_of_wheel() {
        return no_of_wheel;
    }

    public void setNo_of_wheel(int no_of_wheel) {
        this.no_of_wheel = no_of_wheel;
    }

    public String getType_of_wheel() {
        return type_of_wheel;
    }

    public void setType_of_wheel(String type_of_wheel) {
        this.type_of_wheel = type_of_wheel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType_of_handle() {
        return type_of_handle;
    }

    public void setType_of_handle(String type_of_handle) {
        this.type_of_handle = type_of_handle;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    @Override
    public String toString() {
        return "Vehicle{" + '\n' +
                "no_of_wheel=" + no_of_wheel + '\n' +
                ", type_of_wheel='" + type_of_wheel + '\n' +
                ", type_of_handle='" + type_of_handle + '\n' +
                ", color='" + color + '\n' +
                ", vehicle_no='" + vehicle_no + '\n' +
                '}';
    }

    public void forward() {

    }

    public void backward() {

    }

    public void left_turn() {

    }

    public void right_turn() {

    }


//    public Vehicle() {
//    }
}
