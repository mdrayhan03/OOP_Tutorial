package mainpkg.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {


        Student s = new Student() ;

        s.walk().run().jump().something() ;
//        System.out.println(stu.getName());
//        System.out.println(s.getName());
        System.out.println(s.add(5 , 10));
        System.out.println(s.add(5.55f , 10.23f));
        Student stu = new Student("Shafiq") ;
        CR cr = new CR() ;
        stu.jump() ;
        cr.jump() ;
    }
}