package mainpkg.demo;

import java.util.ArrayList;

public class Applicant {
    private int id, experience ;
    private String name, email, pN, github, gender, description ;
    private boolean isFreshGraduate ;
    private ArrayList<String> skills ;

    public Applicant(int id, int experience, String name, String email, String pN, String github, String gender, String description, boolean isFreshGraduate, ArrayList<String> skills) {
        this.id = id;
        this.experience = experience;
        this.name = name;
        this.email = email;
        this.pN = pN;
        this.github = github;
        this.gender = gender;
        this.description = description;
        this.isFreshGraduate = isFreshGraduate;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isFreshGraduate() {
        return isFreshGraduate;
    }

    public void setFreshGraduate(boolean freshGraduate) {
        isFreshGraduate = freshGraduate;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", experience=" + experience +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pN='" + pN + '\'' +
                ", github='" + github + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", isFreshGraduate=" + isFreshGraduate +
                ", skills=" + skills +
                '}';
    }
}
