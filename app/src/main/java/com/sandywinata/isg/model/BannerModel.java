package com.sandywinata.isg.model;

public class BannerModel {
    public String link_url;
    public String img_url;

    public BannerModel() {
    }

    public BannerModel(String link_url, String img_url) {
        this.link_url = link_url;
        this.img_url = img_url;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
