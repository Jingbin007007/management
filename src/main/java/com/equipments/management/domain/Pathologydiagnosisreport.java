package com.equipments.management.domain;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Pathologydiagnosisreport {
    private String patientname;
    private Integer patientage;
    private String patientdiagkind;
    private Integer applino;
    private String reviewdoctorid;
    private Date reviewdate;
    private Date printdate;

    @Override
    public String toString() {
        return "Pathologydiagnosisreport{" +
                "patientname='" + patientname + '\'' +
                ", patientage=" + patientage +
                ", patientdiagkind='" + patientdiagkind + '\'' +
                ", applino=" + applino +
                ", reviewdoctorid='" + reviewdoctorid + '\'' +
                ", reviewdate=" + reviewdate +
                ", printdate=" + printdate +
                '}';
    }

    public Pathologydiagnosisreport() {
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getPatientage() {
        return patientage;
    }

    public void setPatientage(Integer patientage) {
        this.patientage = patientage;
    }

    public String getPatientdiagkind() {
        return patientdiagkind;
    }

    public void setPatientdiagkind(String patientdiagkind) {
        this.patientdiagkind = patientdiagkind;
    }

    public Integer getApplino() {
        return applino;
    }

    public void setApplino(Integer applino) {
        this.applino = applino;
    }

    public String getReviewdoctorid() {
        return reviewdoctorid;
    }

    public void setReviewdoctorid(String reviewdoctorid) {
        this.reviewdoctorid = reviewdoctorid;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }
}
