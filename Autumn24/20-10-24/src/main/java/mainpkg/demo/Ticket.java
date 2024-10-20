package mainpkg.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Ticket {
    String ticket_no, name, pN, email, gender, preGender, exp_date, issue_date,vip, status, from, to, seat_no ;

    public Ticket(String name, String pN, String email, String gender, String preGender, String vip, String from, String to, String seat_no) {
        this.name = name;
        this.pN = pN;
        this.email = email;
        this.gender = gender;
        this.preGender = preGender;
        this.vip = vip;
        this.from = from;
        this.to = to;
        this.seat_no = seat_no;
    }

    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpN() {
        return pN;
    }

    public void setpN(String pN) {
        this.pN = pN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPreGender() {
        return preGender;
    }

    public void setPreGender(String preGender) {
        this.preGender = preGender;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_no='" + ticket_no + '\'' +
                ", name='" + name + '\'' +
                ", pN='" + pN + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", preGender='" + preGender + '\'' +
                ", exp_date='" + exp_date + '\'' +
                ", issue_date='" + issue_date + '\'' +
                ", vip='" + vip + '\'' +
                ", status='" + status + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", seat_no='" + seat_no + '\'' +
                '}';
    }

    public void generate_ticket_no() {
        String tn = "" ;

//        tn += this.getName().substring(2, 5) ;
//        tn += this.getpN().substring(4, 7) ;
//        tn += this.getEmail().substring(3,6) ;

        Random r = new Random() ;
        int id = r.nextInt(100000000, 999999999) ;
        tn = Integer.toString(id) ;

        this.setTicket_no(tn); ;
    }

    public void dates() {
        LocalDate date =  LocalDate.now() ;
        this.setIssue_date(date.toString()) ;

        LocalDate exp = LocalDate.now().plusDays(3) ;
        this.setExp_date(exp.toString()) ;

        this.setStatus("Pending") ;
    }
}
