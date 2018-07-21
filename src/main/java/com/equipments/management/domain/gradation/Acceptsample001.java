package com.equipments.management.domain.gradation;

import com.equipments.management.domain.Pathologydiagnosis;
import com.equipments.management.domain.Patientappli;
import com.equipments.management.domain.Reportphoto;
import com.equipments.management.domain.Samplephotodesc;

import java.util.List;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Acceptsample001 {
    private Integer sampleno;
    private String sampledesc;
    private String sampleresult;
    private String advicekind;
    private String visualobservation;
    private String deelresult;
    private Integer drawnum;

    private List<Reportphoto> reportphotoList;
    private List<Samplephotodesc> samplephotodescList;
    private List<Pathologydraw001> pathologydraw001List;
    private Pathologydiagnosis001 pathologydiagnosis;

    public List<Pathologydraw001> getPathologydraw001List() {
        return pathologydraw001List;
    }

    public void setPathologydraw001List(List<Pathologydraw001> pathologydraw001List) {
        this.pathologydraw001List = pathologydraw001List;
    }

    public Pathologydiagnosis001 getPathologydiagnosis() {
        return pathologydiagnosis;
    }

    public void setPathologydiagnosis(Pathologydiagnosis001 pathologydiagnosis) {
        this.pathologydiagnosis = pathologydiagnosis;
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

    @Override
    public String toString() {
        return "Acceptsample001{" +
                "sampleno=" + sampleno +
                ", sampledesc='" + sampledesc + '\'' +
                ", sampleresult='" + sampleresult + '\'' +
                ", advicekind='" + advicekind + '\'' +
                ", visualobservation='" + visualobservation + '\'' +
                ", deelresult='" + deelresult + '\'' +
                ", drawnum=" + drawnum +
                ", reportphotoList=" + reportphotoList +
                ", samplephotodescList=" + samplephotodescList +
                ", pathologydraw001List=" + pathologydraw001List +
                ", pathologydiagnosis=" + pathologydiagnosis +
                '}';
    }

    public Acceptsample001(){}
}
