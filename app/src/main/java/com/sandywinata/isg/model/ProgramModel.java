package com.sandywinata.isg.model;

import java.util.List;

public class ProgramModel {
    public String desc;
    public List<ProgramListModel> list;

    public ProgramModel() {
    }

    public ProgramModel(String desc, List<ProgramListModel> list) {
        this.desc = desc;
        this.list = list;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ProgramListModel> getList() {
        return list;
    }

    public void setList(List<ProgramListModel> list) {
        this.list = list;
    }
}
