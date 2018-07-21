package com.equipments.management.domain;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Pathologydiagnosisinfo {
    private Integer reviewno;
    private String patientname;
    private Integer applino;
    private Integer productsnum;
    private String inforclinical;
    private String drawposition;
    private String inspmethodlist;
    private Date reportdate;
    private Staff reportdoctorid;
    private String reviewresult;
    private Staff reviewdoctorid;
    private String consultationif;
    private String diagnosisstatus;

    @Override
    public String toString() {
        return "Pathologydiagnosisinfo{" +
                "reviewno=" + reviewno +
                ", patientname='" + patientname + '\'' +
                ", applino=" + applino +
                ", productsnum=" + productsnum +
                ", inforclinical='" + inforclinical + '\'' +
                ", drawposition='" + drawposition + '\'' +
                ", inspmethodlist='" + inspmethodlist + '\'' +
                ", reportdate=" + reportdate +
                ", reportdoctorid=" + reportdoctorid +
                ", reviewresult='" + reviewresult + '\'' +
                ", reviewdoctorid=" + reviewdoctorid +
                ", consultationif='" + consultationif + '\'' +
                ", diagnosisstatus='" + diagnosisstatus + '\'' +
                '}';
    }

    public Pathologydiagnosisinfo() {
    }

    public Integer getReviewno() {
        return reviewno;
    }

    public void setReviewno(Integer reviewno) {
        this.reviewno = reviewno;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getApplino() {
        return applino;
    }

    public void setApplino(Integer applino) {
        this.applino = applino;
    }

    public Integer getProductsnum() {
        return productsnum;
    }

    public void setProductsnum(Integer productsnum) {
        this.productsnum = productsnum;
    }

    public String getInforclinical() {
        return inforclinical;
    }

    public void setInforclinical(String inforclinical) {
        this.inforclinical = inforclinical;
    }

    public String getDrawposition() {
        return drawposition;
    }

    public void setDrawposition(String drawposition) {
        this.drawposition = drawposition;
    }

    public String getInspmethodlist() {
        return inspmethodlist;
    }

    public void setInspmethodlist(String inspmethodlist) {
        this.inspmethodlist = inspmethodlist;
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public Staff getReportdoctorid() {
        return reportdoctorid;
    }

    public void setReportdoctorid(Staff reportdoctorid) {
        this.reportdoctorid = reportdoctorid;
    }

    public String getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(String reviewresult) {
        this.reviewresult = reviewresult;
    }

    public Staff getReviewdoctorid() {
        return reviewdoctorid;
    }

    public void setReviewdoctorid(Staff reviewdoctorid) {
        this.reviewdoctorid = reviewdoctorid;
    }

    public String getConsultationif() {
        return consultationif;
    }

    public void setConsultationif(String consultationif) {
        this.consultationif = consultationif;
    }

    public String getDiagnosisstatus() {
        return diagnosisstatus;
    }

    public void setDiagnosisstatus(String diagnosisstatus) {
        this.diagnosisstatus = diagnosisstatus;
    }
}
