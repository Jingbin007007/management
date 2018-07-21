package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Pathologyaccept {
    private Integer acceptno;

    private Patientappli patientappli;

    private String acceptdesc;
    private String acceptresult;

    private Staff acceptdoctorid;
    private Date acceptdate;

    public Integer getAcceptno() {
        return acceptno;
    }

    public void setAcceptno(Integer acceptno) {
        this.acceptno = acceptno;
    }

    public Patientappli getPatientappli() {
        return patientappli;
    }

    public void setPatientappli(Patientappli patientappli) {
        this.patientappli = patientappli;
    }

    public String getAcceptdesc() {
        return acceptdesc;
    }

    public void setAcceptdesc(String acceptdesc) {
        this.acceptdesc = acceptdesc;
    }

    public String getAcceptresult() {
        return acceptresult;
    }

    public void setAcceptresult(String acceptresult) {
        this.acceptresult = acceptresult;
    }

    public Staff getAcceptdoctorid() {
        return acceptdoctorid;
    }

    public void setAcceptdoctorid(Staff acceptdoctorid) {
        this.acceptdoctorid = acceptdoctorid;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    @Override
    public String toString() {
        return "Pathologyaccept{" +
                "acceptno=" + acceptno +
                ", patientappli=" + patientappli +
                ", acceptdesc='" + acceptdesc + '\'' +
                ", acceptresult='" + acceptresult + '\'' +
                ", acceptdoctorid=" + acceptdoctorid +
                ", acceptdate=" + acceptdate +
                '}';
    }

    public Pathologyaccept(Integer acceptno, Patientappli patientappli, String acceptdesc, String acceptresult, Staff acceptdoctorid, Date acceptdate) {
        this.acceptno = acceptno;
        this.patientappli = patientappli;
        this.acceptdesc = acceptdesc;
        this.acceptresult = acceptresult;
        this.acceptdoctorid = acceptdoctorid;
        this.acceptdate = acceptdate;
    }

    public Pathologyaccept(){}
}
