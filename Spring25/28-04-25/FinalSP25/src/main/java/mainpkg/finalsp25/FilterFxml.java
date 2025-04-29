package mainpkg.finalsp25;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class FilterFxml
{
    @javafx.fxml.FXML
    private TextArea showTA;
    @javafx.fxml.FXML
    private TextField filterTF;
    ArrayList<Filter> filterArrayList = new ArrayList<>() ;
    @javafx.fxml.FXML
    public void initialize() {
        filterArrayList.add(new Filter(5)) ;
        filterArrayList.add(new Filter(6)) ;
        filterArrayList.add(new Filter(7)) ;
        filterArrayList.add(new Filter(8)) ;
        filterArrayList.add(new Filter(9)) ;
    }

    @javafx.fxml.FXML
    public void filterOA(ActionEvent actionEvent) {
//        tableview.getItems.clear() ;
//        tableview.getItems.add() ;
//        tableview.getItems.addAll(ArrayList<>()) ;
//        tableview.setItems(ObservableList<>()) ;
        showTA.clear();
        int range = Integer.parseInt(filterTF.getText()) ;

        for (Filter filter: filterArrayList) {
            if(filter.getRange() >= range) {
                showTA.appendText(filter.toString() + "\n");
            }
        }
    }
}