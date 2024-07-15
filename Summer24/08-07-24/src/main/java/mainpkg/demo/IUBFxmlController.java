package mainpkg.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Objects;

public class IUBFxmlController
{
    @javafx.fxml.FXML
    private Label faeduL;
    @javafx.fxml.FXML
    private PasswordField adpassPF;
    @javafx.fxml.FXML
    private Label cucrdL;
    @javafx.fxml.FXML
    private Label adpretitL;
    @javafx.fxml.FXML
    private TextField adidTF;
    @javafx.fxml.FXML
    private ComboBox<String> adfadCB;
    @javafx.fxml.FXML
    private Button studcaB;
    @javafx.fxml.FXML
    private TextField adfasecTF;
    @javafx.fxml.FXML
    private Label fadL;
    @javafx.fxml.FXML
    private ComboBox<Integer> adfaidCB;
    @javafx.fxml.FXML
    private ComboBox<Integer> fasecCB;
    @javafx.fxml.FXML
    private TextField deginsTF;
    @javafx.fxml.FXML
    private TextField studpNTF;
    @javafx.fxml.FXML
    private ComboBox<Integer> studCB;
    @javafx.fxml.FXML
    private ComboBox<String> adfatCB;
    @javafx.fxml.FXML
    private ComboBox<Integer> adcuidCB;
    @javafx.fxml.FXML
    private Label adfarnL;
    @javafx.fxml.FXML
    private ComboBox<Integer> preidCB;
    @javafx.fxml.FXML
    private Label adfanameL;
    @javafx.fxml.FXML
    private ComboBox<Integer> faidCB;
    @javafx.fxml.FXML
    private TextField adcucreTF;
    @javafx.fxml.FXML
    private TextField degtitTF;
    @javafx.fxml.FXML
    private Label cutitL;
    @javafx.fxml.FXML
    private Label precrL;
    @javafx.fxml.FXML
    private Label pregrdL;
    @javafx.fxml.FXML
    private Label adprecreL;
    @javafx.fxml.FXML
    private Label pretitL;
    @javafx.fxml.FXML
    private Label fapnL;
    @javafx.fxml.FXML
    private TextField studnameTF;
    @javafx.fxml.FXML
    private TextField adcutitTF;
    @javafx.fxml.FXML
    private Label fanameL;
    @javafx.fxml.FXML
    private ComboBox<Integer> adpreidCB;
    @javafx.fxml.FXML
    private Label fatL;
    @javafx.fxml.FXML
    private ComboBox<Integer> cuidCB;
    @javafx.fxml.FXML
    private TextField degcgTF;
    @javafx.fxml.FXML
    private Label farnL;

    ArrayList<STUDENT> studarr = new ArrayList<>() ;
    ArrayList<FACULTY> facarr = new ArrayList<>() ;
    ArrayList<COURSE> coursearr = new ArrayList<>() ;
    ArrayList<STUDENT> cerarr ;
    ArrayList<STUDENT_COURSE> studcuarr ;
    ArrayList<FACULTY_COURSE> fcouarr = new ArrayList<>() ;

    STUDENT userStud ;
    COURSE adcou ;

    @javafx.fxml.FXML
    private TextField degyrTF;


    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<CERTIFICATE> cerarr = new ArrayList<>() ;
        cerarr.add(new CERTIFICATE("SSC" , "Institution1" , 5.00f ,2020)) ;
        cerarr.add(new CERTIFICATE("HSC" , "Institution2" , 5.00f , 2022)) ;
        studarr.add(new STUDENT(1000000 , "Stud1" , "01311111111" , "password" , cerarr )) ;
        studarr.add(new STUDENT(1000000 , "Stud2" , "01311111111" , "password" , cerarr )) ;
        studarr.add(new STUDENT(1000000 , "Stud3" , "01311111111" , "password" , cerarr )) ;

        facarr.add(new FACULTY(1000 , "Faculty1" , "01311111111" , "password" ,5012 , "Education1")) ;
        facarr.add(new FACULTY(1000 , "Faculty2" , "01311111111" , "password" ,5014 , "Education2")) ;
        facarr.add(new FACULTY(1000 , "Faculty3" , "01311111111" , "password" ,6013 , "Education3")) ;

