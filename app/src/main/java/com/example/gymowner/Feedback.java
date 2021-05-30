package com.example.gymowner;

public class Feedback {
   public String Feedback, Fullname, Profile,UID;

    public Feedback() {
    }

    public Feedback(String feedback, String fullname, String profile,String uid) {
        this.Feedback = feedback;
        this.Fullname = fullname;
        this.Profile = profile;
        this.UID=uid;
    }

    public String getFeedbackk() {
        return Feedback;
    }

    public void setFeedbackk(String feedback) {
        Feedback = feedback;
    }

    public String getFullnamee() {
        return Fullname;
    }

    public void setFullnamee(String fullname) {
        Fullname = fullname;
    }

    public String getProfilee() {
        return Profile;
    }

    public void setProfilee(String profile) {
        Profile = profile;
    }

    public String getUIDD() {
        return UID; }

    public void setUIDD(String UID) {
        this.UID = UID;
    }
}

