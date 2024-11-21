package mainpkg.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class SkillFxml
{
    @javafx.fxml.FXML
    private Label skillL;
    @javafx.fxml.FXML
    private Label nameL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showSkillBtnOA(ActionEvent actionEvent) {
//        CR7 cr = new CR7() ;
//        Messi messi = new Messi() ;
//        Neimar neimar = new Neimar() ;
//
//        cr.show_skill() ;
//
//        Child c = new Child("s", "p", "10") ;
//        c.method();
//        c.imple();

        Parent p = new Parent("name") ;
        ChildClass childClass = new ChildClass("child") ;

        p.method();
        childClass.method();

        childClass.load(5);
        childClass.load(5.5f);
    }


}