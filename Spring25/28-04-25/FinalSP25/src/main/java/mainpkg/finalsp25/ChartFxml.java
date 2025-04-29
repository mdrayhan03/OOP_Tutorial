package mainpkg.finalsp25;

import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class ChartFxml
{
    @javafx.fxml.FXML
    private BarChart barChart;
    @javafx.fxml.FXML
    private PieChart pieChart;
    ArrayList<Filter> filterArrayList = new ArrayList<>() ;
    @javafx.fxml.FXML
    public void initialize() {
        filterArrayList.add(new Filter(5)) ;
        filterArrayList.add(new Filter(5)) ;
        filterArrayList.add(new Filter(7)) ;
        filterArrayList.add(new Filter(7)) ;
        filterArrayList.add(new Filter(7)) ;
        filterArrayList.add(new Filter(9)) ;
        filterArrayList.add(new Filter(9)) ;
        filterArrayList.add(new Filter(9)) ;
    }

    @javafx.fxml.FXML
    public void barChartOA(ActionEvent actionEvent) {
        List<XYChart.Data> data = new ArrayList<>();
        data.add(new XYChart.Data("A", 3));
        data.add(new XYChart.Data("B", 4));
        data.add(new XYChart.Data("C", 8));
        data.add(new XYChart.Data("D", 4));
        data.add(new XYChart.Data("F", 1));

        XYChart.Series series1 = new XYChart.Series();
        series1.getData().addAll(data);

        List<XYChart.Data> data2 = new ArrayList<>();
        data2.add(new XYChart.Data("A", 5));
        data2.add(new XYChart.Data("B", 8));
        data2.add(new XYChart.Data("C", 2));
        data2.add(new XYChart.Data("D", 7));
        data2.add(new XYChart.Data("F", 9));
        XYChart.Series series2 = new XYChart.Series();
        series2.getData().addAll(data2);

        barChart.getData().add(series1);
        barChart.getData().add(series2);
    }

    @javafx.fxml.FXML
    public void pieChartOA(ActionEvent actionEvent) {
        ArrayList<PieChart.Data> data = new ArrayList<>();
        int five = 0, seven = 0, nine = 0 ;
        for (Filter filter: filterArrayList) {
            if(filter.getRange() == 5) {
                five ++ ;
            }
            else if(filter.getRange() == 7) {
                seven ++ ;
            }
            else if(filter.getRange() == 9) {
                nine ++ ;
            }
        }
        data.add(new PieChart.Data("Five", five));
        data.add(new PieChart.Data("Seven", seven));
        data.add(new PieChart.Data("Nine", nine));

        pieChart.getData().addAll(data);
    }
}