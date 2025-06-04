package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatternFxmlController
{
    @javafx.fxml.FXML
    private TextArea patternShowTA;
    @javafx.fxml.FXML
    private TextField rowTF;
    @javafx.fxml.FXML
    private Label patterShowL;
    @javafx.fxml.FXML
    private TextField typeTF;

    @javafx.fxml.FXML
    public void initialize() {
        System.out.println(5);
    }

    @javafx.fxml.FXML
    public void makePatternOA(ActionEvent actionEvent) {
        boolean flag = true ;
//        String rowNumber = rowTF.getText() ;
        if (rowTF.getText().isEmpty()) {
            flag = false ;
        }

        if (typeTF.getText().isEmpty()) {
            flag = false ;
        }

        if (flag) {

            int row = Integer.parseInt(rowTF.getText());

            if (row <= 0) {
                flag = false;
            }
//        Integer.toString() ;
            if (flag) {
                String type = typeTF.getText();

                String pattern = "";
                for (int i = 1; i < row + 1; i++) {
                    for (int j = 0; j < i; j++) {
                        pattern += type;
                    }
                    pattern += "\n";
                }

                patterShowL.setText(pattern);
                patternShowTA.setText(pattern);
            }
        }
        if (!flag) {
            patterShowL.setText("Wrong row number or pattern type.");
        }
    }
}
//*
//**
//***
//****
//*****