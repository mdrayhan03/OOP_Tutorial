package mainpkg.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Objects;

public class PracticeController
{
    @FXML
    private Label label;
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    @FXML
    private ComboBox<Integer> combobox;
    @FXML
    private CheckBox checkBox;
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private TableColumn<PracticeClass, Integer> tableColumn1;
    @FXML
    private TableView<PracticeClass> tableView;
    @FXML
    private TableColumn<PracticeClass, Float> tablecolumn2;
    @FXML
    private TableView<DummyTableClass> dummytableview;
    @FXML
    private TableColumn<DummyTableClass, String> dummytablecolumn3;
    @FXML
    private TableColumn<DummyTableClass, String> dummytablecolumn2;
    @FXML
    private TableColumn<DummyTableClass, Integer> dummytablecolumn1;
    @FXML
    private TableColumn<DummyTableClass, Boolean> dummytablecolumn6;
    @FXML
    private TableColumn<DummyTableClass, Float> dummytablecolumn5;
    @FXML
    private TableColumn<DummyTableClass, Float> dummytablecolumn4;

    @FXML
    ToggleGroup tg = new ToggleGroup() ;

    ObservableList<Integer> integerObservableList = FXCollections.observableArrayList() ;
    ObservableList<PracticeClass> practiceClassObservableList = FXCollections.observableArrayList() ;
    @FXML
    private Button button;


    @FXML
    public void initialize() {
//        label.setText("new label") ;
//
//        String text = textField.getText() ;
//        int i = Integer.parseInt(textField.getText()) ;
//        float f = Float.parseFloat(textField.getText()) ;
//        textField.setText("string") ;
//        textField.clear() ;
//
//        textArea.getText() ;
//        textArea.setText("Text area");
//        textArea.clear();
//
//        int i1 = 23 ;
//        String s = Integer.toString(i1) ;
//
//        integerObservableList.addAll(1, 2, 3, 4, 5) ;
//        integerObservableList.remove(3) ;
//        integerObservableList.clear();
//
//        combobox.getItems().add(1) ;
//        combobox.getItems().addAll(2,3,4) ;
//        combobox.setItems(integerObservableList);
//        combobox.getValue() ;
//        combobox.setValue(10);
//
//        if (checkBox.isSelected()) {
//            System.out.println("check box is selected");
//        }
//        else if (!checkBox.isSelected()) {
//            System.out.println("check box is not selected");
//        }
//
////        radioButton1.setToggleGroup(tg);
////        radioButton2.setToggleGroup(tg);
//
//        if (radioButton1.isSelected()) {
//            System.out.println("Radio button1");
//        }
//        else if (radioButton2.isSelected()) {
//            System.out.println("Radio button2");
//        }
//
//        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("integer"));
//        tablecolumn2.setCellValueFactory(new PropertyValueFactory<>("flt"));
//        PracticeClass one = new PracticeClass("one", 1, 1.0f, true) ;
//        PracticeClass two = new PracticeClass("two", 2, 2.0f, true) ;
//        practiceClassObservableList.addAll(one, two) ;
//        tableView.getItems().add(one) ;
//        tableView.getItems().addAll(one, two) ;
//        tableView.setItems(practiceClassObservableList);
//        tableView.getItems().clear();
//
//        for (PracticeClass practiceClass: practiceClassObservableList) {
//            if (practiceClass.isBool()) {
//                System.out.println(practiceClass);
//            }
//        }
//
//        if (checkBox.isSelected()) {
//            if (textField.getText().isEmpty()) {
//                System.out.println("Not valid");
//            }
//            else if (Integer.parseInt(textField.getText()) == 0) {
//                System.out.println("Not valid");
//            }
//            else {
//                System.out.println("Vaild");
//            }
//        }
//
//        for (PracticeClass practiceClass: practiceClassObservableList) {
//            if (Objects.equals(practiceClass.getString(), "one") && practiceClass.isBool()) {
//                tableView.getItems().add((practiceClass)) ;
//            }
//        }

        int a = 0, b = 0 ;

        int c = a*a + 2*a*b + b*b ;
        int vat = 50000 - (50000 * 15 / 100) ;

        dummytablecolumn1.setCellValueFactory(new PropertyValueFactory<>("id"));
        dummytablecolumn2.setCellValueFactory(new PropertyValueFactory<>("name"));
        dummytablecolumn3.setCellValueFactory(new PropertyValueFactory<>("familyName"));
        dummytablecolumn4.setCellValueFactory(new PropertyValueFactory<>("age"));
        dummytablecolumn5.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dummytablecolumn6.setCellValueFactory(new PropertyValueFactory<>("maritalStatus"));

        DummyClassOne dummyOne = new DummyClassOne("dummyone", 1, 1.0f, true) ;
        DummyClassTwo dummyTwo = new DummyClassTwo("family one", 10, 10, false) ;

        DummyTableClass dummyTable = new DummyTableClass(dummyOne.getName(), dummyTwo.getFamilyName(), dummyOne.getId(), dummyTwo.getAge(), dummyOne.getSalary(), dummyTwo.isMaritalStatus()) ;

        dummytableview.getItems().add(dummyTable) ;

        button.setText("Change button");
    }

    @FXML
    public void comboboxOA(ActionEvent actionEvent) {
        label.setText("combo box on action method.");
    }

    @FXML
    public void buttonOA(ActionEvent actionEvent) {
    }
}