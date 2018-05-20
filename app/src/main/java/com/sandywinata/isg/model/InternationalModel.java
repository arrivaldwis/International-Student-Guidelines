package com.sandywinata.isg.model;

public class InternationalModel {
    public String welcome;
    public String office;

    public InternationalModel() {
    }

    public InternationalModel(String welcome, String office) {
        this.welcome = welcome;
        this.office = office;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
