package mainpkg.shopmanagement.Customer;

import javafx.scene.control.* ;
import javafx.event.* ;

public class InvoiceFxmlController
{
    @javafx.fxml.FXML
    private Label dateL;
    @javafx.fxml.FXML
    private Label hDateL;
    @javafx.fxml.FXML
    private TextArea demoInvoiceTA;
    @javafx.fxml.FXML
    private TableColumn historyIDTC;
    @javafx.fxml.FXML
    private ComboBox historyIDCB;
    @javafx.fxml.FXML
    private TableColumn dateTC;
    @javafx.fxml.FXML
    private TextArea productsTA;
    @javafx.fxml.FXML
    private Label tCostL;
    @javafx.fxml.FXML
    private TableColumn productsTC;
    @javafx.fxml.FXML
    private TableView historyTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void makePDFOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createInvoiceOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void historyIDCBOA(ActionEvent actionEvent) {
    }
}