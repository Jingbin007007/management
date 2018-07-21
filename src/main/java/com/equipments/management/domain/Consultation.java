package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/28.
 */

public class Consultation {
    private Integer consultationno;

    private Patientappli applino;
    private Date consultationdate;
    private String consultationresult;
    private String consultationnote;

    public Integer getConsultationno() {
        return consultationno;
    }

    public void setConsultationno(Integer consultationno) {
        this.consultationno = consultationno;
    }

    public Patientappli getApplino() {
        return applino;
    }

    public void setApplino(Patientappli applino) {
        this.applino = applino;
    }

    public Date getConsultationdate() {
        return consultationdate;
    }

    public void setConsultationdate(Date consultationdate) {
        this.consultationdate = consultationdate;
    }

    public String getConsultationresult() {
        return consultationresult;
    }

    public void setConsultationresult(String consultationresult) {
        this.consultationresult = consultationresult;
    }

    public String getConsultationnote() {
        return consultationnote;
    }

    public void setConsultationnote(String consultationnote) {
        this.consultationnote = consultationnote;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "consultationno=" + consultationno +
                ", applino=" + applino +
                ", consultationdate=" + consultationdate +
                ", consultationresult='" + consultationresult + '\'' +
                ", consultationnote='" + consultationnote + '\'' +
                '}';
    }

    public Consultation(){}
}
