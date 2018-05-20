package com.sandywinata.isg.model;

public class FAQModel {
    public String q;
    public String a;

    public FAQModel() {
    }

    public FAQModel(String q, String a) {
        this.q = q;
        this.a = a;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
