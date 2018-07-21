package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/21.
 */

public class Reviewdetail {
    private Integer reviewdetailno;

    private Consultation consultationno;

    private Staff reviewdoctorid;
    private Date reviewdetaildate;
    private String reviewdetailresult;
    private String reviewdetailnote;

    public Integer getReviewdetailno() {
        return reviewdetailno;
    }

    public void setReviewdetailno(Integer reviewdetailno) {
        this.reviewdetailno = reviewdetailno;
    }

    public Consultation getConsultationno() {
        return consultationno;
    }

    public void setConsultationno(Consultation consultationno) {
        this.consultationno = consultationno;
    }

    public Staff getReviewdoctorid() {
        return reviewdoctorid;
    }

    public void setReviewdoctorid(Staff reviewdoctorid) {
        this.reviewdoctorid = reviewdoctorid;
    }

    public Date getReviewdetaildate() {
        return reviewdetaildate;
    }

    public void setReviewdetaildate(Date reviewdetaildate) {
        this.reviewdetaildate = reviewdetaildate;
    }

    public String getReviewdetailresult() {
        return reviewdetailresult;
    }

    public void setReviewdetailresult(String reviewdetailresult) {
        this.reviewdetailresult = reviewdetailresult;
    }

    public String getReviewdetailnote() {
        return reviewdetailnote;
    }

    public void setReviewdetailnote(String reviewdetailnote) {
        this.reviewdetailnote = reviewdetailnote;
    }

    @Override
    public String toString() {
        return "Reviewdetail{" +
                "reviewdetailno=" + reviewdetailno +
                ", consultationno=" + consultationno +
                ", reviewdoctorid=" + reviewdoctorid +
                ", reviewdetaildate=" + reviewdetaildate +
                ", reviewdetailresult='" + reviewdetailresult + '\'' +
                ", reviewdetailnote='" + reviewdetailnote + '\'' +
                '}';
    }

    public Reviewdetail(Integer reviewdetailno, Consultation consultationno, Staff reviewdoctorid, Date reviewdetaildate, String reviewdetailresult, String reviewdetailnote) {
        this.reviewdetailno = reviewdetailno;
        this.consultationno = consultationno;
        this.reviewdoctorid = reviewdoctorid;
        this.reviewdetaildate = reviewdetaildate;
        this.reviewdetailresult = reviewdetailresult;
        this.reviewdetailnote = reviewdetailnote;
    }

    public Reviewdetail(){}
}