        COURSE cou1 = new COURSE(3 , "Course1");
        coursearr.add(cou1) ;
        COURSE cou2 = new COURSE(1 , "Course2") ;
        coursearr.add(cou2) ;
        cou2.addPre(cou1) ;
        COURSE cou3 = new COURSE(3 , "Course3") ;
        cou3.addPre(cou2) ;
        coursearr.add(cou3) ;

        for (int i = 0 ; i < 3 ; i++) {
            fcouarr.add(new FACULTY_COURSE(facarr.get(i).getId() , coursearr.get(i).getId() , i , "ST" , "1120-1250"));
        }
        System.out.println(fcouarr);

        studCB.getItems().add(0000000) ;
        for (STUDENT s : studarr) {
            studCB.getItems().add(s.getId()) ;
        }

        for (COURSE c : coursearr) {
            cuidCB.getItems().add(c.getId()) ;
            adcuidCB.getItems().add(c.getId());
        }
        for (FACULTY f: facarr) {
            adfaidCB.getItems().add(f.getId());
        }
        adfadCB.getItems().addAll("AR", "ST", "MW");
        adfatCB.getItems().addAll("800:930", "940:1110","1120:1250");

    }

    @javafx.fxml.FXML
    public void doneOA(ActionEvent actionEvent) {
        userStud.setCouArr(studcuarr);
        System.out.println(userStud);
        studcuarr = new ArrayList<>();
    }

    @javafx.fxml.FXML
    public void studcaOA(ActionEvent actionEvent) {
        studnameTF.clear();
        studpNTF.clear();
        degtitTF.clear();
        degyrTF.clear();
        degcgTF.clear();
        deginsTF.clear();

        String name , pN , title , ins;
        int yr ;
        float cgpa ;
        ArrayList<CERTIFICATE> cerarrY = new ArrayList<>() ;
        name = studnameTF.getText() ;
        pN = studpNTF.getText() ;
        title = degtitTF.getText();
        ins = deginsTF.getText() ;
        yr = Integer.parseInt(degyrTF.getText()) ;
        cgpa = Float.parseFloat(degcgTF.getText()) ;

        if (name.length() < 4) {
            Alert alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setTitle("Name Error") ;
            alert.setContentText("Name at least 4 character.") ;
            alert.showAndWait() ;
            return;
        }
        cerarrY.add(new CERTIFICATE(title , ins , cgpa , yr)) ;
        studarr.add(new STUDENT(1000000 , name , pN , "password" , cerarrY)) ;

        for (STUDENT s : studarr) {
            studCB.getItems().add(s.getId()) ;
        }

    }

    @javafx.fxml.FXML
    public void adminLoginOA(ActionEvent actionEvent) {
        int adid = Integer.parseInt(adidTF.getText());
        String pass = adpassPF.getText();
        System.out.println(pass);
        if(adid == 1234 && Objects.equals(pass, "password")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
            alert.setTitle("Login Successfull.");
            alert.setContentText("Admin login successfully.");
            alert.showAndWait();
        }
//        else {
//            Alert alert = new Alert(Alert.AlertType.ERROR) ;
//            alert.setTitle("Login Error.");
//            alert.setContentText("Admin login id or password in invalid.");
//            alert.showAndWait();
//        }
    }

    @javafx.fxml.FXML
    public void peridCBOA(ActionEvent actionEvent) {
        int preid = preidCB.getValue() ;
        for (COURSE pc : coursearr) {
            if (pc.getId() == preid) {
                pretitL.setText(pc.getTitle());
                precrL.setText(Integer.toString(pc.getCredit()));
            }
        }
    }

    @javafx.fxml.FXML
    public void adCCUOA(ActionEvent actionEvent) {
        coursearr.add(new COURSE(Integer.parseInt(adcucreTF.getText()), adcutitTF.getText())) ;
        adcou = new COURSE(Integer.parseInt(adcucreTF.getText()), adcutitTF.getText()) ;
        coursearr.add(adcou);
    }

    @javafx.fxml.FXML
    public void cuidCBOA(ActionEvent actionEvent) {
        faidCB.getItems().removeAll();
        int cuid = cuidCB.getValue() ;
        for (COURSE c : coursearr) {
            if (c.getId() == cuid) {
                cutitL.setText(c.getTitle());
                cucrdL.setText(Integer.toString(c.getCredit()));
                preidCB.getItems().add(c.getId()) ;
                for (FACULTY_COURSE fc : fcouarr) {
                    if(fc.getCourseID() == cuid) {
                        faidCB.getItems().add(fc.getFacultyID()) ;
                    }
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void faidCBOA(ActionEvent actionEvent) {
        int fcid = faidCB.getValue() ;
        for (FACULTY f : facarr) {
            if(f.getId() == fcid) {
                fanameL.setText(f.getName());
                fapnL.setText(f.getpN());
                farnL.setText(Integer.toString(f.getRoom()));
                for (FACULTY_COURSE fc : fcouarr) {
                    if(fc.getFacultyID() == fcid) {
                        fadL.setText(fc.getDay());
                        fatL.setText(fc.getTime());
                        fasecCB.setValue(fc.getSec());
                    }
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void studCBOnAction(ActionEvent actionEvent) {
        studcuarr = new ArrayList<>();
        studnameTF.setEditable(true) ;
        studpNTF.setEditable(true);
        degtitTF.setEditable(true);
        degyrTF.setEditable(true);
        degcgTF.setEditable(true);
        deginsTF.setEditable(true);
        studcaB.setDisable(false);
        int studid = studCB.getValue() ;
        if (studid != 0) {
            for (STUDENT s : studarr) {
                if(s.getId() == studid) {
                    userStud = s ;
                    studnameTF.setText(s.getName());
                    studpNTF.setText(s.getpN());
                    studnameTF.setEditable(false) ;
                    studpNTF.setEditable(false);
                    degtitTF.setEditable(false);
                    degyrTF.setEditable(false);
                    degcgTF.setEditable(false);
                    deginsTF.setEditable(false);
                    studcaB.setDisable(true);
                }
            }
        }

    }

    @javafx.fxml.FXML
    public void adfaidCBOA(ActionEvent actionEvent) {
        int faid = adfaidCB.getValue();
        for (FACULTY f : facarr) {
            if (f.getId() == faid) {
                adfanameL.setText(f.getName());
                adfarnL.setText(Integer.toString(f.getRoom()));
            }
        }
    }

    @javafx.fxml.FXML
    public void adcuidCBOA(ActionEvent actionEvent) {
        int adcuid = adcuidCB.getValue();
        System.out.println(adcuid);
        for (COURSE c : coursearr) {
            if (c.getId() == adcuid) {
                adcou = c ;
                adcucreTF.setText(Integer.toString(c.getCredit()));
                adcucreTF.setEditable(false);
                adcutitTF.setText(c.getTitle());
                adcutitTF.setEditable(false);
                if (c.getPre() != null){
                adpreidCB.getItems().add(c.getPre().getId());
                adpretitL.setText(c.getPre().getTitle());
                adprecreL.setText(Integer.toString(c.getPre().getCredit()));
                }
                return;
            }
        }
        for (COURSE c: coursearr){
            adpreidCB.getItems().add(c.getId());
        }
    }

    @javafx.fxml.FXML
    public void couacOA(ActionEvent actionEvent) {
        int couid = cuidCB.getValue();
        int fcid = faidCB.getValue();
        int sec = fasecCB.getValue();
        for (FACULTY_COURSE c : fcouarr) {
            if (c.getCourseID() == couid && c.getFacultyID() == fcid && c.getSec() == sec) {
                studcuarr.add(new STUDENT_COURSE(userStud.getId() , c.getFcID()));
            }
        }
    }

    @javafx.fxml.FXML
    public void adpreidCBOA(ActionEvent actionEvent) {
        int preid = (int) adpreidCB.getValue();
        for (COURSE c : coursearr) {
            if (c.getId() == preid){
                adpretitL.setText(c.getTitle());
                adprecreL.setText(Integer.toString(c.getCredit()));
                adcou.setPre(c);
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void adAFOA(ActionEvent actionEvent) {
        fcouarr.add(new FACULTY_COURSE(adfaidCB.getValue(), adcuidCB.getValue(), Integer.parseInt(adfasecTF.getText()), adfadCB.getValue(), adfatCB.getValue()));
    }
}