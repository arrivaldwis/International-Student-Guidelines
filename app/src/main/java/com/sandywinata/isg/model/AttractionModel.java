package com.sandywinata.isg.model;

public class AttractionModel {
    public String about;
    public String basic;
    public String foreign;
    public String tourism;

    public AttractionModel() {
    }

    public AttractionModel(String about, String basic, String foreign, String tourism) {
        this.about = about;
        this.basic = basic;
        this.foreign = foreign;
        this.tourism = tourism;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getForeign() {
        return foreign;
    }

    public void setForeign(String foreign) {
        this.foreign = foreign;
    }

    public String getTourism() {
        return tourism;
    }

    public void setTourism(String tourism) {
        this.tourism = tourism;
    }
}
