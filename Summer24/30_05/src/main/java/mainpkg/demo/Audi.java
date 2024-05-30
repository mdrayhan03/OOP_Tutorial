package mainpkg.demo;

public class Audi extends Car {
    String wheel , engine , tire ;


    public Audi(String name, int id , String wheel , String engine , String tire) {
        super(name, id);
        this.wheel = wheel ;
        this.engine = engine ;
        this.tire = tire ;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    @Override
    public String toString() {
        return "Audi{" +
                "wheel='" + wheel + '\'' +
                ", engine='" + engine + '\'' +
                ", tire='" + tire + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
