package mainpkg.demo;

import javafx.collections.ObservableArray;

import java.util.ArrayList;

public class DummyTable  {
    int id , cnt;
    String uniName , status ;
    ArrayList<String> trainingTitles ;

    public DummyTable(int id, int cnt, String uniName, String status, ArrayList<String> trainingTitles) {
        this.id = id;
        this.cnt = cnt;
        this.uniName = uniName;
        this.status = status;
        this.trainingTitles = trainingTitles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getTrainingTitles() {
        return trainingTitles;
    }

    public void setTrainingTitles(ArrayList<String> trainingTitles) {
        this.trainingTitles = trainingTitles;
    }

    @Override
    public String toString() {
        return "DummyTable{" +
                "id=" + id +
                ", cnt=" + cnt +
                ", uniName='" + uniName + '\'' +
                ", status='" + status + '\'' +
                ", trainingTitles=" + trainingTitles +
                '}';
    }
}
