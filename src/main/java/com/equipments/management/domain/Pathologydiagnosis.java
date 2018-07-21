package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/21.
 */

public class Pathologydiagnosis {
    private Integer diagnosisno;

    private Acceptsample sampleno;
    private String diagnosismicroscope;
    private String diagnosisspecial;
    private String diagnosispathology;
    private String diagnosisnote;
    private Date reportdate;

    private Staff reportdoctorid;



    public Integer getDiagnosisno() {
        return diagnosisno;
    }

    public void setDiagnosisno(Integer diagnosisno) {
        this.diagnosisno = diagnosisno;
    }

    public Acceptsample getSampleno() {
        return sampleno;
    }

    public void setSampleno(Acceptsample sampleno) {
        this.sampleno = sampleno;
    }

    public String getDiagnosismicroscope() {
        return diagnosismicroscope;
    }

    public void setDiagnosismicroscope(String diagnosismicroscope) {
        this.diagnosismicroscope = diagnosismicroscope;
    }

    public String getDiagnosisspecial() {
        return diagnosisspecial;
    }

    public void setDiagnosisspecial(String diagnosisspecial) {
        this.diagnosisspecial = diagnosisspecial;
    }

    public String getDiagnosispathology() {
        return diagnosispathology;
    }

    public void setDiagnosispathology(String diagnosispathology) {
        this.diagnosispathology = diagnosispathology;
    }

    public String getDiagnosisnote() {
        return diagnosisnote;
    }

    public void setDiagnosisnote(String diagnosisnote) {
        this.diagnosisnote = diagnosisnote;
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

    @Override
    public String toString() {
        return "Pathologydiagnosis{" +
                "diagnosisno=" + diagnosisno +
                ", sampleno=" + sampleno +
                ", diagnosismicroscope='" + diagnosismicroscope + '\'' +
                ", diagnosisspecial='" + diagnosisspecial + '\'' +
                ", diagnosispathology='" + diagnosispathology + '\'' +
                ", diagnosisnote='" + diagnosisnote + '\'' +
                ", reportdate=" + reportdate +
                ", reportdoctorid=" + reportdoctorid +
                '}';
    }

    public Pathologydiagnosis(){}
}
