package mainpkg.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mainpkg.library.Librian.Librian;
import mainpkg.library.Member.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class CreateAccountFxmlController
{
    @javafx.fxml.FXML
    private TextArea addressTA;
    @javafx.fxml.FXML
    private TextArea showTA;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeCB;
    @javafx.fxml.FXML
    private PasswordField passwordPF;
    @javafx.fxml.FXML
    private DatePicker dobDP;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeCB.getItems().addAll("Librian", "Member", "SoD") ;
    }

    @javafx.fxml.FXML
    public void loginButtonOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginFxml.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    @javafx.fxml.FXML
    public void createAccountButtonOA(ActionEvent actionEvent) {
        String name, email, pN, address, password, userType ;
        LocalDate dob ;
        int id = 0 ;
        Random random = new Random() ;

        name = nameTF.getText() ;
        email = emailTF.getText() ;
        pN = pNTF.getText() ;
        address = addressTA.getText() ;
        password = passwordPF.getText() ;
        userType = userTypeCB.getValue() ;
        dob = dobDP.getValue() ;

        if (userType == "Librian") {
            id = random.nextInt(10000, 99999) ;
            Librian librian = new Librian(id ,name, email, pN, password, userType, address, dob) ;
            showTA.setText(librian.toString());
            this.writeLibrian(librian);
            this.writeUser(librian);
        }
//        else if (userType == "SoD") {
//            id = random.nextInt(100000, 999999) ;
//            SoD librian = new Librian(id ,name, email, pN, password, userType, address, dob) ;
//        }
        else if (userType == "Member") {
            id = random.nextInt(1000000, 9999999) ;
            Member member = new Member(id ,name, email, pN, password, userType, address, dob) ;
            showTA.setText(member.toString());
            this.writeMember(member);
            this.writeUser(member);
        }
        nameTF.clear();
        emailTF.clear();
        pNTF.clear();
        addressTA.clear();
        passwordPF.clear();
    }

    public void writeLibrian(Librian librian) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("LibrianData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
//                oos = new AppendableObjectOutputStream(fos);
                oos = new ObjectOutputStream(fos) ;
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(librian);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    public void writeMember(Member member) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("MemberData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
//                oos = new ObjectOutputStream(fos) ;
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(member);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    public void writeUser(User user) {
        File f = null ;
        FileWriter fw = null ;

        try {
            f = new File("UserData.txt") ;
            if (f.exists()) {
                fw = new FileWriter(f, true) ;
            }
            else {
                fw = new FileWriter(f) ;
            }

            fw.write(user.getId() + "," + user.getPassword() + "," + user.getType() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}