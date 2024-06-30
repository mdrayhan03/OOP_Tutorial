package mainpkg.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Console;
import java.util.ArrayList;
import java.util.Objects;

public class InternshipFxml
{
    @javafx.fxml.FXML
    private TableColumn<DummyTable , ArrayList<String>> trainingTableColumn;
    @javafx.fxml.FXML
    private CheckBox programmingCheckBox;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , Integer> idTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> uniNameComboBox;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> uniNameTableColumn;
    @javafx.fxml.FXML
    private Label uniNameLabel;
    @javafx.fxml.FXML
    private Label showOutputLabel;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , String> paidTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DummyTable , Integer> noOfTrainingTableColumn;
    @javafx.fxml.FXML
    private CheckBox skillCheckBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> idComboBox;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableView<DummyTable> internTableView;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private CheckBox sprinCheckBox;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private CheckBox blockChainCheckBox;

    ArrayList<Intern> internArrayList = new ArrayList<>();
    ArrayList<Trainee> traineeArrayList = new ArrayList<>() ;
    ArrayList<DummyTable> dummyTableArrayList = new ArrayList<>() ;
//    ObservableArray<DummyTable> dummy = FXCollections.observableArrayList();
    ArrayList<String> trainingTitles ;
    @javafx.fxml.FXML
    private ComboBox<String> filterComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        internArrayList.add(new Intern(1234 , "Intern 1" , "NSU" , "Paid"));
        internArrayList.add(new Intern(1235 , "Intern 2" , "NSU" , "Unpaid"));
        internArrayList.add(new Intern(1236 , "Intern 3" , "IUB" , "Paid"));
        internArrayList.add(new Intern(1237 , "Intern 4" , "IUB" , "Unpaid"));
        internArrayList.add(new Intern(1238 , "Intern 5" , "BRAC" , "Paid"));
        internArrayList.add(new Intern(1239 , "Intern 6" , "BRAC" , "Unpaid"));

//        for (Intern i : internArrayList) {
//            idComboBox.getItems().add(i.getId()) ;
//        }
//
        idComboBox.getItems().addAll(1234,1235,1236,1237,1238,1239) ;
        uniNameComboBox.getItems().addAll("NSU" , "IUB" , "BRAC");
        statusComboBox.getItems().addAll("Paid" , "Unpaid") ;
        filterComboBox.getItems().addAll("Paid" , "Unpaid") ;

        idTableColumn.setCellValueFactory(new PropertyValueFactory<DummyTable , Integer>("id"));
        uniNameTableColumn.setCellValueFactory(new PropertyValueFactory<DummyTable , String>("uniName"));
        paidTableColumn.setCellValueFactory(new PropertyValueFactory<DummyTable , String>("status"));
        trainingTableColumn.setCellValueFactory(new PropertyValueFactory<DummyTable , ArrayList<String>>("trainingTitles"));
        noOfTrainingTableColumn.setCellValueFactory(new PropertyValueFactory<DummyTable , Integer>("cnt"));

    }

    @javafx.fxml.FXML
    public void showTrainingInfoButtonOnMouseClick(ActionEvent actionEvent) {
        String filter = filterComboBox.getValue() ;
        if (filter.length() != 0) {
            for (DummyTable dt : dummyTableArrayList) {
                if (Objects.equals(dt.getStatus(), filterComboBox.getValue())) {
                    internTableView.getItems().add(dt);
                }
            }
            traineeArrayList.clear();
            dummyTableArrayList.clear();
        }
    }

    @javafx.fxml.FXML
    public void showTraineeCountButtonOnMouseClick(ActionEvent actionEvent) {
        int cnt = 0 ;
        for (Intern i : internArrayList) {
            if(Objects.equals(uniNameComboBox.getValue(), i.getUniName())) {
                cnt ++ ;
            }
            if (Objects.equals(statusComboBox.getValue(), i.getStatus())) {
                cnt ++ ;
            }

            if (Objects.equals(uniNameComboBox.getValue(), i.getUniName()) && Objects.equals(statusComboBox.getValue(), i.getStatus())) {
                cnt ++ ;
            }
        }
        String str = "No of " + statusComboBox.getValue() + " from " + uniNameComboBox.getValue()
                + " selected for training is : " + cnt ;

        showOutputLabel.setText(str) ;
        uniNameComboBox.setValue("") ;
        statusComboBox.setValue("") ;
    }

    @javafx.fxml.FXML
    public void addANewTraineeButtonOnMouseClick(Event event) {
        trainingTitles = new ArrayList<>() ;
        if (sprinCheckBox.isSelected()) {
            trainingTitles.add("Sprint Boot") ;
        }
        if (skillCheckBox.isSelected()) {
            trainingTitles.add("Communication Skill") ;
        }
        if (blockChainCheckBox.isSelected()) {
            trainingTitles.add("Block Chain") ;
        }
        if (programmingCheckBox.isSelected()) {
            trainingTitles.add("Programming") ;
        }

        Trainee trainee = new Trainee(idComboBox.getValue() , trainingTitles) ;
        traineeArrayList.add(trainee) ;
        for (Intern i : internArrayList) {
            if (i.getId() == idComboBox.getValue()) {
                dummyTableArrayList.add(new DummyTable(i.getId() , trainee.getTrainingTitelsCount() , i.getUniName() , i.getStatus() , trainee.getTrainingTitles())) ;
            }
        }
    }

    @javafx.fxml.FXML
    public void internOnAction(ActionEvent actionEvent) {
        int id = idComboBox.getValue() ;
        for (Intern i : internArrayList) {
            if (i.getId() == id) {
                nameLabel.setText(i.getInterName());
                uniNameLabel.setText(i.getUniName());
                statusLabel.setText(i.getStatus());
                break;
            }
        }
    }
}