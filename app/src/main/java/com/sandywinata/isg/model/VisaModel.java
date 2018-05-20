package com.sandywinata.isg.model;

public class VisaModel {
    public String application;
    public String doc;

    public VisaModel() {
    }

    public VisaModel(String application, String doc) {
        this.application = application;
        this.doc = doc;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
