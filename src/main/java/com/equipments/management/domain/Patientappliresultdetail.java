package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/4.
 */

public class Patientappliresultdetail {
    private Integer applino;
    private String patientdiagkind;
    private String specialrequire;
    private String advicestatus;
    private String inspmethodlist;
    private Integer samplenum;

    private Patientinfo patientinfo;

    public String getInspmethodlist() {
        return inspmethodlist;
    }

    public void setInspmethodlist(String inspmethodlist) {
        this.inspmethodlist = inspmethodlist;
    }

    public Integer getSamplenum() {
        return samplenum;
    }

    public void setSamplenum(Integer samplenum) {
        this.samplenum = samplenum;
    }

    @Override
    public String toString() {
        return "Patientappliresultdetail{" +
                "applino=" + applino +
                "samplenum=" + samplenum +
                ", patientdiagkind='" + patientdiagkind + '\'' +
                ", specialrequire='" + specialrequire + '\'' +
                ", advicestatus='" + advicestatus + '\'' +
                ", inspmethodlist='" + inspmethodlist + '\'' +
                ", patientinfo=" + patientinfo +
                '}';
    }


    public Integer getApplino() {
        return applino;
    }

    public void setApplino(Integer applino) {
        this.applino = applino;
    }

    public String getPatientdiagkind() {
        return patientdiagkind;
    }

    public void setPatientdiagkind(String patientdiagkind) {
        this.patientdiagkind = patientdiagkind;
    }

    public String getSpecialrequire() {
        return specialrequire;
    }

    public void setSpecialrequire(String specialrequire) {
        this.specialrequire = specialrequire;
    }

    public String getAdvicestatus() {
        return advicestatus;
    }

    public void setAdvicestatus(String advicestatus) {
        this.advicestatus = advicestatus;
    }

    public Patientinfo getPatientinfo() {
        return patientinfo;
    }

    public void setPatientinfo(Patientinfo patientinfo) {
        this.patientinfo = patientinfo;
    }

    public Patientappliresultdetail() {
    }
}
