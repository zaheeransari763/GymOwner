package com.example.gymowner;

public class Clients {


    public String DateofJoining,EMail,Fullname,Contact;
      public String  Weight;

    public Clients() {
    }

    public Clients(String weight, String dateofjoining, String email, String fullname, String contact) {
        this.Weight = weight;
        this.DateofJoining = dateofjoining;
        this.EMail = email;
        this.Fullname = fullname;
        this.Contact = contact;

    }

    public void setDateofJoiningg(String dateofJoining) {
        DateofJoining = dateofJoining;
    }

    public void setEMaill(String EMail) {
        this.EMail = EMail;
    }

    public void setFullnamee(String fullname) {
        Fullname = fullname;
    }

    public void setContactt(String contact) {
        Contact = contact;
    }

    public void setWeightt(String weight) {
        Weight = weight;
    }

    public String getDateofJoiningg() {
        return DateofJoining;
    }

    public String getEMaill() {
        return EMail;
    }

    public String getFullnamee() {
        return Fullname;
    }

    public String getContactt() {
        return Contact;
    }

    public String getWeightt() {
        return Weight;
    }
}
