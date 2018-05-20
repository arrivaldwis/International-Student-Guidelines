package com.sandywinata.isg.model;

import java.util.List;

public class TranscriptModel {
    public String desc;
    public String img;
    public List<FAQModel> faq;

    public TranscriptModel() {
    }

    public TranscriptModel(String desc, List<FAQModel> faq, String img) {
        this.desc = desc;
        this.faq = faq;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<FAQModel> getFaq() {
        return faq;
    }

    public void setFaq(List<FAQModel> faq) {
        this.faq = faq;
    }
}
