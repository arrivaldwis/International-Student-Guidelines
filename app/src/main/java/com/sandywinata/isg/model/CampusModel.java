package com.sandywinata.isg.model;

import java.util.ArrayList;

public class CampusModel {
    public String desc;
    public ArrayList<PhotoModel> photo;

    public CampusModel() {
    }

    public CampusModel(String desc, ArrayList<PhotoModel> photo) {
        this.desc = desc;
        this.photo = photo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<PhotoModel> getPhoto() {
        return photo;
    }

    public void setPhoto(ArrayList<PhotoModel> photo) {
        this.photo = photo;
    }
}
