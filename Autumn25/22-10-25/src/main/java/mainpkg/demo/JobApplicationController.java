package mainpkg.demo;

import javafx.scene.control.* ;
import javafx.event.* ;

import java.util.ArrayList;
import java.util.Random;

public class JobApplicationController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField pNTF;
    @javafx.fxml.FXML
    private TextField expTF;
    @javafx.fxml.FXML
    private RadioButton femaleRB;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private Label idL;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private ToggleGroup tg;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private Label skillsL;
    @javafx.fxml.FXML
    private CheckBox fresherChB;
    @javafx.fxml.FXML
    private Label outputL;
    @javafx.fxml.FXML
    private TextField githubTF;
    @javafx.fxml.FXML
    private TextField skillTF;

    ArrayList<String> skillsList = new ArrayList<>() ;
    ArrayList<Applicant> applicantArrayList = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        idL.setText(Integer.toString(this.generateID()));
    }

    @javafx.fxml.FXML
    public void submitOA(ActionEvent actionEvent) {
        int id = Integer.parseInt(idL.getText()) ;
        String name = nameTF.getText() ;
        String email = emailTF.getText() ;
        String pN = pNTF.getText() ;
        String github = githubTF.getText() ;
        int exp = Integer.parseInt(expTF.getText()) ;
        String description = descriptionTA.getText() ;

        boolean flag = true ;
        String error = "" ;

        String gender = "" ;

        if (maleRB.isSelected()) {
            gender = "male" ;
        } else if (femaleRB.isSelected()) {
            gender = "female" ;
        }

        boolean isFresh ;
        if (fresherChB.isSelected()) {
            isFresh = true ;
        }
        else {
            isFresh = false ;
        }

        if (name.isBlank()) {
            error += "Name can't be blank.\n" ;
            flag = false ;
        }

        if (isFresh) {
            exp = 0 ;
        }

        if (description.length() > 100) {
            error += "Description can't be more that 100 characters.\n" ;
            flag = false ;
        }

        if (flag) {
            Applicant applicant = new Applicant(id, exp, name, email, pN, github, gender, description, isFresh, skillsList) ;
            applicantArrayList.add(applicant) ;
            outputL.setText("Submission Successful.");

            skillsList.clear() ;
            idL.setText(Integer.toString(this.generateID()));
            nameTF.clear() ;
            emailTF.clear();
            pNTF.clear();
            githubTF.clear();
            maleRB.setSelected(false);
            femaleRB.setSelected(false);
            fresherChB.setSelected(false);
            expTF.clear();
            skillTF.clear();
            skillsL.setText("");
            descriptionTA.clear();
        }

        else {
            outputL.setText("Invalid Data.\n" + error);
        }

    }

    @javafx.fxml.FXML
    public void addSkillOA(ActionEvent actionEvent) {
        String skill = skillTF.getText() ;
        skillsList.add(skill) ;

        String s = "" ;
        for (String skl: skillsList) {
            s += skl + ", " ;
        }

        skillsL.setText(s);

    }

    private int generateID() {
        int id = 0 ;

        Random random = new Random() ;

        id += random.nextInt(10000, 99999) ;

        return id ;
    }
}