package mainpkg.demo;

import java.util.ArrayList;

public class Trainee {
    private int id ;
    private ArrayList<String> trainingTitles ;

    public Trainee(int id, ArrayList<String> trainingTitles) {
        this.id = id;
        this.trainingTitles = trainingTitles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getTrainingTitles() {
        return trainingTitles;
    }

    public void setTrainingTitles(ArrayList<String> trainingTitles) {
        this.trainingTitles = trainingTitles;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", trainingTitles=" + trainingTitles +
                '}';
    }

    public int getTrainingTitelsCount() {
        return trainingTitles.size() ;
    }
}
