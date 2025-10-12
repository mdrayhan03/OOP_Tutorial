package mainpkg.demo;

public class Human {
    String hand_size, leg_size, eye_color, name ;

    public Human(String hand_size, String leg_size, String eye_color) {
        this.hand_size = hand_size;
        this.leg_size = leg_size;
        this.eye_color = eye_color;
    }

    public String getHand_size() {
        return hand_size;
    }

    public void setHand_size(String hand_size) {
        this.hand_size = hand_size;
    }

    public String getLeg_size() {
        return leg_size;
    }

    public void setLeg_size(String leg_size) {
        this.leg_size = leg_size;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "hand_size='" + hand_size + '\'' +
                ", leg_size='" + leg_size + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void walk(String direction) {
        System.out.println("I am walking " + direction);
    }

    public void calculate(int a, int b) {
        System.out.println(a + b);
    }
}
