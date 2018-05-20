package com.sandywinata.isg.model;

public class WelcomeModel {
    public String about;
    public String campuses;
    public String colleges;
    public String demographics;
    public String international;

    public WelcomeModel() {
    }

    public WelcomeModel(String about, String campuses, String colleges, String demographics, String international) {
        this.about = about;
        this.campuses = campuses;
        this.colleges = colleges;
        this.demographics = demographics;
        this.international = international;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCampuses() {
        return campuses;
    }

    public void setCampuses(String campuses) {
        this.campuses = campuses;
    }

    public String getColleges() {
        return colleges;
    }

    public void setColleges(String colleges) {
        this.colleges = colleges;
    }

    public String getDemographics() {
        return demographics;
    }

    public void setDemographics(String demographics) {
        this.demographics = demographics;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }
}
