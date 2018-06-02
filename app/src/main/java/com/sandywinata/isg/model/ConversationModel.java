package com.sandywinata.isg.model;

public class ConversationModel {
    public String english;
    public String pinyin;
    public String mandarin;
    public String music_url;

    public ConversationModel() {
    }

    public ConversationModel(String english, String pinyin, String mandarin, String music_url) {
        this.english = english;
        this.pinyin = pinyin;
        this.mandarin = mandarin;
        this.music_url = music_url;
    }

    public String getMusic_url() {
        return music_url;
    }

    public void setMusic_url(String music_url) {
        this.music_url = music_url;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getMandarin() {
        return mandarin;
    }

    public void setMandarin(String hanzi) {
        this.mandarin = hanzi;
    }
}
