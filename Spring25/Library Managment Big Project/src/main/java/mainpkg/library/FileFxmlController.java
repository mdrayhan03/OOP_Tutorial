package mainpkg.library;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileFxmlController
{
    @javafx.fxml.FXML
    private TextArea dataTA;

    File f = null ;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void selectOA(ActionEvent actionEvent) {
        FileChooser fc = null ;
        Scanner sc = null ;

        try {
            fc = new FileChooser() ;
            f = fc.showOpenDialog(null) ;
            sc = new Scanner(f) ;
            dataTA.clear();
            while (sc.hasNextLine()) {
                dataTA.appendText(sc.nextLine() + '\n');
            }


        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void saveOA(ActionEvent actionEvent) throws IOException {
        FileWriter fw = new FileWriter(f) ;
        fw.write(dataTA.getText());
        fw.close();
    }

    @javafx.fxml.FXML
    public void saveAsOA(ActionEvent actionEvent) {
        FileChooser fc = null ;
        FileWriter fw = null ;

        try {
            fc = new FileChooser() ;
            f = fc.showSaveDialog(null) ;
            fw = new FileWriter(f) ;
            fw.write(dataTA.getText());
            fw.close();
        } catch (Exception e) {

        }
    }
}