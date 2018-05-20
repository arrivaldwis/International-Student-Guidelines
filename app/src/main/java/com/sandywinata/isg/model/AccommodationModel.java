package com.sandywinata.isg.model;

import java.util.ArrayList;

public class AccommodationModel {
    public String desc;
    public ArrayList<DormModel> lx;
    public ArrayList<DormModel> zgc;
    public ArrayList<DormModel> master;
    public ArrayList<DormModel> suzhouqiao;

    public AccommodationModel() {
    }

    public AccommodationModel(String desc, ArrayList<DormModel> lx, ArrayList<DormModel> zgc, ArrayList<DormModel> master, ArrayList<DormModel> suzhouqiao) {
        this.desc = desc;
        this.lx = lx;
        this.zgc = zgc;
        this.master = master;
        this.suzhouqiao = suzhouqiao;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<DormModel> getLx() {
        return lx;
    }

    public void setLx(ArrayList<DormModel> lx) {
        this.lx = lx;
    }

    public ArrayList<DormModel> getZgc() {
        return zgc;
    }

    public void setZgc(ArrayList<DormModel> zgc) {
        this.zgc = zgc;
    }

    public ArrayList<DormModel> getMaster() {
        return master;
    }

    public void setMaster(ArrayList<DormModel> master) {
        this.master = master;
    }

    public ArrayList<DormModel> getSuzhouqiao() {
        return suzhouqiao;
    }

    public void setSuzhouqiao(ArrayList<DormModel> suzhouqiao) {
        this.suzhouqiao = suzhouqiao;
    }
}
