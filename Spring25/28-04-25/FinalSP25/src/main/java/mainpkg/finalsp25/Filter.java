package mainpkg.finalsp25;

public class Filter {
    int range ;

    public Filter(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "range=" + range +
                '}';
    }
}
