package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Acceptsample {
    private Integer sampleno;
    private Patientappli applino;
    private String sampledesc;
    private String sampleresult;
    private String advicekind;
    private String visualobservation;
    private String deelresult;
    private Integer drawnum;


    private List<Reportphoto> reportphotoList;

    private List<Samplephotodesc> samplephotodescList;

    @Override
    public String toString() {
        return "Acceptsample{" +
                "sampleno=" + sampleno +
                ", applino=" + applino +
                ", drawnum=" + drawnum +
                ", sampledesc='" + sampledesc + '\'' +
                ", sampleresult='" + sampleresult + '\'' +
                ", advicekind='" + advicekind + '\'' +
                ", visualobservation='" + visualobservation + '\'' +
                ", deelresult='" + deelresult + '\'' +
                ", reportphotoList=" + reportphotoList +
                ", samplephotodescList=" + samplephotodescList +
                '}';
    }

    public Integer getDrawnum() {
        return drawnum;
    }

    public void setDrawnum(Integer drawnum) {
        this.drawnum = drawnum;
    }

    public Integer getSampleno() {
        return sampleno;
    }

    public void setSampleno(Integer sampleno) {
        this.sampleno = sampleno;
    }

    public Patientappli getApplino() {
        return applino;
    }

    public void setApplino(Patientappli applino) {
        this.applino = applino;
    }

    public String getSampledesc() {
        return sampledesc;
    }

    public void setSampledesc(String sampledesc) {
        this.sampledesc = sampledesc;
    }

    public String getSampleresult() {
        return sampleresult;
    }

    public void setSampleresult(String sampleresult) {
        this.sampleresult = sampleresult;
    }

    public String getAdvicekind() {
        return advicekind;
    }

    public void setAdvicekind(String advicekind) {
        this.advicekind = advicekind;
    }

    public String getVisualobservation() {
        return visualobservation;
    }

    public void setVisualobservation(String visualobservation) {
        this.visualobservation = visualobservation;
    }

    public String getDeelresult() {
        return deelresult;
    }

    public void setDeelresult(String deelresult) {
        this.deelresult = deelresult;
    }

    public List<Reportphoto> getReportphotoList() {
        return reportphotoList;
    }

    public void setReportphotoList(List<Reportphoto> reportphotoList) {
        this.reportphotoList = reportphotoList;
    }

    public List<Samplephotodesc> getSamplephotodescList() {
        return samplephotodescList;
    }

    public void setSamplephotodescList(List<Samplephotodesc> samplephotodescList) {
        this.samplephotodescList = samplephotodescList;
    }

    public Acceptsample(){}
}
