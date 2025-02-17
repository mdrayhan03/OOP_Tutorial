package mainpkg.demo;

public class Human {
    int no_of_eye, no_of_hand, no_of_leg;
    String eye_color, hand_type, leg_type;

    public Human(int no_of_eye, int no_of_hand, int no_of_leg, String eye_color, String hand_type, String leg_type) {
        this.no_of_eye = no_of_eye;
        this.no_of_hand = no_of_hand;
        this.no_of_leg = no_of_leg;
        this.eye_color = eye_color;
        this.hand_type = hand_type;
        this.leg_type = leg_type;
    }

    public int getNo_of_eye() {
        return no_of_eye;
    }

    public void setNo_of_eye(int no_of_eye) {
        this.no_of_eye = no_of_eye;
    }

    public int getNo_of_hand() {
        return no_of_hand;
    }

    public void setNo_of_hand(int no_of_hand) {
        this.no_of_hand = no_of_hand;
    }

    public int getNo_of_leg() {
        return no_of_leg;
    }

    public void setNo_of_leg(int no_of_leg) {
        this.no_of_leg = no_of_leg;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getHand_type() {
        return hand_type;
    }

    public void setHand_type(String hand_type) {
        this.hand_type = hand_type;
    }

    public String getLeg_type() {
        return leg_type;
    }

    public void setLeg_type(String leg_type) {
        this.leg_type = leg_type;
    }

    @Override
    public String toString() {
        return "Human{" +
                "no_of_eye=" + no_of_eye +
                ", no_of_hand=" + no_of_hand +
                ", no_of_leg=" + no_of_leg +
                ", eye_color='" + eye_color + '\'' +
                ", hand_type='" + hand_type + '\'' +
                ", leg_type='" + leg_type + '\'' +
                '}';
    }

    public void see() {
        System.out.println("Seeing");
    }

    public void move_hand() {
        System.out.println("Hand Moving");
    }
}
