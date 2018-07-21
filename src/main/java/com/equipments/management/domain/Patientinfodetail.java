package com.equipments.management.domain;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Patientinfodetail {
    private Integer patientno;
    private String treatno;

    public Integer getPatientno() {
        return patientno;
    }

    public void setPatientno(Integer patientno) {
        this.patientno = patientno;
    }

    public String getTreatno() {
        return treatno;
    }

    public void setTreatno(String treatno) {
        this.treatno = treatno;
    }

    @Override
    public String toString() {
        return "Patientinfodetail{" +
                "patientno=" + patientno +
                ", treatno='" + treatno + '\'' +
                '}';
    }

    public Patientinfodetail() {
    }
}
