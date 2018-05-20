package com.sandywinata.isg.model;

public class RegistrationModel {
    public String desc;
    public String list;

    public RegistrationModel() {
    }

    public RegistrationModel(String desc, String list) {
        this.desc = desc;
        this.list = list;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
