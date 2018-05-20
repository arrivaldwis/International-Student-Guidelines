package com.sandywinata.isg.model;

public class ChineseProgramModel {
    public String desc;
    public String desc2;
    public String pic;

    public ChineseProgramModel() {
    }

    public ChineseProgramModel(String desc, String desc2, String pic) {
        this.desc = desc;
        this.desc2 = desc2;
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
