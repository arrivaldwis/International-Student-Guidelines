package com.sandywinata.isg.model;

public class StartingModel {
    public String desc;
    public String month;
    public String name;
    public String url;

    public StartingModel() {
    }

    public StartingModel(String desc, String month, String name, String url) {
        this.desc = desc;
        this.month = month;
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
