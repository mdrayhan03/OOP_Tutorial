package mainpkg.library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.library.Librian.DashboardFxmlController;
import mainpkg.library.Librian.Librian;
import mainpkg.library.Member.Member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;


public class LoginFxmlController
{
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private TextField idTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountButtonOA(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAccountFxml.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//
//        Stage stage = new Stage() ;
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAccountFxml.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Create Account");
        stage.show();
    }

    @javafx.fxml.FXML
    public void loginButtonOA(ActionEvent actionEvent) throws IOException {
        int id = Integer.parseInt(idTF.getText()) ;
        String password = passwordPF.getText() ;

        if (Integer.toString(id).length() == 5) {
            ObservableList<Librian> librianObservableList = this.readLibrian() ;
            for(Librian librian : librianObservableList) {
                if (librian.getId() == id && Objects.equals(librian.getPassword(), password)) {
                    Parent root = null ;
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Librian/DashboardFxml.fxml"));
                    root = fxmlLoader.load();
            //        DashboardFxmlController dc = fxmlLoader.getController() ;
            //        dc.setter("1234", "asdf");
                    Scene scene = new Scene(root) ;
                    Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Librian Dashboard");
                    stage.show();
                    break;
                }
            }
        }
        else if (Integer.toString(id).length() == 7) {
            ObservableList<Member> memberObservableList = this.readMember() ;
            for(Member member : memberObservableList) {
                if (member.getId() == id && Objects.equals(member.getPassword(), password)) {
                    Parent root = null ;
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Member/DashboardFxml.fxml"));
                    root = fxmlLoader.load();
                    //        DashboardFxmlController dc = fxmlLoader.getController() ;
                    //        dc.setter("1234", "asdf");
                    Scene scene = new Scene(root) ;
                    Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Member Dashboard");
                    stage.show();
                    break;
                }
            }
        }
        else {
            System.out.println("Login Error");
        }


//        Parent root = null ;
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Member/DashboardFxml.fxml"));
//        root = fxmlLoader.load();
////        DashboardFxmlController dc = fxmlLoader.getController() ;
////        dc.setter("1234", "asdf");
//        Scene scene = new Scene(root) ;
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.setTitle("Librian Dashboard");
//        stage.show();
    }

    public ObservableList<Librian> readLibrian() {
        ObservableList<Librian> librianObservableList = FXCollections.observableArrayList() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("LibrianData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Librian librian;
            try{
                while(true){
                    librian = (Librian) ois.readObject();
                    librianObservableList.add(librian) ;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("External Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return librianObservableList ;
    }
    public ObservableList<Member> readMember() {
        ObservableList<Member> memberObservableList = FXCollections.observableArrayList() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("MemberData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Member member;
            try{
                while(true){
                    member = (Member) ois.readObject();
                    memberObservableList.add(member) ;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return memberObservableList ;
    }
}