package com.sandywinata.isg.model;

public class DormModel {
    public String address;
    public String contact;
    public String cost;
    public String desc;
    public String dorm;
    public String facilities;
    public String img;
    public String room_type;

    public DormModel() {
    }

    public DormModel(String address, String contact, String cost, String desc, String dorm, String facilities, String img, String room_type) {
        this.address = address;
        this.contact = contact;
        this.cost = cost;
        this.desc = desc;
        this.dorm = dorm;
        this.facilities = facilities;
        this.img = img;
        this.room_type = room_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
}
