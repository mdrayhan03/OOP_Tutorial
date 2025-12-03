package mainpkg.shopmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import mainpkg.shopmanagement.ModelClasses.Product;

import java.util.Objects;

public class ChartFXMLController
{
    @javafx.fxml.FXML
    private PieChart pieChartPC;
    @javafx.fxml.FXML
    private LineChart lineChartLC;

    ObservableList<Product> productObservableList = FXCollections.observableArrayList() ;

    ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList() ;

    @javafx.fxml.FXML
    public void initialize() {
        productObservableList.add(new Product("111111", "Rice", "Grocery", "kg", 120f, 100)) ;
        productObservableList.add(new Product("222222", "Potato", "Grocery", "kg", 120f, 100)) ;
        productObservableList.add(new Product("333333", "Mango", "Fruit", "kg", 120f, 100)) ;
        productObservableList.add(new Product("444444", "Banana", "Fruit", "kg", 120f, 100)) ;
        productObservableList.add(new Product("555555", "Bread", "Bakery", "kg", 120f, 100)) ;
    }

    @javafx.fxml.FXML
    public void showOA(ActionEvent actionEvent) {
        int grocery = 0 ;
        int fruit = 0 ;
        int bakery = 0 ;

        for (Product product : productObservableList) {
            if (Objects.equals(product.getCategory(), "Grocery")) {
                grocery ++ ;
            }
            else if (Objects.equals(product.getCategory(), "Fruit")) {
                fruit ++ ;
            }
            else if (Objects.equals(product.getCategory(), "Bakery")) {
                bakery ++ ;
            }
        }

        piechartData.add(new PieChart.Data("Grocery", grocery)) ;
        piechartData.add(new PieChart.Data("Fruit", fruit)) ;
        piechartData.add(new PieChart.Data("Bakery", bakery)) ;

        pieChartPC.setData(piechartData);
        pieChartPC.setTitle("Product Pie chart");
        System.out.println("Pie CHart");


    }
}