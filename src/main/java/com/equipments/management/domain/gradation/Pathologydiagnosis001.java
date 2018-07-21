package com.equipments.management.domain.gradation;

import com.equipments.management.domain.Acceptsample;
import com.equipments.management.domain.Doctoradvice;
import com.equipments.management.domain.Staff;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Pathologydiagnosis001 {
    private Integer diagnosisno;

    private String diagnosismicroscope;
    private String diagnosisspecial;
    private String diagnosispathology;
    private String diagnosisnote;
    private Date reportdate;

    private Staff reportdoctorid;

    private List<Doctoradvice001> doctoradvice001List;

    @Override
    public String toString() {
        return "Pathologydiagnosis001{" +
                "diagnosisno=" + diagnosisno +
                ", diagnosismicroscope='" + diagnosismicroscope + '\'' +
                ", diagnosisspecial='" + diagnosisspecial + '\'' +
                ", diagnosispathology='" + diagnosispathology + '\'' +
                ", diagnosisnote='" + diagnosisnote + '\'' +
                ", reportdate=" + reportdate +
                ", reportdoctorid=" + reportdoctorid +
                ", doctoradvice001List=" + doctoradvice001List +
                '}';
    }

    public List<Doctoradvice001> getDoctoradvice001List() {
        return doctoradvice001List;
    }

    public void setDoctoradvice001List(List<Doctoradvice001> doctoradvice001List) {
        this.doctoradvice001List = doctoradvice001List;
    }

    public Integer getDiagnosisno() {
        return diagnosisno;
    }

    public void setDiagnosisno(Integer diagnosisno) {
        this.diagnosisno = diagnosisno;
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



    public Pathologydiagnosis001(){}
}
