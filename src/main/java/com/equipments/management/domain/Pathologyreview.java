package com.equipments.management.domain;


import java.util.Date;

/**
 * Created by Administrator on 2018/6/21.
 */

public class Pathologyreview {
    private Integer reviewno;

    private Patientappli applino;
    private String reviewresult;
    private String diagnosisinitial;
    private String reviewstatus;
    private String reviewnote;

    private Staff reviewdoctorid;
    private Date reviewdate;
    //2018.7.7add
    private String diagnosisstatus;
    private String consultationif;

    private Date printdate;

    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }

    public Staff getReviewdoctorid() {
        return reviewdoctorid;
    }

    public void setReviewdoctorid(Staff reviewdoctorid) {
        this.reviewdoctorid = reviewdoctorid;
    }

    public Integer getReviewno() {
        return reviewno;
    }

    public void setReviewno(Integer reviewno) {
        this.reviewno = reviewno;
    }

    public Patientappli getPatientappli() {
        return applino;
    }

    public void setPatientappli(Patientappli applino) {
        this.applino = applino;
    }

    public String getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(String reviewresult) {
        this.reviewresult = reviewresult;
    }

    public String getDiagnosisinitial() {
        return diagnosisinitial;
    }

    public void setDiagnosisinitial(String diagnosisinitial) {
        this.diagnosisinitial = diagnosisinitial;
    }

    public String getReviewstatus() {
        return reviewstatus;
    }

    public void setReviewstatus(String reviewstatus) {
        this.reviewstatus = reviewstatus;
    }

    public String getReviewnote() {
        return reviewnote;
    }

    public void setReviewnote(String reviewnote) {
        this.reviewnote = reviewnote;
    }

    public Patientappli getApplino() {
        return applino;
    }

    public void setApplino(Patientappli applino) {
        this.applino = applino;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    public String getDiagnosisstatus() {
        return diagnosisstatus;
    }

    public void setDiagnosisstatus(String diagnosisstatus) {
        this.diagnosisstatus = diagnosisstatus;
    }

    public String getConsultationif() {
        return consultationif;
    }

    public void setConsultationif(String consultationif) {
        this.consultationif = consultationif;
    }

    @Override
    public String toString() {
        return "Pathologyreview{" +
                "reviewno=" + reviewno +
                ", applino=" + applino +
                ", reviewresult='" + reviewresult + '\'' +
                ", diagnosisinitial='" + diagnosisinitial + '\'' +
                ", reviewstatus='" + reviewstatus + '\'' +
                ", reviewnote='" + reviewnote + '\'' +
                ", reviewdoctorid=" + reviewdoctorid +
                ", reviewdate=" + reviewdate +
                ", diagnosisstatus='" + diagnosisstatus + '\'' +
                ", consultationif='" + consultationif + '\'' +
                ", printdate=" + printdate +
                '}';
    }

    public Pathologyreview(){}
}
